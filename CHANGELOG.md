# Changelog

All notable changes to this project will be documented in this file.


## Unreleased

## v13.0.0


### Added
- Ignore empty UserData fields when serializing

## v11.0.0


### Changed
- Graph API call upgrade to [v11.0]https://developers.facebook.com/docs/graph-api/changelog/version11.0

## v10.0.1


### Added
- Support for sending multiple values for certain UserData parameters to Conversions API.

## v10.0.0

### Changed
- Graph API call upgrade to [v10.0](https://developers.facebook.com/docs/graph-api/changelog/version10.0)

## v9.0.1


### Added
- `action_source` field to Event for Conversions API.

## v9.0.0
### Changed
- Graph API call upgrade to [v9.0](https://developers.facebook.com/docs/graph-api/changelog/version9.0)

### Added
- `delivery_category` field to Content for Conversions API.

## v8.0.4

### Fixed
- Stop sending empty hashed strings when normalizing params.

## v8.0.3

### Added
- Added HttpServiceInterface to enable the default request object to be overridden by a user-defined HTTP Request Service object. Available for Conversions API create event requests.
- Added batching to Conversions API. Create batched event requests by using BatchProcessor.

## v8.0.0
### Changed
- Graph API call upgrade to [v8.0](https://developers.facebook.com/docs/graph-api/changelog/version8.0)

## v7.2.1
### Added
- Added support for data processing options in Serverside API. For more details see : https://developers.facebook.com/docs/marketing-apis/data-processing-options

## v7.0.0
### Changed
- Graph API call upgrade to [v7.0](https://developers.facebook.com/docs/graph-api/changelog/version7.0)

## v6.0.0
### Changed
  - Graph API call upgrade to [v6.0](https://developers.facebook.com/docs/graph-api/changelog/version6.0)

## v5.0.5
### Added
  - Server-side API added search_string to CustomData.

## v5.0.3
### Added
  - Added function `getHeader()` in APIException class which provides header information
  - Made `omit_response_on_success` configurable for addToBatch method in APIRequest

## v5.0.1
### Added
  - Added `CrashRepoter`, more context available [here](https://developers.facebook.com/docs/business-sdk/guides/crash-reports)

## v5.0.0
### Changed
- Graph API call upgrade to [v5.0](https://developers.facebook.com/docs/graph-api/changelog/version5.0)

## v4.0.8

 - Added strongly typed Server-Side API with normalization for Web (https://developers.facebook.com/docs/marketing-api/facebook-pixel/server-side-api/using-the-api)

## v4.0.6

### Fixed
 - Add back `source` param in `APIRequestCreateAdVideo`.

## v4.0.0
### Changed
- Graph API call upgrade to [v4.0](https://developers.facebook.com/docs/graph-api/changelog/version4.0)

## v3.3.1
### Changed
- Remove list of API call from Business SDK,   [here](https://developers.facebook.com/docs/graph-api/changelog/4-30-2019-endpoint-deprecations)

## v3.3.0
### Changed
- Graph API call upgrade to [v3.3](https://developers.facebook.com/docs/graph-api/changelog/version3.3)


