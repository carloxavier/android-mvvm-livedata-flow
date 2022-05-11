# Android MVVM Sample

🚧 work in progress 🚧 --> see below a list of missing things

## Features

- Use of Jetpack ViewModel to offer the UI-state, with awareness of the UI lifecycle
- Jetpack LiveData for observing the UI-state
- Using Kotlin Flows for observing the data layer
- Retrofit2 + Moshi + OkHttpClient for getting data from the network, using private key authentication
- Dependency injection with Hilt

## Missing

- Implement detail screen, using single-activity and multi-fragment pattern and Jetpack Navigation
- The error handling is missing: i.e. currently the app is crashing on a network error
- Encapsulating the ui state in a data class, i.e. CharactersListUiState
- Extracting the bussiness logic from the viewmodel into a usecase
- Cover usecases with unit tests, by mocking the repository