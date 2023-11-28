# Activity

- When one app invokes another, the calling app invokes an activity in the other app, rather than the app as an atomic whole.
- one activity implements one screen in an app
- ***Intent filters*** provide the ability to launch an activity based not only on an *explicit* request, but also an *implicit* one.
- Declaring the [<category>](https://developer.android.com/guide/topics/manifest/category-element) element as `DEFAULT` enables the activity to receive launch requests.
- The [<data>](https://developer.android.com/guide/topics/manifest/data-element) element specifies the type of data that this activity can send.
- A parent activity cannot launch a child activity unless both activities have the same permissions in their manifest.
- **`onCreate**()`
    - Fires when the system creates your activity.
    - Your implementation should initialize the essential components of your activity: For example, your app should create views and bind data to lists here.
    - Most importantly, this is where you must call `[setContentView()](https://developer.android.com/reference/android/app/Activity#setContentView(android.view.View))` to define the layout for the activity's user interface.
    - Once it finishes then the next callback is always `[onStart()](https://developer.android.com/reference/android/app/Activity#onStart())`.
- `**onStart()**`
    - the activity enters the Started state, and the activity becomes visible to the user.
    - This callback contains what amounts to the activity’s final preparations for coming to the foreground and becoming interactive.
    - For example, this method is where the code that maintains the UI is initialized.
    - The `onStart()` method completes quickly and, as with the Created state.
- `**onResume()**`
    - The system invokes this callback just before the activity starts interacting with the user.
    - At this point, the activity is at the top of the activity stack, and captures all user input.
    - Most of an app’s core functionality is implemented in the `[onResume()](https://developer.android.com/reference/android/app/Activity#onResume())` method.
    - This is the state in which the app interacts with the user. The app stays in this state until something happens to take focus away from the app, such as the device receiving a phone call, the user navigating to another activity, or the device screen turning off.
    - If the app wants the camera to be active only when the app is fully visible and active in the foreground (i.e., when it's fully Resumed), the camera initialization is placed after the **`ON_RESUME`** event.
    - If you want to keep the camera active while the activity is Paused but visible, such as in multi-window mode, then initialize the camera after the `ON_START` event.
    - *If you initialize something after the `ON_START` event, release or terminate it after the `ON_STOP` event. If you initialize after the `ON_RESUME` event, release after the `ON_PAUSE` event.*
    - `[onPause()](https://developer.android.com/reference/android/app/Activity#onPause())` callback always follows `[onResume()](https://developer.android.com/reference/android/app/Activity#onResume())`.
- `**onPause()`**
    - when the activity loses focus and enters a Paused state.
    - This state occurs when, for example, the user taps the Back or Recents button.
    - When the system calls `[onPause()](https://developer.android.com/reference/android/app/Activity#onPause())` for your activity, it technically means your activity is still partially visible, but most often is an indication that the user is leaving the activity, and the activity will soon enter the Stopped or Resumed state.
    - An activity in the Paused state may continue to update the UI if the user is expecting the UI to update. Examples of such an activity include one showing a navigation map screen or a media player playing. Even if such activities lose focus, the user expects their UI to continue updating.
    - **don't** use `onPause()` to save application or user data, make network calls, or execute database transactions. Such work might not complete before the method completes.
    - Instead, perform heavy-load shutdown operations during `[onStop()](https://developer.android.com/reference/android/app/Activity#onStop())`
    - If the activity returns from the Paused state to the Resumed state, the system keeps the `Activity` instance resident in memory, recalling that instance when the system invokes `onResume()`. In this scenario, you don’t need to re-initialize components created during any of the callback methods leading up to the Resumed state.
    - Once `[onPause()](https://developer.android.com/reference/android/app/Activity#onPause())` finishes executing, the next callback is either `[onStop()](https://developer.android.com/reference/android/app/Activity#onStop())` or `[onResume()](https://developer.android.com/reference/android/app/Activity#onResume())`
- `**onStop()**`
    - The system calls `[onStop()](https://developer.android.com/reference/android/app/Activity#onStop())` when the activity is no longer visible to the user.
    - This may happen because the activity is being destroyed, a new activity is starting, or an existing activity is entering a Resumed state and is covering the stopped activity.
    - The next callback that the system calls is either `[onRestart()](https://developer.android.com/reference/android/app/Activity#onRestart())`, if the activity is coming back to interact with the user, or by `[onDestroy()](https://developer.android.com/reference/android/app/Activity#onDestroy())` if this activity is completely terminating.
- **`onDestroy()`**
    - The system invokes this callback before an activity is destroyed.
    - implemented to ensure that all of an activity’s resources are released when the activity, or the process containing it, is destroyed.
    - When a configuration change (e.g., screen rotation) occurs, the Android system may destroy and recreate the activity.
    - If you store your UI-related data in a **`ViewModel`**, it survives this process. The existing **`ViewModel`** is associated with the new instance of the activity, and you don't have to reinitialize the data.
    - **`onCleared()`** method is called when the associated **`ViewModel`** is no longer needed and is about to be permanently destroyed.
    - The use of **`isFinishing()`** helps distinguish between the activity being destroyed due to a configuration change or the user finishing the activity.
- System kills processes when it needs to free up RAM


    | Likelihood of being killed | Process state | Final activity state |
    | --- | --- | --- |
    | Lowest | Foreground (having or about to get focus) | Resumed |
    | Low | Visible (no focus) | Started/Paused |
    | Higher | Background (invisible) | Stopped |
    | Highest | Empty | Destroyed |
- Preserve the user’s transient UI state using a combination of `[ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel)`, `[onSaveInstanceState()](https://developer.android.com/reference/android/app/Activity#onSaveInstanceState(android.os.Bundle))`, and/or local storage.
- When certain events, such as a screen rotation, occur, the Android system may destroy and recreate the activity. Before this destruction, the **`onSaveInstanceState()`** method is invoked.
- The purpose of this callback is to allow the activity to save its current state information so that it can be restored later.
- The saved data that the system uses to restore the previous state is called the *instance state*. It's a collection of key-value pairs stored in a `[Bundle](https://developer.android.com/reference/android/os/Bundle)` object.
- In order for the Android system to restore the state of the views in your activity, each view must have a unique ID, supplied by the **`android:id`** attribute
- A `**Bundle**` object isn't appropriate for preserving more than a trivial amount of data, because it requires serialization on the main thread and consumes system-process memory. To preserve more than a very small amount of data, take a combined approach to preserving data, using persistent local storage, the `onSaveInstanceState()` method, and the `ViewModel` class, as outlined in [Save UI states](https://developer.android.com/topic/libraries/architecture/saving-states).
- **`onSaveInstanceState()`** is not called when the user explicitly closes the activity or in other cases when **`finish()`** is called.
- Instead of restoring the state during `onCreate()`, you can choose to implement `**onRestoreInstanceState()**`, which the system calls after the `[onStart()](https://developer.android.com/reference/android/app/Activity#onStart())` method.
- you start the new activity using either the `[startActivity()](https://developer.android.com/reference/android/app/Activity#startActivity(android.content.Intent,%20android.os.Bundle))` method or the `[**startActivityForResult()**](https://developer.android.com/reference/android/app/Activity#startActivityForResult(android.content.Intent,%20int))` method. In either case, you pass in an `[Intent](https://developer.android.com/reference/android/content/Intent)` object.
- The `**Intent**` object specifies either the exact activity you want to start or describes the type of action you want to perform.
- `**Intent**` object can also carry small amounts of data to be used by the activity that is started
- When one activity starts another, the process of starting the second one overlaps with the process of stopping the first one.
- When the same instance of the covered activity returns to the foreground, the system calls `[onRestart()](https://developer.android.com/reference/android/app/Activity#onRestart())`, `[onStart()](https://developer.android.com/reference/android/app/Activity#onStart())`, and `onResume()` on the activity. If it is a new instance of the covered activity that comes to the background, the system does not call `onRestart()`, only `onStart()` and `onResume()`.

## Testing

- Google recommends that you call `close` on the activity when the test completes.
- you can use `**ActivityScenarioRule**` to automatically call `ActivityScenario.launch` before each test and `ActivityScenario.close` at test teardown.
- To drive the activity to a different state, such as `CREATED` or `STARTED`, call `**moveToState**()`
- To simulate recreation of an activity, call `recreate()`
- any objects annotated using `@NonConfigurationInstance` are stored and loaded into the new instance of your activity under test.
- In your test class, don't keep references to the objects that you pass into **`onActivity()`**. These references consume system resources, and the references themselves might be stale because the framework can recreate an activity that's passed into the callback method.

## Tasks and back stack

- A *task* is a collection of activities
- activities are arranged in a stack called the *back stack* in the order in which each activity is opened.
- The previous activity remains in the stack, but is **stopped**.
- When an activity is stopped, the system retains the current state of its user interface.
- When the user performs the back action, the current activity is popped from the top of the stack and **destroyed**.
- The previous activity resumes, and the previous state of its UI is restored.
- Root launcher activities are activities that declare an [intent filter](https://developer.android.com/reference/android/content/IntentFilter) with both `[ACTION_MAIN](https://developer.android.com/reference/android/content/Intent#ACTION_MAIN)` and `[CATEGORY_LAUNCHER](https://developer.android.com/reference/android/content/Intent#CATEGORY_LAUNCHER)`. Acts as entry point from the app launcher and are used to [start a task](https://developer.android.com/guide/components/activities/tasks-and-back-stack#Starting).
- When a user taps Back from a root launcher activity,
    - Android 11 and lower - The system finishes the activity.
    - Android 12 and highe**r -** moves the activity and its task to the background
- If you need to [provide **custom back navigation**](https://developer.android.com/guide/navigation/navigation-custom-back), it is recommended to use the AndroidX Activity APIs rather than overriding `onBackPressed()`.
- if your app overrides `[onBackPressed()](https://developer.android.com/reference/android/app/Activity#onBackPressed())` to handle Back navigation and finish the activity, update your implementation to call through to `super.onBackPressed()` instead of finishing.
- Calling `super.onBackPressed()` moves the activity and its task to the background when appropriate and provides a more consistent navigation experience for users across apps.
- activities in the back stack are never rearranged, if your app lets users start a particular activity from more than one activity, a new instance of that activity is created and pushed onto the stack, rather than bringing any previous instance of the activity to the top.
- Multi window environment - the system manages tasks separately for each window. Each window can have multiple tasks.
- If the user taps or gestures Back, the current activity is popped from the back stack and destroyed.
- **Launch modes** let you define how a new instance of an activity is associated with the current task.
- [Using the manifest file](https://developer.android.com/guide/components/activities/tasks-and-back-stack#ManifestForTasks)

  When you declare an activity in your manifest file, you can specify how the activity associates with tasks when it starts.

- [Using intent flags](https://developer.android.com/guide/components/activities/tasks-and-back-stack#IntentFlagsForTasks)

  When you call `[startActivity()](https://developer.android.com/reference/android/app/Activity#startActivity(android.content.Intent))`, you can include a flag in the `[Intent](https://developer.android.com/reference/android/content/Intent)` that declares how (or whether) the new activity associates with the current task.

- So, if Activity A starts Activity B, Activity B can define in its manifest how it associates with the current task, and Activity A can use an intent flag to request how Activity B can associate with current task.
- If both activities define how Activity B associates with a task, then Activity A's request, as defined in the intent, is honored over Activity B's request, as defined in its manifest.
- Some launch modes available for the manifest file aren't available as flags for an intent. Likewise, some launch modes available as flags for an intent can't be defined in the manifest.
- **“standard”** creates a new instance of the activity in the task it was started from and routes the intent to it.
- **“singleTop”** If an instance of the activity already exists at the top of the current task, the system routes the intent to that instance through a call to its `[onNewIntent()](https://developer.android.com/reference/android/app/Activity#onNewIntent(android.content.Intent))` method, rather than creating a new instance of the activity. suppose a task's back stack consists of root activity A with activities B, C, and D on top (so the stack is A-B-C-D, with D on top). An intent arrives for an activity of type D. If D has the default `"standard"` launch mode, a new instance of the class is launched, and the stack becomes A-B-C-D-D. However, if D's launch mode is `"**singleTop**"`, the existing instance of D receives the intent through `onNewIntent()`, because it's at the top of the stack, and the stack remains A-B-C-D. If, on the other hand, an intent arrives for an activity of type B, then a new instance of B is added to the stack even if its launch mode is `"singleTop"`.
- **"singleTask"** -
    - When an activity with the **`"singleTask"`** launch mode is launched, the system checks if there's already an existing task (a stack of activities) with the same affinity for that activity. Affinity is a way to group activities under a specific task.
    - If there is an existing task with the same affinity, the system routes the intent to the existing instance of the activity through its **`onNewIntent()`** method, instead of creating a new instance of the activity.
    - If there is no existing task with the same affinity, the system creates a new task and places the activity at the root of that task.
- `"`**singleInstance**`"` - The behavior is the same as for `"singleTask"`, except that the system doesn't launch any other activities into the task holding the instance. The activity is always the single and only member of its task. Any activities started by this one open in a separate task.
- **The behaviors that you specify for your activity with the `launchMode` attribute can be overridden by flags included with the intent that start your activity**
- When starting an activity, you can modify the default association of an activity to its task by including flags in the intent that you deliver to `[startActivity()](https://developer.android.com/reference/android/app/Activity#startActivity(android.content.Intent))`
- `[FLAG_ACTIVITY_NEW_TASK](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_NEW_TASK)` - same as singleTask
- `[FLAG_ACTIVITY_SINGLE_TOP](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_SINGLE_TOP)` - same as singleTop
- `[FLAG_ACTIVITY_CLEAR_TOP](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_CLEAR_TOP)` - instead of launching a new instance of that activity—the system destroys all the other activities on top of it. The intent is delivered to the resumed instance of the activity, now on top, through `onNewIntent()`.
- When an activity has its `[**allowTaskReparenting**](https://developer.android.com/guide/topics/manifest/activity-element#reparent)` attribute set to `"true"`.
    - the activity can move from the task it starts in to the task it has an affinity for when that task comes to the foreground.
    - For example, suppose an activity that reports weather conditions in selected cities is defined as part of a travel app. It has the same affinity as other activities in the same app, the default app affinity, and it can be re-parented with this attribute.
    - When one of your activities starts the weather reporter activity, it initially belongs to the same task as your activity. However, when the travel app's task comes to the foreground, the weather reporter activity is reassigned to that task and displayed within it.

## **Processes and app lifecycle**

- **Foreground process**
    - Running visible activities or foreground services, essential for the user's current interaction
    - **Example:** A music player app is in the foreground, actively playing a song, and the user is interacting with the player controls.
- **Visible process**
    - Performs work that the user is aware of, including running visible but not foreground activities or foreground services
    - **Example:** Updating widgets, showing notifications, or keeping the user informed about ongoing tasks.
- **Service process**
    - Holds a background service started with **`startService()`**, specifically designed for long-running tasks and operations.
    - **Example:** Performing background tasks like file downloads, music playback, or handling network operations
    - Processes that do need to be run over a long period can be created with `[setForeground](https://developer.android.com/reference/kotlin/androidx/work/CoroutineWorker#setForeground(androidx.work.ForegroundInfo))`. If it is a periodic process that requires strict time of execution, it can be scheduled through the `[AlarmManager](https://developer.android.com/reference/android/app/AlarmManager)`
- **Cached process**
    - Not currently needed, subject to being killed for resources; often holds non-visible Activity instances.
    - Holding background instances of apps for efficient switching between applications, may regularly be killed when resources are needed elsewhere.

## **Parcelables and bundles**

- when sending between processes, it is recommended to not use custom parcelables. If you send a custom `[Parcelable](https://developer.android.com/reference/android/os/Parcelable)` object from one app to another, you need to be certain that the exact same version of the custom class is present on both the sending and receiving apps.

## Loaders

- Loaders are deprecated, recommended option for dealing with loading data while handling the **`Activity`** and **`Fragment`** lifecycles is to use a combination of **`[ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel)`** objects and **`[LiveData](https://developer.android.com/reference/androidx/lifecycle/LiveData)`**.
- • Loaders run on separate threads to prevent a slow or unresponsive UI.
- You typically initialize a `Loader` within the activity's `[onCreate()](https://developer.android.com/reference/android/app/Activity#onCreate(android.os.Bundle))` method or the fragment's `[onCreate()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onCreate(android.os.Bundle))` method.
- `supportLoaderManager.initLoader(0, null, this)`
    - unique ID
    - Optional arguments to supply to the loader at construction
    - `[LoaderManager.LoaderCallbacks](https://developer.android.com/reference/androidx/loader/app/LoaderManager.LoaderCallbacks)` implementation, which the `LoaderManager` calls to report loader events. In this example, the local class implements the `LoaderManager.LoaderCallbacks` interface, so it passes a reference to itself
- `initLoader()` call ensures that a loader is initialized and active. It has two possible outcomes:
    - • If the loader specified by the ID already exists, the last created loader is reused.
    - If the loader specified by the ID does *not* exist, `initLoader()` triggers the `LoaderManager.LoaderCallbacks` method `[onCreateLoader()](https://developer.android.com/reference/androidx/loader/app/LoaderManager.LoaderCallbacks#onCreateLoader(int,%20android.os.Bundle))`. This is where you implement the code to instantiate and return a new loader.
- `initLoader()` method returns the `Loader` that is created, but you don't need to capture a reference to it. The `LoaderManager` starts and stops loading when necessary and maintains the state of the loader and its associated content automatically.
- As this implies, you rarely interact with loaders directly. You most commonly use the `LoaderManager.LoaderCallbacks` methods to intervene in the loading process when particular events occur.
- To discard your old data, use `[restartLoader()](https://developer.android.com/reference/androidx/loader/app/LoaderManager#restartLoader(int,android.os.Bundle,androidx.loader.app.LoaderManager.LoaderCallbacks%3CD%3E))`

## Recents screen

- `[ActivityManager.AppTask](https://developer.android.com/reference/android/app/ActivityManager.AppTask)` class lets you manage tasks, and the activity flags of the `[Intent](https://developer.android.com/reference/android/content/Intent)` class let you specify when an activity is added or removed from the Recents screen. Also, the `[<activity>](https://developer.android.com/guide/topics/manifest/activity-element)` attributes let you set the behavior in the manifest.
- **To insert a logical break so that the system treats your activity as a new task in the Recents screen, pass the `[FLAG_ACTIVITY_NEW_DOCUMENT](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_NEW_DOCUMENT)` flag in the `[addFlags()](https://developer.android.com/reference/android/content/Intent#addFlags(int))` method of the `[Intent](https://developer.android.com/reference/android/content/Intent)` that launches the activity.**
- `[**FLAG_ACTIVITY_NEW_DOCUMENT**](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_NEW_DOCUMENT)` ****the system treats your activity as a new task in the Recents screen
- `[**FLAG_ACTIVITY_MULTIPLE_TASK](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_MULTIPLE_TASK)`** This setting lets the same document be opened in more than one task
- **Using attribute** - An activity can also specify in its manifest that it always launches into a new task by using the `[<activity>](https://developer.android.com/guide/topics/manifest/activity-element)` attribute `[android:documentLaunchMode](https://developer.android.com/guide/topics/manifest/activity-element#dlmode)`.
- This attribute has four values -
    - `intoExisting` -`FLAG_ACTIVITY_NEW_DOCUMENT` without `FLAG_ACTIVITY_MULTIPLE_TASK`
    - `always` - same as setting both the `FLAG_ACTIVITY_NEW_DOCUMENT` and `FLAG_ACTIVITY_MULTIPLE_TASK` flags
    - `none` - default: displays a single task for the app, which resumes from whatever activity the user last invoked.
    - `never` Setting this value overrides the behavior of the `FLAG_ACTIVITY_NEW_DOCUMENT` and `FLAG_ACTIVITY_MULTIPLE_TASK` flags. If either of these are set in the intent, and the Recents screen displays a single task for the app, it resumes from whatever activity the user last invoked.
- For values other than **`none`** and **`never`**, the activity must be defined with **`launchMode="standard"`**. If this attribute is not specified, **`documentLaunchMode="none"`** is used.
- to retain a task in the Recents screen, even if its activity has finished
    - `[FLAG_ACTIVITY_RETAIN_IN_RECENTS](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS)` flag in the `[addFlags()](https://developer.android.com/reference/android/content/Intent#addFlags(int))` method of the intent that launches the activity.
    - set the `[<activity>](https://developer.android.com/guide/topics/manifest/activity-element)` attribute `[android:autoRemoveFromRecents](https://developer.android.com/guide/topics/manifest/activity-element#autoremrecents)` to `false`.
- Any app can enable Recents linking for users by providing a web UI and overriding `[onProvideAssistContent()](https://developer.android.com/reference/android/app/Activity#onProvideAssistContent(android.app.assist.AssistContent))`

*ANDROID TASK - 4*

Explore the below concepts:

*Activity:* https://developer.android.com/guide/components/activities/intro-activities

*Fragment:* https://developer.android.com/guide/fragments

*Service:* https://developer.android.com/guide/components/services

*Broadcast receiver:* https://developer.android.com/guide/components/broadcasts

*Content provider:* https://developer.android.com/guide/topics/providers/content-providers