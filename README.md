# Facebook Ads SDK for Java

**IMPORTANT**: This SDK is in beta version. Please help us make improvement by reporting any issues you found.


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

Pre-compiled ``facebook-java-ads-sdk-[version].jar`` can be donwloaded from the ``/target`` folder. Alternatively, you may download the source code and compile locally with maven command: ``mvn package``. (Please install maven if it's not already there.)

The SDK also has dependency on <a href="https://github.com/google/gson">gson</a>. If it's not already in your environment, you'll need to download and add to build path.

### Run Sample code
Here is the minimal code to create a campaign in your ad account. If your app and build environments are set up correctly, this code should compile and run without error. You can verify the created campaign in <a href="https://www.facebook.com/ads/manager/">Ads Manager</a>.

```
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
        .setObjective(EnumCampaignObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(EnumCampaignStatus.VALUE_PAUSED)
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

```
APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
```
To fetch an campaign object:

```
Campaign campaign = new Campaign(CAMPAIGN_ID, context); // this only creates a new empty object
campaign = campaign.get().requestAllFields().execute(); 
// 1. get() is the API call name to get the object; 
// 2. requestAllFields() means you want all the fields. If you only want certain fields, then you can call requestXXXFields() instead, and sever response will only contain specified fields.
// 3. ***IMPORTANT*** any API calls should end with execute(), otherwise it will not be executed.
```

Or, you can use an equivalent shortcut:

```
Campaign campaign = Campaign.fetchById(CAMPAIGN_ID, context);
```

After fetching the object, you can read the data inside:

```
String id = campaign.getFieldId();
String name = campaign.getFieldName();
// Note that the methods to read field data are getFieldXXX(). This is to distinguish method names of field data from method names of API GET calls.
```

### Update and Delete
**Update**:

```
campaign.update()
        .setName("Updated Java SDK Test Campaign") // set parameter for the API call
        .execute();
```

**Delete**:

```
campaign.delete().execute();
```

### Edge Read and Write (Create Object)
Edge is a relational concept in Graph API. 

For example, if you want to know all the campaigns under an ad account, then you call GET on the ``campaigns`` edge from the ad account object. 

Or, if you want to create a new campaign under this account, then you call POST (create) on the ``campaigns`` edge of ad account.

#### Read:

```
AdAccount account = new AdAccount(ACCOUNT_ID, context);
APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
for(Campaign campaign : campaigns) {
	System.out.println(campaign.getFieldName());
}
```

** Important **: Handling pagination:
Most edge APIs have default pagination, which returns a limited number of objects (~30 objects) instead of the entire list. If you want to load more, you need to make a separate API call. In our SDK, you can call to ``nextPage()`` get next page:

```
campaigns = campaigns.nextPage();
```

#### Write (create object):

Most objects are under ad account. So you may always want to try account.createXXX() to create an object.

```
AdAccount account = new AdAccount(ACCOUNT_ID, context);
Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(EnumCampaignObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(EnumCampaignStatus.VALUE_PAUSED)
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

      Targeting targeting = new Targeting()
        .setFieldGeoLocations(new(TargetingGeoLocation()
          .setFieldCountries(Arrays.asList(new String[]{"US"})
        ));
      
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      BatchRequest batch = new BatchRequest(context);
      account.createCampaign()
        .setName("Java SDK Batch Test Campaign")
        .setObjective(EnumCampaignObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(EnumCampaignStatus.VALUE_PAUSED)
        .addToBatch(batch, "campaignRequest");
      account.createAdSet()
        .setName("Java SDK Batch Test AdSet")
        .setCampaignId("{result=campaignRequest:$.id}")
        .setStatus(EnumAdSetStatus.VALUE_PAUSED)
        .setBillingEvent(EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .addToBatch(batch, "adsetRequest");
      List<APIResponse> responses = batch.execute();
      // responses contains the result of each API call in order. However, if the API calls have dependency, then some result could be null.

