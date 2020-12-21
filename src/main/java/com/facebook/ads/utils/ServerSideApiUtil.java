/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 * <p>
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify, and
 * distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 * <p>
 * As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

 package com.facebook.ads.utils;

 import com.google.common.hash.Hashing;

 import java.nio.charset.StandardCharsets;
 import java.util.*;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;


 public class ServerSideApiUtil {

   // Email Pattern
   private static Pattern emailPattern =
       Pattern.compile(
           "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");

   private static Pattern SHA256RegEx = Pattern.compile("^[a-zA-Z0-9]{64}");
   private static Pattern MD5RegEx = Pattern.compile("^[a-zA-Z0-9]{32}");

   private static final Set<String> ISO_COUNTRY_LIST = ServerSideApiUtil.GetISOCountryCodeList();

   private static final Set<String> ISO_CURRENCY_LIST = ServerSideApiUtil.GetISOCurrencyCodeList();

   public static String hash(String input) {
     return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();
   }


   /**
    * Checks whether the input is already hashed with SHA256 or MD5.
    *
    * @param input value that need to be validated.
    * @return bool representing the whether the input is hashed
    */
   public static boolean isAlreadyHashed(String input) {

     Matcher md5Matcher = MD5RegEx.matcher(input);
     Matcher shaMatcher = SHA256RegEx.matcher(input);

     return md5Matcher.matches() || shaMatcher.matches();
   }

   /**
    * Gets the normalized value of the {@code token} field, given the {@code}
    *
    * @param token or value that has to be normalized
    * @param fieldName/Type of the token
    * @return the normalized token value for the given type
    */
   public static String normalize(String token, String fieldName) {
     if (fieldName == null) {
       throw new IllegalArgumentException("fieldName is required for normalizing a particular type");
     }

     token = token.trim().toLowerCase();
     if ("".equals(token)) {
       return null;
     }
     String result = token;

     if(ServerSideApiConstants.EMAIL.equals(fieldName)) {
       result = validateEmail(token);
     } else if (ServerSideApiConstants.PHONE_NUMBER.equals(fieldName)) {
       result = normalizePhoneNumber(token);
     } else if (ServerSideApiConstants.ZIP_CODE.equals(fieldName)) {
       result = normalizePostalCode(token);
     } else if (ServerSideApiConstants.CITY.equals(fieldName)) {
       result = normalizeCity(token);
     } else if (ServerSideApiConstants.COUNTRY.equals(fieldName)) {
       result = normalizeCountry(token);
     } else if (ServerSideApiConstants.STATE.equals(fieldName)) {
       result = normalizeState(token);
     } else if (ServerSideApiConstants.CURRENCY.equals(fieldName)) {
       result = normalizeCurrency(token);
     } else if (ServerSideApiConstants.F5FIRST.equals(fieldName)) {
       result = normalizeF5name(token);
     } else if (ServerSideApiConstants.F5LAST.equals(fieldName)) {
       result = normalizeF5name(token);
     } else if (ServerSideApiConstants.FI.equals(fieldName)) {
       result = normalizeFi(token);
     } else if (ServerSideApiConstants.DOBD.equals(fieldName)) {
       result = normalizeDobd(token);
     } else if (ServerSideApiConstants.DOBM.equals(fieldName)) {
       result = normalizeDobm(token);
     } else if (ServerSideApiConstants.DOBY.equals(fieldName)) {
       result = normalizeDoby(token);
     }

     return result;
   }

   private static String normalizeCity(String city) {
     city = city.replaceAll("[0-9]", "");

     // Remove spaces between city Names. Eg Menlo Park => menlopark
     city = city.replaceAll(" ", "");

     // Replace all special characters in city Name. // Washington D.C -> washingtondc
     city = city.replaceAll("[\\-\\+\\.\\^:,\\{\\}\\(\\)\\$]", "");

     return city;
   }

   private static String normalizeCountry(String country) {

     // Retain only alpha characters bounded for ISO country code.
     country = country.replaceAll("[^a-z]", "");

     if (!ISO_COUNTRY_LIST.contains(country)) {
       throw new IllegalArgumentException("Invalid format for country:'" + country + "'. Please follow 2-letter ISO 3166-1 standard for representing country. eg: us");
     }

     return country;
   }

   private static String normalizeCurrency(String currency) {

     // Retain only alpha characters bounded for ISO currency code.
     currency = currency.replaceAll("[^a-z]", "");

     if (!ISO_CURRENCY_LIST.contains(currency)) {
       throw new IllegalArgumentException("Invalid format for currency:'" + currency + "'. Please follow 3-letter ISO 4217 standard for representing currency. Eg: usd");
     }

     return currency;
   }

   private static String normalizePhoneNumber(String phoneNumber) {

     // Replace white spaces and hyphens
     phoneNumber = phoneNumber.replaceAll("[\\-\\s\\(\\)]+", "");

     if(phoneNumber.length() < 6 || phoneNumber.length() > 15){
       throw  new IllegalArgumentException("Invalid phone number format for the passed phone number:" + phoneNumber + ". Please check the passed phone number format.");
     }

     return phoneNumber;
   }

   private static String validateEmail(String email) {

     if (!isValidEmail(email)) {
      throw new IllegalArgumentException("Invalid email format for the passed email:" + email + ". Please check the passed email format.");
     }

     return email;
   }

   private static String normalizePostalCode(String postalCode) {

     // Remove space characters in the Zip Code
     postalCode = postalCode.replaceAll("[\\s]+", "");

     // If the code has more than one part, retain the first part.
     postalCode = postalCode.split("-")[0];

     if (postalCode.length() < 2) {
       throw new IllegalArgumentException("Invalid postalcode format for the passed postalCode:" + postalCode + ". Please check the passed postalcode.");
     }

     return postalCode;
   }

   private static String normalizeState(String state) {

     // States should have no punctuations, no special characters, no white space.
     // Also for US, It should be 2 Character codes.
     state = state.replaceAll("[^a-z]", "");
     return state;
   }

   private static String normalizeF5name(String name) {
     return name.substring(0, Math.min(5, name.length()));
   }

   private static String normalizeFi(String token) {
     if (token.length() > 1) {
       token = token.substring(0, 1);
     }

     return token;
   }

   private static String normalizeDobd(String input) {
     String dobd = input;
     if (dobd.length() == 1) {
       dobd = "0" + dobd;
     }

     int dobdInt;
     try {
       dobdInt = Integer.parseInt(dobd);
     } catch (NumberFormatException e) {
       throw new IllegalArgumentException("Invalid dobd: '" + input + "'. Please specify the day in 'DD' format.");
     }

     if (dobd.length() > 2 || dobdInt < 1 || dobdInt > 31) {
       throw new IllegalArgumentException("Invalid dobd: '" + input + "'. Please specify the day in 'DD' format.");
     }

     return dobd;
   }

   private static String normalizeDobm(String input) {
     String dobm = input;
     if (dobm.length() == 1) {
       dobm = "0" + dobm;
     }

     int dobmInt;
     try {
       dobmInt = Integer.parseInt(dobm);
     } catch (NumberFormatException e) {
       throw new IllegalArgumentException("Invalid dobm: '" + input + "'. Please specify the month in 'MM' format.");
     }

     if (dobm.length() > 2 || dobmInt < 1 || dobmInt > 12) {
       throw new IllegalArgumentException("Invalid dobm: '" + input + "'. Please specify the month in 'MM' format.");
     }

     return dobm;
   }

   private static String normalizeDoby(String doby) {
     if (!doby.matches("^[0-9]{4}$")) {
       throw new IllegalArgumentException("Invalid doby: '" + doby + "'. Please specify the year in 'YYYY' format.");
     }

     return doby;
   }

   /**
    * Validate email against RFC822 format
    * @param email string representing an email
    * @return the bool if the email is in valid format.
    */
   private static boolean isValidEmail(String email) {
     Matcher m = emailPattern.matcher(email);
     return m.matches();
   }

   private static HashSet<String> GetISOCurrencyCodeList(){

     Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();
     HashSet<String> currencyCodeList = new HashSet<String>();
     for(Currency currency: availableCurrencies){
       currencyCodeList.add(currency.getCurrencyCode().toLowerCase());
     }

     return currencyCodeList;
   }

   private static HashSet<String> GetISOCountryCodeList(){

     List<String> availableCountries = Arrays.asList(Locale.getISOCountries());
     HashSet<String> countryCodeList = new HashSet<String>();
     for(String country: availableCountries){
       countryCodeList.add(country.toLowerCase());
     }

     return countryCodeList;
   }
 }
