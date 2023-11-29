# Task 5 - Manifest and Intent

## Manifest

- The manifest file describes essential information about your app to the Android build tools, the Android operating system, and Google Play.
- Required to declare the following
    - The components of the app
    - The permissions that the app needs in order to access protected parts of the system or other apps. It also declares any permissions that other apps must have if they want to access content from this app.
    - The hardware and software features the app requires, which affects which devices can install the app from Google Play
- If you **subclass** any of these components without declaring it in the manifest file, the system can't start it.
- When an app issues an **intent** to the system, the system locates an app component that can handle the intent based on *intent filter* declarations in each app's manifest file. The system launches an instance of the matching component and passes the `Intent` object to that component. If more than one app can handle the intent, then the user can select which app to use.
- you must declare all permission requests with a `[**<uses-permission>**](https://developer.android.com/guide/topics/manifest/uses-permission-element)` element in the manifest.
- Your app can also define its own permissions. A new permission is declared with the `[**<permission>**](https://developer.android.com/guide/topics/manifest/permission-element)` element.
- The manifest file is also where you can declare what types of hardware or software features your app requires and, by extension, which types of devices your app is compatible with. Google Play Store doesn't let users install your app on devices that don't provide the features or system version that your app requires.
- The `[<uses-feature>](https://developer.android.com/guide/topics/manifest/uses-feature-element)` element lets you declare hardware and software features your app needs. For example, if your app can't achieve basic functionality on a device without a compass sensor, you can declare the compass sensor as required with the following manifest tag
- Only the `[<manifest>](https://developer.android.com/guide/topics/manifest/manifest-element)` and `[<application>](https://developer.android.com/guide/topics/manifest/application-element)` elements are required.
- An `[<activity-alias>](https://developer.android.com/guide/topics/manifest/activity-alias-element)` element must follow the `<activity>` for which it is an alias.
- The `<application>` element must be the last element inside the `<manifest>` element.
- Except for some attributes of the root `[<manifest>](https://developer.android.com/guide/topics/manifest/manifest-element)` element, all attribute names begin with an `android:` prefix
- Each successive platform version often adds new APIs not available in the previous version. To indicate the minimum version with which your app is compatible, your manifest must include the `[<uses-sdk>](https://developer.android.com/guide/topics/manifest/uses-sdk-element)` tag and its `[minSdkVersion](https://developer.android.com/guide/topics/manifest/uses-sdk-element#min)` attribute.
- However, be aware that attributes in the `<uses-sdk>` element are overridden by corresponding properties in the `[build.gradle](https://developer.android.com/studio/build#build-files)` file.

## Intents

- **`Intent`** is an object that provides a way to communicate between different components of an application or between different applications
- An explicit intent is used to start a specific component within the same application. It explicitly defines the target component (e.g., activity, service, or broadcast receiver) that should be invoked.

  `Intent explicitIntent = new Intent(CurrentActivity.this, TargetActivity.class);
  startActivity(explicitIntent);`

- An implicit intent is used to request functionality from other components without specifying the exact component to be invoked. The system determines the appropriate component based on the intent's action, data, and category.

  Opens webpage in browser:

  `Uri webpage = Uri.parse("[https://www.example.com](https://www.example.com/)");
  Intent implicitIntent = new Intent(Intent.ACTION_VIEW, webpage);
  startActivity(implicitIntent);`

    - "https" is the scheme, indicating that this is a URL using the HTTP protocol.
    - Likewise geo for location, content for pdf and contacts
    - When you create an implicit intent with **`ACTION_VIEW`** and a specific URI, the Android system looks at the scheme and, if needed, the MIME type to determine which application or activity should handle the intent.

      `pdfIntent.setType("application/pdf");` MIME type is set using setType

- The action is a string that specifies the operation to be performed (e.g., ACTION_SEND for sending data, ACTION_VIEW for viewing data).
- Extras are key-value pairs that can be used to carry additional information, such as parameters or data, along with the intent.
- the specific content type is determined by the data provided and, in some cases, the MIME type specified using the **`setType()`** method.