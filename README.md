
# Chat Application

This project presents a Chat Application developed using Kotlin, enabling real-time communication between users. The app integrates features like text messaging leveraging Firebase for real-time database synchronization and authentication. Key functionalities include secure user login, typing indicators, and push notifications for instant messaging. The application uses Kotlin’s coroutines for efficient asynchronous operations and follows the MVVM architecture to maintain a clean, scalable codebase. Kotlin's concise syntax and safety features make it an ideal choice for developing a fast, reliable, and user-friendly chat application on Android platforms.


## Features

- Real-time messaging: Users can send and receive messages in real-time.
- Firebase Firestore: Data storage is handled by Firebase Firestore, providing a secure and fast way to store and retrieve data.
- Firebase Cloud Messaging: Notifications are handled by Firebase Cloud Messaging, allowing users to receive notifications even when the app is not open.
- MVVM architecture: The app follows the Model-View-ViewModel architecture, making it easy to maintain and scale.
- Coroutines: Coroutines are used for managing background tasks and managing the flow of data, making the app more efficient.
- Dagger Hilt: Dependency injection is handled by Dagger Hilt, making it easy to manage dependencies and improve testability.
.


## Technologies Used
- Kotlin: Primary language for app development.
- XML Layouts: For building responsive UI.
- Coroutines: For managing background tasks and asynchronous operations.
- Glide: Image loading and caching.
- Material Design Components: For building a modern UI.
Backend
- Firebase Realtime Database: For real-time message synchronization.
- Firebase Authentication: For user login and registration (email-password, Google, etc.).
- Firebase Cloud Storage: For storing shared media files (images, audio).
- Firebase Cloud Messaging (FCM): For push notifications.
- Firebase Firestore (Optional): An alternative to Realtime Database for improved querying
## Uses
- Open the app and sign in/ sign up
- Send and receive messages in real-time
- Receive notifications even when the app is not open
## Contributing

Contributions are welcome! To contribute:

- Fork the repository.
- Create a feature branch (git checkout -b feature-branch).
- - Commit your changes (git commit -m 'Add a new feature').
- Push the branch (git push origin feature-branch).
- Create a Pull Request.


## Dependencies

- Retrofit: For API requests and networking (optional, if external APIs are used).
- OkHttp: For HTTP client networking.
- Dagger/Hilt or Koin: For dependency injection.
## Installation

Install my-project 
- Clone The project
https://github.com/mehedidevv/Chat-Application.git

- Open the project in Android Studio
Setup Firebase
- Create a Firebase project in the Firebase Console.
- Add an Android app to your Firebase project and download the google-services.json file.
- Place the google-services.json file in the app directory.
- Enable Firebase Authentication, Firebase Realtime Database, and Firebase Cloud Storage.

Build The project
- Sync Gradle files and ensure all dependencies are installed.
- Build and run the app on your device or emulator.