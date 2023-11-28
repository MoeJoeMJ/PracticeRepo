# Services

- A `[Service](https://developer.android.com/reference/android/app/Service)` is an [application component](https://developer.android.com/guide/components/fundamentals#Components) that can perform long-running operations in the background
- a service can handle network transactions, play music, perform file I/O, or interact with a content provider, all from the background.
- A service runs in the main thread of its hosting process; the service does **not** create its own thread and does **not** run in a separate process unless you specify otherwise. You should run any blocking operations on a [separate thread](https://developer.android.com/training/multiple-threads) within the service to avoid Application Not Responding (ANR) errors.
- three different types of services:
- Foreground-
    - A foreground service performs some operation that is noticeable to the user.
    - For example, an audio app would use a foreground service to play an audio track.
    - Foreground services must display a [Notification](https://developer.android.com/develop/ui/views/notifications). Foreground services continue running even when the user isn't interacting with the app.
    - This notification cannot be dismissed unless the service is either stopped or removed from the foreground.
- Background -
    - A background service performs an operation that isn't directly noticed by the user.
    - For example, if an app used a service to compact its storage, that would usually be a background service.
    - If your app targets API level 26 or higher, the system imposes [restrictions on running background services](https://developer.android.com/about/versions/oreo/background) when the app itself isn't in the foreground. In most situations, for example, you shouldn't [access location information from the background](https://developer.android.com/training/location/background). Instead, [schedule tasks using WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager).
- If a component starts the service by calling `[startService()](https://developer.android.com/reference/android/content/Context#startService(android.content.Intent))` (which results in a call to `[onStartCommand()](https://developer.android.com/reference/android/app/Service#onStartCommand(android.content.Intent,%20int,%20int))`), the service continues to run until it stops itself with `[stopSelf()](https://developer.android.com/reference/android/app/Service#stopSelf())` or another component stops it by calling `[stopService()](https://developer.android.com/reference/android/content/Context#stopService(android.content.Intent))`.
- You must declare all services in your application's manifest file
- You can ensure that your service is available to only your app by including the `[android:exported](https://developer.android.com/guide/topics/manifest/service-element#exported)` attribute and setting it to `false`.
- In order to avoid having your service stopped accidentally by users, you need to add the **`[android:description](https://developer.android.com/guide/topics/manifest/service-element#desc)`** attribute to the **`[<service>](https://developer.android.com/guide/topics/manifest/service-element)`** element in your app manifest. In the description, provide a short sentence explaining what the service does and what benefits it provides.
- he service can run in the background indefinitely, even if the component that started it is destroyed.
- the service should stop itself when its job is complete by calling `[stopSelf()](https://developer.android.com/reference/android/app/Service#stopSelf())`, or another component can stop it by calling `[stopService()](https://developer.android.com/reference/android/content/Context#stopService(android.content.Intent))`.

## Foreground service

- If the action is of low enough importance that you want to use a minimum-priority notification, create a [background task](https://developer.android.com/topic/performance/scheduling#categories_of_background_tasks) instead.
- If you want the notification non-dismissable by the user, pass `true` into the `[setOngoing()](https://developer.android.com/reference/android/app/Notification.Builder#setOngoing(boolean))` method when you create your notification using `Notification.Builder`.
- If your multiple types apply to your service, separate them with the `|` operator. For example, a service that uses the camera and microphone would declare it like this: `android:foregroundServiceType="camera|microphone"`
- Each [foreground service type](https://developer.android.com/guide/components/fg-service-types) has a corresponding permission type. For example, if an app launches a foreground service that uses the camera, you must request both the `[FOREGROUND_SERVICE](https://developer.android.com/reference/android/Manifest.permission#FOREGROUND_SERVICE)` and `[FOREGROUND_SERVICE_CAMERA](https://developer.android.com/reference/android/Manifest.permission#FOREGROUND_SERVICE_CAMERA)` permissions.
- To remove the service from the foreground, call `[stopForeground()](https://developer.android.com/reference/android/app/Service#stopForeground(boolean))`
- To test that your app behaves as expected while and after a user stops your app, run the following ADB command in a terminal window:

`$ adb shell cmd activity stop-app PACKAGE_NAME`

- Your app can [start an activity from the background](https://developer.android.com/guide/components/activities/background-starts), except for the case where the app has an activity in the back stack of an existing task.

## Bound Services

- A bound service typically lives only while it serves another application component and does not run in the background indefinitely.
- You can create a service that is both started and bound, allowing it to run indefinitely and be bound to by clients.
- If you need to interact with the service only while your activity is visible, bind during `[onStart()](https://developer.android.com/reference/android/app/Activity#onStart())` and unbind during `[onStop()](https://developer.android.com/reference/android/app/Activity#onStop())`
- • If you want your activity to receive responses even while it is stopped in the background, bind during `[onCreate()](https://developer.android.com/reference/android/app/Activity#onCreate(android.os.Bundle))` and unbind during `[onDestroy()](https://developer.android.com/reference/android/app/Activity#onDestroy())`. Beware that this implies that your activity needs to use the service the entire time it's running, even in the background, so when the service is in another process, then you increase the weight of the process and it is more likely to be killed by the system.
- You *don't* usually bind and unbind during your activity's **`[onResume()](https://developer.android.com/reference/android/app/Activity#onResume())`** and **`[onPause()](https://developer.android.com/reference/android/app/Activity#onPause())`** callbacks, because these callbacks occur at every lifecycle transition

## AIDL

- One process can't normally access the memory of another process. To talk, they need to decompose their objects into primitives that the operating system can understand and marshall the objects across that boundary for you.
- AIDL is a tool that helps define how different processes (parts of your device) can talk to each other.
- **Defining rules:** AIDL lets you define a set of rules, much like a language, that both processes understand. This language specifies how they will exchange information
- **Generating Code:**
    - Once you've written down these rules in a file with a .aidl extension, AIDL tools generate code based on your specifications.
    - This generated code includes interfaces and methods that act as a contract between the processes. It's like creating a shared understanding of how they'll interact.
- **Implementing the Interface:**
    - The process that has the data or functionality (let's say Process A) implements this generated interface. This means writing the actual code for the defined methods.
    - The interface acts as a bridge, allowing other processes to access the functionality in a standardized way.
- **Exposing the Interface:**
    - Now, Process A exposes this interface so that other processes (like Process B) can bind to it.
    - Binding is like making a connection between two processes so they can talk to each other.