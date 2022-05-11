# Android MVVM Sample

🚧 work in progress 🚧 --> see below for still-pending items

## Included so far

- Use of Jetpack ViewModel to offer the UI-state, with awareness of the UI lifecycle
- Jetpack LiveData for observing the UI-state
- Using Kotlin Flows for observing the data layer
- Retrofit2 + Moshi + OkHttpClient for getting data from the network, using private key authentication
- Dependency injection with Hilt

## Still Pending 

- Implement detail screen and use Jetpack Navigation
- The error handling is missing: show error message
- Cover usecases with unit tests, by mocking the repository