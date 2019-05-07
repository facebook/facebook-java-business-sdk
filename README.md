# Facebook Business SDK for Java

**BREAKING CHANGES NOTES (v3.0.0)**: New Release for the Java SDK (v3.0.0) includes following breaking changes:

* **API version upgrade:** The new SDK version calls Facebook Graph API endpoints related to the Pages, Instagram, Business Manager, and Marketing products. Classes now use new fields/params/endpoints. Please refer to the <a href="https://developers.facebook.com/docs/graph-api/changelog" target="_blank">Graph API Changelog</a> for details.


## Introduction

The Facebook <a href="https://developers.facebook.com/docs/business-sdk" target="_blank">Business SDK</a> is a one-stop shop to help our partners better serve their businesses. Partners are using multiple Facebook API's to server the needs of their clients. Adopting all these API's and keeping them up to date across the various platforms can be time consuming and ultimately prohibitive. For this reason Facebook has developed the Business SDK bundling many of its APIs into one SDK to ease implementation and upkeep. The Business SDK is an upgraded version of the Marketing API SDK that includes the Marketing API as well as many Facebook APIs from different platforms such as Pages, Business Manager, Instagram, etc.

``facebook-java-business-sdk`` is a Java library that provides an interface
between your Java application and Facebook's
<a href="https://developers.facebook.com/docs/graph-api" target="_blank">Graph API</a>. This
tutorial covers the basics, including examples, needed to use the SDK.

## Quick Start

Business SDK <a href="https://developers.facebook.com/docs/business-sdk/getting-started" target="_blank">Getting Started Guide</a>

### Pre-requisites

#### Register An App

To get started with the SDK, you must have an app
registered on <a href="https://developers.facebook.com/" target="_blank">developers.facebook.com</a>.

To manage the Marketing API, please visit your <a href="https://developers.facebook.com/apps/<YOUR APP ID>/dashboard"> App Dashboard </a> and add the <b>Marketing API</b> product to your app.

**IMPORTANT**: For security, it is recommended that you turn on 'App Secret
Proof for Server API calls' in your app's Settings->Advanced page.

#### Obtain An Access Token

When someone connects with an app using Facebook Login and approves the request for permissions, the app obtains an access token that provides temporary, secure access to Facebook APIs.

An access token is an opaque string that identifies a User, app, or Page.

For example, to access the Marketing API, you need to generate a User access token for your app and ask for the ``ads_management`` permission; to access Pages API, you need to generate a Page access token for your app and ask for the ``manage_page`` permission.

Refer to our <a href="https://developers.facebook.com/docs/facebook-login/access-tokens" target="_blank">Access Token Guide</a> to learn more.

For now, we can use the <a href="https://developers.facebook.com/tools/explorer" target="_blank">Graph Explorer</a> to get an access token.

### Install package

To start using Java SDK, follow the instructions on <a href="https://developers.facebook.com/docs/business-sdk/getting-started#java">Getting started instruction</a>.

If you want to use pre-compiled .jar file, visit https://repo1.maven.org/maven2/com/facebook/business/sdk/facebook-java-business-sdk/ to download specific version. If you download the one without dependencies, you will need to download all dependent .jar files and add them to your path when build and run. Use the .pom file in the version directory to decide dependencies.

### Run Sample code
Here is the minimal code needed to create a campaign in your ad account. If your app and build environments are set up correctly, this code should compile and run without error. You can verify the created campaign in <a href="https://www.facebook.com/ads/manager/" target="_blank">Ads Manager</a>.

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
More examples can be found in the `/examples` folder.

## Understanding the Business SDK
Please see the <a href="https://developers.facebook.com/docs/business-sdk" target="_blank">Business SDK Documentation</a> for more information about implementation and common scenarios. The Business SDK is consistent with v3.0 endpoints related to Pages, Business Manager, Instagram and Marketing products. Please refer to <a href="https://developers.facebook.com/docs/business-sdk/reference" target="_blank">APIs within the Business SDK</a> to get the list of APIs that are within the Business SDK.

### Get an object
You always need to create an APIContext before making any API calls. APIContext includes your access token and app secret:

```java
APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
```
To fetch a campaign object:

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
Most edge APIs have default pagination, which returns a limited number of objects (~30 objects) instead of the entire list. If you want to load more, you need to make a separate API call. In our SDK, you can call to `nextPage()`:

```java
campaigns = campaigns.nextPage();
```

- Or, enable auto pagination iterator with:

```
campaigns = campaigns.withAutoPaginationIterator(true);
```

In this case, campaigns.iterator() will return an iterator that can fetch the next page automatically.

```
// Enhanced for loop
for(Campaign campaign : campaigns) {
	System.out.println(campaign.getFieldName());
}

// Foreach with lambda is also supported
campaigns.forEach(campaign -> System.out.println(campaign.getFieldName()));

// Note: APIException will be wrapped in a Runtime exception
```

To fetch all campaigns in your account.

With auto pagination iterator, next page will be fetched automatically in enhanced for loop and foreach loop. In this scenario, `campaign.size(), campaign.get(i)` is no longer reliable and shouldn't be used


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

Every execute() is an HTTP request, which takes a network round trip. Facebook API does support <a href="https://developers.facebook.com/docs/graph-api/making-multiple-requests" target="_blank">batch mode</a>, which allows you to make multiple API calls in a single HTTP request.

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

`MalformedResponseException` is caused by the improper parsing of a server response (likely a bug in the SDK).

``FailedRequestException`` is caused by either a client error or server failure. See details in the next section.

We have a plan to improve this by adding more details and providing a convenient function to get the error code.

### Customization and Debugging

#### Enable debugging
You can enable the debug output by setting the APIContext to debug mode:

    public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true).setLogger(System.out);

This will print out the network requests and responses. By default it prints on STDOUT, but you can customize by calling .setLogger(PrintSteam)

#### Customize Network
In v0.2.0, we added APIRequest.changeRequestExecutor(IRequestExecutor), which can be used to set your own network request executor. This makes it possible to add proxy settings, automatic retry, or better network traffic management. See ``/example/NetworkCustomizationExample.java``.

Currently this is a static method because it is likely to be a global setting. If you do think object-level Customization is needed, we'll add that functionality.

The executor needs to implement ``IRequestExecutor`` interface:

```java
    public static interface IRequestExecutor {
        public String execute(String method, String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendGet(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendPost(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
        public String sendDelete(String apiUrl, Map<String, Object> allParams, APIContext context) throws APIException, IOException;
    }
```

``DefaultRequestExecutor`` is used by default, and it is also a good starting point for Customization.

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
* The parser for the expected response type. You can use null if it is not in the SDK, which will return APINodeList<APINode> when executed.


#### FailedRequestException Troubleshooting
There are many possible causes for a failed request:

* Incorrect parameters are provided in the API request (check <a href="https://developers.facebook.com/docs/graph-api" target="_blank">Graph API Docs</a>)
* Permission issue (check your access token or app secret)
* SDK bug (report on Github)
* Temporary network issue (check your network and retry)
* Temporary server issue (retry, or report on <a href="https://developers.facebook.com/bugs/" target="_blank">Facebook Platform Bugs</a> if it happens too often)
* Server bug (report on <a href="https://developers.facebook.com/bugs/" target="_blank">Facebook Platform Bugs</a>)

As the first step of troubleshooting, please enable debugging in the APIContext.

Here are some hints on troubleshooting:

* If it's caused by incorrect parameters, you'll see error descriptions in the exception message.
* If it's caused by permission issue, you'll see error message like "permission denied" or "unknown path"
* If in stack trace you see that the failed request is caused by exceptions such as NullPointerException or MalformedResponseException, it is likely a SDK bug (or your own bug, depending on the stacktrace).
* If you see in the debug message that the params sent to server don't match what you specified, it is possible that you didn't specify the param correctly, or SDK didn't assemble the request properly.
* For temporary server issue, typically retry should work after a few seconds.
* If server persistently responds with "Unknown error," then it is potentially server bug.

## SDK Codegen
Our SDK is autogenerated from [SDK Codegen](https://github.com/facebook/facebook-business-sdk-codegen). If you want to learn more about how our SDK code is generated, please check this repository.



## License
Facebook Business SDK for Java is licensed under the LICENSE file in the root directory of this source tree.
