# Broadcasts

- Android apps can send or receive broadcast messages from the Android system and other Android apps, similar to the [publish-subscribe](https://en.wikipedia.org/wiki/Publish%E2%80%93subscribe_pattern) design pattern
- Apps can also send custom broadcasts, for example, to notify other apps of something that they might be interested in (for example, some new data has been downloaded).
- Apps that need low-latency interprocess communication should consider [bound services](https://developer.android.com/guide/components/bound-services).
- Apps can register to receive specific broadcasts. When a broadcast is sent, the system automatically routes broadcasts to apps that have subscribed to receive that particular type of broadcast.
- Note: Whenever possible, keep broadcasts private to your app.
- The broadcast message itself is wrapped in an `[Intent](https://developer.android.com/reference/android/content/Intent)` object whose action string identifies the event that occurred (for example `android.intent.action.AIRPLANE_MODE`)
- The intent may also include additional information bundled into its extra field. For example, the airplane mode intent includes a boolean extra that indicates whether or not Airplane Mode is on.
- Android 14 -While apps are in a [cached state](https://developer.android.com/guide/components/activities/process-lifecycle), broadcast delivery is optimized for system health

For example, less important system broadcasts such as `[ACTION_SCREEN_ON](https://developer.android.com/reference/android/content/Intent#ACTION_SCREEN_ON)` are deferred while the app is in a cached state.

- Apps can receive broadcasts in two ways: through manifest-declared receivers and context-registered receivers.
- **android.intent.action.BOOT_COMPLETED -** This ensures that users continue to receive messages even if they haven't explicitly opened the app after a device restart.
- If many apps have registered to receive the same broadcast in their manifest, it can cause the system to launch a lot of apps, causing a substantial impact on both device performance and user experience. To avoid this, prefer using context registration over manifest declaration. Sometimes, the Android system itself enforces the use of context-registered receivers. For example, the `[CONNECTIVITY_ACTION](https://developer.android.com/reference/android/net/ConnectivityManager#CONNECTIVITY_ACTION)` broadcast is delivered only to context-registered receivers.
- Do not broadcast sensitive information using an implicit intent. The information can be read by any app that registers to receive the broadcast. There are three ways to control who can receive your broadcasts:
    - You can specify a permission when sending a broadcast.
    - In Android 4.0 and higher, you can specify a [package](https://developer.android.com/guide/topics/manifest/manifest-element#package) with `[setPackage(String)](https://developer.android.com/reference/android/content/Intent#setPackage(java.lang.String))` when sending a broadcast. The system restricts the broadcast to the set of apps that match the package.
- When you register a receiver, any app can send potentially malicious broadcasts to your app's receiver. There are several ways to limit the broadcasts that your app receives:
    - You can specify a permission when registering a broadcast receiver.
    - For manifest-declared receivers, you can set the [android:exported](https://developer.android.com/guide/topics/manifest/receiver-element#exported) attribute to "false" in the manifest. The receiver does not receive broadcasts from sources outside of the app.
- The namespace for broadcast actions is global. Make sure that action names and other strings are written in a namespace you own, or else you may inadvertently conflict with other apps.
- To perform long running work:
    - Calling `[goAsync()](https://developer.android.com/reference/android/content/BroadcastReceiver#goAsync())` in your receiver's `onReceive()` method and passing the `[BroadcastReceiver.PendingResult](https://developer.android.com/reference/android/content/BroadcastReceiver.PendingResult)` to a background thread. This keeps the broadcast active after returning from `onReceive()`. However, even with this approach the system expects you to finish with the broadcast very quickly (under 10 seconds). It does allow you to move work to another thread to avoid glitching the main thread.
    - Scheduling a job with the `[JobScheduler](https://developer.android.com/reference/android/app/job/JobScheduler)`
- Do not start activities from broadcast receivers because the user experience is jarring; especially if there is more than one receiver. Instead, consider displaying a [notification](https://developer.android.com/develop/ui/views/notifications).