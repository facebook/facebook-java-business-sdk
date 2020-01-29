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

   private static final Set<String> ISO_COUNTRY_LIST = new HashSet<String> (Arrays.asList(Locale.getISOCountries()));

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

     String result = token;

     token = token.trim().toLowerCase();


       if(ServerSideApiConstants.EMAIL.equals(fieldName)){
         result = validateEmail(token);
         }

       else if(ServerSideApiConstants.PHONE_NUMBER.equals(fieldName)) {
         result = normalizePhoneNumber(token);
         }

       else if(ServerSideApiConstants.ZIP_CODE.equals(fieldName)) {
         result = normalizePostalCode(token);
         }

       else if( ServerSideApiConstants.CITY.equals(fieldName)){
         result = normalizeCity(token);
         }

       else if(ServerSideApiConstants.COUNTRY.equals(fieldName)) {
         result = validateCountry(token);
         }

       else if(ServerSideApiConstants.STATE.equals(fieldName)) {
         result = normalizeState(token);
         }

       else if(ServerSideApiConstants.CURRENCY.equals(fieldName)) {
         result = validateCurrency(token);
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

   private static String validateCountry(String country) {

     if (!ISO_COUNTRY_LIST.contains(country.toUpperCase())) {
       throw new IllegalArgumentException("Invalid format for country:'" + country + "'. Please follow 2-letter ISO 3166-1 standard for representing country. eg: us");
     }

     return country;
   }

   private static String validateCurrency(String currency) {

     if (!ISO_CURRENCY_LIST.contains(currency)) {
       throw new IllegalArgumentException("Invalid format for currency:'" + currency + "'. Please follow 3-letter ISO 4217 standard for representing currency. Eg: usd");
     }

     return currency;
   }

   private static String normalizePhoneNumber(String phoneNumber) {

     // Replace white spaces and hyphens
     phoneNumber = phoneNumber.replaceAll("[\\-\\s]+", "");

     return phoneNumber;
   }

   private static String validateEmail(String email) {

     if (!isValidEmail(email)) {
       throw new IllegalArgumentException("Email should be a valid");
     }

     return email;
   }

   private static String normalizePostalCode(String postalCode) {

     // If the code has more than one part, retain the first part.
     postalCode = postalCode.split("-")[0];
     return postalCode;
   }

   private static String normalizeState(String state) {

     // States should have no punctuations, no special characters, no white space.
     // Also for US, It should be 2 Character codes.
     state = state.replaceAll("[^a-z]", "");
     return state;
   }

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
 }
