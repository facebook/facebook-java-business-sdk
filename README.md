# Facebook Ads SDK for Java

**IMPORTANT**: This SDK is now officially released for v2.9 API. Please continue to help us make improvement by reporting any issues you found.

**BREAKING CHANGES NOTES (v2.9.0)**: New Release for the Java SDK (v2.9.0) includes following breaking changes:

* **API version upgrade:** New SDK version calls Facebook Marketing API v2.9 endpoints. Classes are modified to use new fields/params/endpoints and to remove deprecated
fields/params/endpoints. Please refer to <a href="https://developers.facebook.com/docs/marketing-api/changelog">Marketing API Changelog</a> for details.

* **Version Code:** Starting from the official release, the SDK version will be maintained in the same way as other (PHP/Python) SDKs. We'll use the API_MAJOR.API_MINOR.SDK_RELEASE format, e.g. for API version v2.9, the SDK version will be v2.9.0, v2.9.1, ... There will be breaking changes when API version is changed. There is no breaking change between releases.

## Introduction
The Facebook Ads SDK for Java provides an easy interface and abstraction to the Marketing API.

``facebook-java-ads-sdk`` is a Java library that provides an interface
between your Java application and Facebook's
<a href="https://developers.facebook.com/docs/marketing-apis">Marketing API</a>. This
tutorial covers the basics knowledge needed to use the SDK with examples.


## Quick Start
### Pre-requisites

#### Register An App

To get started with the SDK, you must have a Facebook app
registered on <a href="https://developers.facebook.com/">developers.facebook.com</a>.

**IMPORTANT**: For security, it is recommended that you turn on 'App Secret
Proof for Server API calls' in your app's Settings->Advanced page.

#### Obtain An Access Token

You need to generate a user access token for your app and ask for the
``ads_management`` permission.

Learn more about access tokens <a href="https://developers.facebook.com/docs/reference/ads-api/overview/">here</a>.

For now, we can use the
<a href="https://developers.facebook.com/tools/explorer">Graph Explorer</a> to
get an access token.

### Install package

To start using Java SDK, you need add two .jar files into your project build path:

* facebook-java-ads-sdk-[version].jar
* gson-[version].jar

Pre-compiled ``facebook-java-ads-sdk-[version].jar`` can be downloaded from the ``/target`` folder. Alternatively, you may download the source code and compile locally with maven command: ``mvn package``. (Please install maven if it's not already there.)

The SDK also has dependency on <a href="https://github.com/google/gson">gson</a>. If it's not already in your environment, you'll need to download and add to build path.

### Run Sample code
Here is the minimal code to create a campaign in your ad account. If your app and build environments are set up correctly, this code should compile and run without error. You can verify the created campaign in <a href="https://www.facebook.com/ads/manager/">Ads Manager</a>.

```java
import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.EnumCampaignStatus;
import com.facebook.ads.sdk.AdAccount.EnumCampaignObjective;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.APIException;

public class QuickStartExample {

  public static final String ACCESS_TOKEN = "[Your access token]";
  public static final Long ACCOUNT_ID = [Your account ID];
  public static final String APP_SECRET = "[Your app secret]";
  
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
  public static void main(String[] args) {
    try {
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();
      System.out.println(campaign.fetch());
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
```
More examples can be found in ``/examples`` folder.

## Understanding the SDK
The SDK is consistent with the documentation of <a href="https://developers.facebook.com/docs/marketing-apis">Marketing API</a>.

### Get an object
You always need to create an APIContext before making any API calls. APIContext includes your access token and app secret:

```java
APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
```
To fetch an campaign object:

```java
Campaign campaign = new Campaign(CAMPAIGN_ID, context); // this only creates a new empty object
campaign = campaign.get().requestAllFields().execute(); 
// 1. get() is the API call name to get the object; 
// 2. requestAllFields() means you want all the fields. If you only want certain fields, then you can call requestXXXFields() instead, and sever response will only contain specified fields.
// 3. ***IMPORTANT*** any API calls should end with execute(), otherwise it will not be executed.
```

Or, you can use an equivalent shortcut:

```java
Campaign campaign = Campaign.fetchById(CAMPAIGN_ID, context);
```

After fetching the object, you can read the data inside:

```java
String id = campaign.getFieldId();
String name = campaign.getFieldName();
// Note that the methods to read field data are getFieldXXX(). This is to distinguish method names of field data from method names of API GET calls.
```

### Update and Delete
**Update**:

```java
campaign.update()
        .setName("Updated Java SDK Test Campaign") // set parameter for the API call
        .execute();
```

**Delete**:

```java
campaign.delete().execute();
```

### Edge Read and Write (Create Object)
Edge is a relational concept in Graph API. 

For example, if you want to know all the campaigns under an ad account, then you call GET on the ``campaigns`` edge from the ad account object. 

Or, if you want to create a new campaign under this account, then you call POST (create) on the ``campaigns`` edge of ad account.

#### Read:

```java
AdAccount account = new AdAccount(ACCOUNT_ID, context);
APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
for(Campaign campaign : campaigns) {
	System.out.println(campaign.getFieldName());
}
```

** Important **: Handling pagination:
Most edge APIs have default pagination, which returns a limited number of objects (~30 objects) instead of the entire list. If you want to load more, you need to make a separate API call. In our SDK, you can call to ``nextPage()`` get next page:

```java
campaigns = campaigns.nextPage();
```

#### Write (create object):

Most objects are under ad account. So you may always want to try account.createXXX() to create an object.

```java
AdAccount account = new AdAccount(ACCOUNT_ID, context);
Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();
// The create call only returns id of the new object.
// So you want to fetch() to get all the data of the object.
// fetch() is just another shortcut for 
// campaign = campaign.get().requestAllFields().execute();
campaign.fetch(); 
```

### Batch Mode

Every execute() is an HTTP request, which takes a network round trip. Facebook API does support <a href="https://developers.facebook.com/docs/graph-api/making-multiple-requests">batch mode</a>, which allows you to make multiple API calls in a single HTTP request. 

In this SDK, you can simply replace execute() with addToBatch() to prepare a batch API call. When it's ready, you call batch.execute().

Example:
```java
      BatchRequest batch = new BatchRequest(context);
      account.createCampaign()
        .setName("Java SDK Batch Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .addToBatch(batch, "campaignRequest");
      account.createAdSet()
        .setName("Java SDK Batch Test AdSet")
        .setCampaignId("{result=campaignRequest:$.id}")
        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .addToBatch(batch, "adsetRequest");
      account.createAdImage()
        .addUploadFile("file", imageFile)
        .addToBatch(batch, "imageRequest");
      account.createAdCreative()
        .setTitle("Java SDK Batch Test Creative")
        .setBody("Java SDK Batch Test Creative")
        .setImageHash("{result=imageRequest:$.images.*.hash}")
        .setLinkUrl("www.facebook.com")
        .setObjectUrl("www.facebook.com")
        .addToBatch(batch, "creativeRequest");
      account.createAd()
        .setName("Java SDK Batch Test ad")
        .setAdsetId("{result=adsetRequest:$.id}")
        .setCreative("{creative_id:{result=creativeRequest:$.id}}")
        .setStatus("PAUSED")
        .setBidAmount(100L)
        .addToBatch(batch);
      List<APIResponse> responses = batch.execute();
      // responses contains the result of each API call in order. However, if the API calls have dependency, then some result could be null.
```

### Error Handling
Currently all the errors are wrapped in ``APIException`` and its subclasses.

``MalformedResponseException`` is caused by improper parsing of server response. (likely a bug in SDK) 

``FailedRequestException`` is caused by either a client error or server failure. See details in the next section. 

The error message can be obtained by calling getMessage(), getRawResponse(), or getRawResponseAsJsonObject(). They return a json string/object of the error code and details. We have plan to improve this by adding more details and providing convenient function to get the error code.

### Customisation and Debugging

#### Enable debugging
You can enable the debug output by setting the APIContext to debug mode:

    public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true).setLogger(System.out);

This will print out the network requests and responses. By default it prints on STDOUT, but you can customise by calling .setLogger(PrintSteam)

#### Customise Network
In v0.2.0, we added APIRequest.changeRequestExecutor(IRequestExecutor), which can be used to set your own network request executor. This makes it possible to add proxy settings, automatic retry, or better network traffic management. See ``/example/NetworkCustomizationExample.java``.

Currently this is a static method because it is likely to be a global setting. If you do think object-level Customisation is needed, we'll add that functionality.

The executor needs to implement ``IRequestExecutor`` interface:

```java
    public static interface IRequestExecutor {
        public String execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    }
```

``DefaultRequestExecutor`` is used by default, and it is also a good starting point for Customisation.

#### Missing or Incorrect Request Params/Fields
It is recommended to use setXXX() or requestXXXField() to construct a proper APIRequest, which prevents mis-spelling of parameter/field names. However, if you believe that some needed params/fields are missing from these methods, you can call:

```java
    APIRequest.setParam(param, value)
    APIRequest.setParam.requestField(field, true)
```

This also works if you believe the type of the param is not correct in SDK. 

In this case, please help us make improvement by filing issues.

#### Missing Fields in Class Definition
If you believe that certain fields are returned from server, but they are missing in class definition, then you can still access those fields by fetching it from raw response:

	campaign.getRawResponseAsJsonObject().get("field").getAsString();
	
This situation can occasionally happen if new fields are added to server response while SDK is not up-to-date. We'll update the SDK periodically to include new fields.

#### Ad-hoc APIRequest
Most of Marketing API can be found in SDK classes. If you don't find the one you want to access, it is possible to construct an Ad-hoc APIRequest:

```java
    APIRequest<AdAccount> request = new APIRequest<AdAccount>(context, "me", "/adaccounts", "GET", AdAccount.getParser());
    APINodeList<AdAccount> accounts = (APINodeList<AdAccount>)(request.execute()); 
```

When constructing the APIRequest, you need to provide

* APIContext, which has the access token,
* The node ID, which is typically a long number, but it can also be some alias, like "me",
* The edge name, which should start with "/"; if it's for a Node API, then use "/"
* The HTTP Method, GET/POST/DELETE
* The parser for expected response type. You can use null if it is not in SDK, which will return APINodeList<APINode> when executed.


#### FailedRequestException Troubleshooting
There are many possible causes for a failed request:

* Incorrect parameters are provided in the API request (check <a href="https://developers.facebook.com/docs/marketing-apis">Marketing API Docs</a>)
* Permission issue (check your access token or app secret)
* SDK bug (report on Github)
* Temporary network issue (check your network and retry)
* Temporary server issue (retry, or report on <a href="https://developers.facebook.com/bugs/">Facebook Platform Bugs</a> if it happens too often)
* Server bug (report on <a href="https://developers.facebook.com/bugs/">Facebook Platform Bugs</a>)

As the first step of troubleshooting, please enable debugging in the APIContext.

Here are some hints on troubleshooting:

* If it's caused by incorrect parameters, you'll see error descriptions in the exception message.
* If it's caused by permission issue, you'll see error message like "permission denied" or "unknown path"
* If in stacktrace you see that the failed request is caused by exceptions such as NullPointerException or MalformedResponseException, it is likely a SDK bug (or your own bug, depending on the stacktrace).
* If you see in the debug message that the params sent to server don't match what you specified, it is possible that you didn't specify the param correctly, or SDK didn't assemble the request properly.
* For temporary server issue, typically retry should work after a few seconds.
* If server persistently responds with "Unknown error," then it is potentially server bug.

