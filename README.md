# Android MVVM Sample (unmaintained: see newer samples on this account)

## Included so far

- Use of Jetpack ViewModel to offer the UI-state, with awareness of the UI lifecycle
- Jetpack LiveData for observing the UI-state
- Using Kotlin Flows for observing the data layer
- Retrofit2 + Moshi + OkHttpClient for getting data from the network, using private key authentication
- Dependency injection with Hilt

## The Next steps would have been:
- Implement detail screen and use Jetpack Navigation
- The error handling is missing: show error message
- Cover usecases with unit tests, by mocking the repository
