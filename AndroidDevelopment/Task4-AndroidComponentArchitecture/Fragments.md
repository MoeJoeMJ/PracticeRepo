# Fragments

- A `[Fragment](https://developer.android.com/reference/androidx/fragment/app/Fragment)` represents a reusable portion of your app's UI
- A fragment has its own lifecycle, receives its own input events, and you can add or remove fragments while the containing activity is running.
- To **create a fragment**, extend the AndroidX `[Fragment](https://developer.android.com/reference/androidx/fragment/app/Fragment)` class, and override its methods to insert your app logic, similar to the way you would create an `[Activity](https://developer.android.com/reference/android/app/Activity)` class. To create a minimal fragment that defines its own layout, provide your fragment's layout resource to the base constructor

  `class ExampleFragment : Fragment(R.layout.example_fragment)`

- can use `**PreferenceFragmentCompat**` to [create a settings screen](https://developer.android.com/develop/ui/views/components/settings) for your app.
- `[**DialogFragment](https://developer.android.com/reference/androidx/fragment/app/DialogFragment)`** - Displays a floating dialog. Using this class to create a dialog is a good alternative to using the dialog helper methods in the `[Activity](https://developer.android.com/reference/android/app/Activity)` class
- In simpler terms, if you are building an app and want to use fragments, it's recommended to use **`FragmentActivity`** as the base class for your activities. If you're already using **`AppCompatActivity`** for backward compatibility, there's no need to make any changes because **`AppCompatActivity`** is a subclass of **`FragmentActivity`**.
- **Add a fragment via XML** - The `android:name` attribute specifies the class name of the `Fragment` to instantiate. When the activity's layout is inflated, the specified fragment is instantiated, `[onInflate()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onInflate(android.content.Context,%2520android.util.AttributeSet,%2520android.os.Bundle))` is called on the newly instantiated fragment, and a `FragmentTransaction` is created to add the fragment to the `FragmentManager`.
- **Add a fragment programmatically -** In your `FragmentActivity`, you can get an instance of the `[FragmentManager](https://developer.android.com/reference/androidx/fragment/app/FragmentManager)`, which can be used to create a `FragmentTransaction`. Then, you can instantiate your fragment within your activity's `onCreate()` method using `[FragmentTransaction.add()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#add(int,%20java.lang.Class%3C?%20extends%20androidx.fragment.app.Fragment%3E,%20android.os.Bundle))`, passing in the `ViewGroup` ID of the container in your layout and the fragment class you want to add and then commit the transaction
- *note that the fragment transaction is only created when `savedInstanceState` is `null`. This is to ensure that the fragment is added only once, when the activity is first created. When a configuration change occurs and the activity is recreated, `savedInstanceState` is no longer `null`, and the fragment does not need to be added a second time, as the fragment is automatically restored from the `savedInstanceState`.*
- It is strongly recommended to use the [Navigation library](https://developer.android.com/guide/navigation) to manage your app's navigation. The framework follows best practices for working with fragments, the back stack, and the fragment manager. For more information about Navigation, see [Get started with the Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) and [Migrate to the Navigation component](https://developer.android.com/guide/navigation/navigation-migrate).

## Fragment Manager

- `[FragmentManager](https://developer.android.com/reference/androidx/fragment/app/FragmentManager)` is the class responsible for performing actions on your app's fragments, such as adding, removing, or replacing them and adding them to the back stack.
- Once you have a reference to the `FragmentManager`, you can use it to manipulate the fragments being displayed to the user.
- The `FragmentManager` manages the fragment back stack. At runtime, the `FragmentManager` can perform back stack operations like adding or removing fragments in response to user interactions. Each set of changes is committed together as a single unit called a `[FragmentTransaction](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction)`. For a more in-depth discussion about fragment transactions, see the [fragment transactions guide](https://developer.android.com/guide/fragments/transactions).
- `addToBackOfStack(String name)`, adds this transaction to the back stack, this can be used so that `Fragments` are remembered and can be used again by the `Activity`
- Calling `[addToBackStack()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#addToBackStack(java.lang.String))` commits the transaction to the back stack. The user can later reverse the transaction and bring back the previous fragment by tapping the Back button. If you added or removed multiple fragments within a single transaction, all those operations are undone when the back stack is popped. The optional name provided in the `addToBackStack()` call gives you the ability to pop back to a specific transaction using `[popBackStack()](https://developer.android.com/reference/androidx/fragment/app/FragmentManager#popBackStack(java.lang.String,%20int))`.
- If you don't call `addToBackStack()` when you perform a transaction that removes a fragment, then the removed fragment is destroyed when the transaction is committed, and the user cannot navigate back to it. If you do call `addToBackStack()` when removing a fragment, then the fragment is only `STOPPED` and is later `RESUMED` when the user navigates back. Its view *is* destroyed in this case.
- You can get a reference to the current fragment within a layout container by using `[**findFragmentById()**](https://developer.android.com/reference/androidx/fragment/app/FragmentManager#findFragmentById(int))`
- Alternatively, you can assign a unique tag to a fragment and get a reference using `[**findFragmentByTag()](https://developer.android.com/reference/androidx/fragment/app/FragmentManager#findFragmentByTag(java.lang.String))`.**
- `FragmentManager` lets you support **multiple back stacks** with the `saveBackStack()` and `restoreBackStack()` methods. These methods let you swap between back stacks by saving one back stack and restoring a different one.
- Alternatively, you can use the **`[NavigationUI](https://developer.android.com/reference/androidx/navigation/ui/NavigationUI)`** component, which automatically handles multiple back stack support for [bottom navigation](https://developer.android.com/guide/navigation/navigation-ui#bottom_navigation).
- You can use **`saveBackStack()`** only with transactions that call **`setReorderingAllowed(true)`** so that the transactions can be restored as a single, atomic operation.
- You can't use **`saveBackStack()`** and **`restoreBackStack()`** unless you pass an optional name for your fragment transactions with **`addToBackStack()`**.

## Transaction

- At runtime, a `[FragmentManager](https://developer.android.com/reference/androidx/fragment/app/FragmentManager)` can add, remove, replace, and perform other actions with fragments in response to user interaction. Each set of fragment changes that you commit is called a *transaction*
- Final call on each `FragmentTransaction` must commit the transaction. The `commit()` call signals to the `FragmentManager` that all operations have been added to the transaction.
- ADDING FRAGMENTS - To add a fragment to a `FragmentManager`, call `[add()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#add(int,%20java.lang.Class%3C?%20extends%20androidx.fragment.app.Fragment%3E,%20android.os.Bundle))` on the transaction. This method receives the ID of the *container* for the fragment, as well as the class name of the fragment you wish to add. The added fragment is moved to the `RESUMED` state. It is strongly recommended that the *container* is a `[FragmentContainerView](https://developer.android.com/reference/androidx/fragment/app/FragmentContainerView)` that is part of the view hierarchy.
- REMOVING FRAGMENTS - call `[remove()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#remove(androidx.fragment.app.Fragment))`, passing in a fragment instance that was retrieved from the fragment manager through `findFragmentById()` or `findFragmentByTag()`. If the fragment's view was previously added to a container, the view is removed from the container at this point. The removed fragment is moved to the `DESTROYED` state.
- REPLACE - `[replace()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#replace(int,%20java.lang.Class%3C?%20extends%20androidx.fragment.app.Fragment%3E,%20android.os.Bundle))` to replace an existing fragment in a container with an instance of a new fragment class that you provide.

`replace<ExampleFragment>(R.id.fragment_container)`

a new instance of `ExampleFragment` replaces the fragment, if any, that is currently in the layout container identified by `R.id.fragment_container`.

- It is strongly recommended to always use fragment operations that take a **`Class`** rather than a fragment instance to ensure that the same mechanisms for creating the fragment are also used for restoring the fragment from a saved state.
- By default, the changes made in a `FragmentTransaction` are not added to the back stack. To save those changes, you can call `[addToBackStack()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#addToBackStack(java.lang.String))` on the `FragmentTransaction`
- Calling `[commit()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#commit())` doesn't perform the transaction immediately. Rather, the transaction is scheduled to run on the main UI thread as soon as it is able to do so. If necessary, however, you can call `[commitNow()](https://developer.android.com/reference/androidx/fragment/app/FragmentTransaction#commit())` to run the fragment transaction on your UI thread immediately.
- The **`attach()`** and **`detach()`** methods are not related to the **`Fragment`** methods of **`[onAttach()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onAttach(android.content.Context))`** and **`[onDetach()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onDetach())`**.

## Animate transitions b/w fragments

- two ways to use motion effects and transformations to visually connect fragments during navigation - Animation Framework, which uses both `[Animation](https://developer.android.com/reference/android/view/animation/Animation)` and `[Animator](https://developer.android.com/reference/android/animation/Animator)`. The other is the [Transition Framework](https://developer.android.com/training/transitions), which includes shared element transitions.
- These two frameworks are mutually exclusive and should not be used at the same time.
- It is strongly recommended to [use transitions](https://developer.android.com/guide/fragments/animate#set-transitions) for effects that involve more than one type of animation as there are known issues with using nested **`[AnimationSet](https://developer.android.com/reference/android/view/animation/AnimationSet)`** instances.
- For apps that support only API levels 21 and higher, you can alternatively use the **`[android:transitionName](https://developer.android.com/reference/android/view/View#attr_android:transitionName)`** attribute within your XML layout to assign transition names to specific views.
- When dealing with cases such as a user's slow internet connection, you might need the postponed transition to start after a certain amount of time rather than waiting for all of the data to load. For these situations, you can instead call `[Fragment.postponeEnterTransition(long, TimeUnit)](https://developer.android.com/reference/androidx/fragment/app/Fragment#postponeEnterTransition(long,%20java.util.concurrent.TimeUnit))` in the entering fragment's `onViewCreated()` method, passing in the duration and the unit of time. The postponed then automatically starts once the specified time has elapsed.

## Fragment Lifecycle

- To manage lifecycle, `Fragment` implements `[LifecycleOwner](https://developer.android.com/reference/androidx/lifecycle/LifecycleOwner)`, exposing a `[Lifecycle](https://developer.android.com/reference/androidx/lifecycle/Lifecycle)` object that you can access through the `[getLifecycle()](https://developer.android.com/reference/androidx/lifecycle/LifecycleOwner#getLifecycle())` method.
- `[Lifecycle.State](https://developer.android.com/reference/androidx/lifecycle/Lifecycle.State)` enum.
    - `[INITIALIZED](https://developer.android.com/reference/androidx/lifecycle/Lifecycle.State#INITIALIZED)`
    - `[CREATED](https://developer.android.com/reference/androidx/lifecycle/Lifecycle.State#CREATED)`
    - `[STARTED](https://developer.android.com/reference/androidx/lifecycle/Lifecycle.State#STARTED)`
    - `[RESUMED](https://developer.android.com/reference/androidx/lifecycle/Lifecycle.State#RESUMED)`
    - `[DESTROYED](https://developer.android.com/reference/androidx/lifecycle/Lifecycle.State#DESTROYED)`
- Fragments maintain a `[LifecycleOwner](https://developer.android.com/reference/androidx/lifecycle/LifecycleOwner)` for their view, which can be accessed using `[getViewLifecycleOwner()](https://developer.android.com/reference/androidx/fragment/app/Fragment#getViewLifecycleOwner())` or `[getViewLifecycleOwnerLiveData()](https://developer.android.com/reference/androidx/fragment/app/Fragment#getViewLifecycleOwnerLiveData())`
- **Caution:** Avoid reusing **`Fragment`** instances after they are removed from the **`FragmentManager`**. While the fragment handles its own internal state cleanup, you might inadvertently carry over your own state into the reused instance.
- • A fragment's lifecycle state can never be greater than its parent. For example, a parent fragment or activity must be started before its child fragments. Likewise, child fragments must be stopped before their parent fragment or activity.
- **Caution:** Avoid using the **`<fragment>`** tag to add a fragment using XML, as the **`<fragment>`** tag allows a fragment to move beyond the state of its **`FragmentManager`**. Instead, always use **`[FragmentContainerView](https://developer.android.com/reference/androidx/fragment/app/FragmentContainerView)`** for adding a fragment using XML.
- Note that `savedInstanceState` has a `null` value the first time the fragment is created, but it is always non-null for subsequent recreations, even if you do not override `onSaveInstanceState()`
- If and only if your fragment's view is instantiated with a non-null `View`, that `View` is set on the fragment and can be retrieved using `[getView()](https://developer.android.com/reference/androidx/fragment/app/Fragment#getView())`
- It is strongly recommended to tie [Lifecycle-aware components](https://developer.android.com/topic/libraries/architecture/lifecycle) to the `STARTED` state of a fragment, as this state guarantees that the fragment's view is available, if one was created.
- The transition to `RESUMED` is the appropriate signal to indicate that the user is now able to interact with your fragment
-
- Views are responsible for managing their own state. so you don't have to manage view state within your fragment.
-
- Communicate with fragments:

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/d6b9731e-b760-48f0-8acb-590f9db6fc74/363d1604-a11e-4e93-9e1c-f4bd649933ab/Untitled.png)

- You can have only a single listener and result for a given key. If you call `setFragmentResult()` more than once for the same key, and if the listener is not `STARTED`, the system replaces any pending results with your updated result.
- If you set a result without a corresponding listener to receive it, the result is stored in the `FragmentManager` until you set a listener with the same key. Once a listener receives a result and fires the `onFragmentResult()` callback, the result is cleared.

## App bar

- If all your screens use the same app bar that's always at the top and spans the width of the screen, use a theme-provided action bar hosted by the activity.
- Use a toolbar hosted by the fragment if you want more control over the size, placement, and animation of the app bar across multiple screens.
- `setHasOptionsMenu(true)` tells the system that your fragment wants to receive menu-related callbacks
- Handle click events - Every activity and fragment that participates in the options menu can respond to touches. The fragment's **`[onOptionsItemSelected()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onOptionsItemSelected(android.view.MenuItem))`** receives the selected menu item as a parameter and returns a boolean to indicate whether the touch is consumed. Once an activity or fragment returns `true` from `onOptionsItemSelected()`, no other participating fragments receive the callback.
- In your implementation of `**onOptionsItemSelected**()`, use a `switch` statement on the `itemId` of the menu item. If the selected item is yours, handle the touch appropriately and return `true` to indicate that the click event is handled. If the selected item isn't yours, call the `super` implementation. By default, the `super` implementation returns `false` to let menu processing continue.
- Place the logic to hide or show a button or change the icon in `[**onPrepareOptionsMenu()**](https://developer.android.com/reference/androidx/fragment/app/Fragment#onPrepareOptionsMenu(android.view.Menu))`
- Continuing with the previous example, the **Save** button should be invisible until the user begins editing, and it should disappear after the user saves. Adding this logic to `onPrepareOptionsMenu()` makes the menu present correctly.
- If most screens in your app don't need an app bar, or if one screen needs a different app bar than the others, you can add a `[**Toolbar**](https://developer.android.com/reference/androidx/appcompat/widget/Toolbar)` to your fragment layout.

## DialogFragment

- Although you don't need to host your dialog within a fragment, doing so lets the `[FragmentManager](https://developer.android.com/guide/fragments/fragmentmanager)` manage the state of the dialog and automatically restore the dialog when a configuration change occurs.
- create a class that extends `[DialogFragment](https://developer.android.com/reference/androidx/fragment/app/DialogFragment)` and override `[onCreateDialog()](https://developer.android.com/reference/androidx/fragment/app/DialogFragment#onCreateDialog(android.os.Bundle))`
- When creating a `DialogFragment` from within a `Fragment`, use the fragment's child `FragmentManager` so that the state properly restores after configuration changes
- You don't override `[onCreateView()](https://developer.android.com/reference/androidx/fragment/app/Fragment#oncreateview)` or `[onViewCreated()](https://developer.android.com/reference/androidx/fragment/app/Fragment#onViewCreated(android.view.View,%20android.os.Bundle))` when using a `DialogFragment` with a `Dialog`. Dialogs aren't only views—they have their own window. As such, it's not enough to override `onCreateView()`. Moreover, `onViewCreated()` is never called on a custom `DialogFragment` unless you've overridden `onCreateView()` and provided a non-null view.

## FragmentManager Logging

- `FragmentManager` emits the most meaningful output at the `DEBUG` and `VERBOSE` [log levels](https://developer.android.com/studio/debug/logcat#read-logs).
- enable logging using `adb shell setprop log.tag.FragmentManager DEBUG`
- enable verbose logging using `adb shell setprop log.tag.FragmentManager VERBOSE`
- If you enable verbose logging, you can then apply a [log level filter](https://developer.android.com/studio/debug/logcat#key-value-search) in the Logcat window. However, this filters all logs, not just the `FragmentManager` logs. It's usually best to enable `FragmentManager` logging only at the log level that you need.
- Many of the `VERBOSE` level log messages are of little use to app developers. However, seeing when changes to the back stack occur can help in debugging some issues.
- **StrictMode for fragments** can catch some common issues that may cause your app to behave in unexpected ways
- `[penaltyLog()](https://developer.android.com/reference/kotlin/androidx/fragment/app/strictmode/FragmentStrictMode.Policy.Builder#penaltylog)` dumps details of violations to Logcat.
- `[penaltyDeath()](https://developer.android.com/reference/kotlin/androidx/fragment/app/strictmode/FragmentStrictMode.Policy.Builder#penaltyDeath())` terminates the app when violations are detected.
- `[penaltyListener()](https://developer.android.com/reference/kotlin/androidx/fragment/app/strictmode/FragmentStrictMode.Policy.Builder#penaltylistener)` lets you add a custom listener that is called whenever violations are detected.
- `[detectFragmentReuse()](https://developer.android.com/reference/kotlin/androidx/fragment/app/strictmode/FragmentStrictMode.Policy.Builder#detectFragmentReuse())` - This violation indicates the reuse of a `Fragment` instance after its removal from `FragmentManager`
- `[detectFragmentTagUsage()](https://developer.android.com/reference/kotlin/androidx/fragment/app/strictmode/FragmentStrictMode.Policy.Builder#detectFragmentTagUsage())` - This violation indicates that a `Fragment` is inflated using the `<fragment>` tag in an XML layout. To resolve this, inflate your `Fragment` inside `<androidx.fragment.app.FragmentContainerView>` rather than in the `<fragment>` tag.
- Fragments inflated using a `FragmentContainerView` can reliably handle `Fragment` transactions and configuration changes. These might not work as expected if you use the `<fragment>` tag instead.
-
- **Caution:** If you try to transition your fragment under test to its current state, **`FragmentScenario`** ignores the request without throwing an exception. In particular, the API allows you to transition your fragment to the **`DESTROYED`** state multiple times consecutively.
- `[FragmentScenario.recreate()](https://developer.android.com/reference/kotlin/androidx/fragment/app/testing/FragmentScenario#recreate())` destroys the fragment and its host and then recreates them.
- `FragmentScenario.launch()` to test dialog fragments.