# 1.1.4

- Updated Kotlin to `1.3.50`
- Updated Ktor to `1.2.4` (Including serialization `0.12.0`)
- Renamed `findFirstObject` to `findObject`
- Renamed `getObjectIDPosition` to `getObjectPosition`
- Added `indexLanguages` DSL
- Added DSL for `Language`
- Fix serialization error in `PartialUpdateObject.from` method

# 1.1.3

- Removed `Index.searchDisjunctiveFacets` method
- New `Index.advancedSearch` for both disjunctive and hierarchical search
- New `FilterGroup.And.Hierarchical` class
- New `getSecuredApiKeyRemainingValidity` method on `APIKey`
- New `indexLanguages` field in `Settings`
- New `alternative` field in `Rule.condition`
- New `ResponseSearch.Hit.getObjectIDPosition` method
- New `findFirstObject` method

# 1.1.2

- Ktor version 1.2.3
- Minimum version of Kotlin is now 1.3.41

# 1.1.1

- `Compression` is `None` by default
- Added new `searchHierarchical method`

# 1.1.0

- Kotlin version 1.3.41
- Ktor version 1.2.3-rc
- Added `enableABTest` as `Query` parameter
- Added `similarQuery` as `Query` parameter
- Added `advancedSyntaxFeatures` as `Query` parameter
- Added `index.exists()` method
- New `AlgoliaSearchClient` object exposes library version constant
- Added `Compression` feature. `Gzip` compression is enabled by default.
- Default `readTimeout` has been increased to 5 seconds
- It is now possible to configure `HttpClientConfig` in `Configuration`
- Added `ClientPlaces` to access Algolia Places endpoints. See this [file](docs/Places.md) for getting starting with Places.
- `QueryLanguage` is renamed to `Language`
- Fixed a bug in `browseAllABTests` methods