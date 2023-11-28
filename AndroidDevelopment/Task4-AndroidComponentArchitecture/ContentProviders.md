# Content Providers

- Content providers can help an application manage access to data stored by itself or stored by other apps and provide a way to share data with other apps.
- provide an abstraction that lets you make modifications to your application data storage implementation without affecting other applications that rely on access to your data. (during data migration)
- Typically you work with content providers in one of two scenarios: implementing code to access an existing content provider in another application or creating a new content provider in your application to share data with other applications.
- A content provider presents data to external applications as one or more tables that are similar to the tables found in a relational database
- A *content URI* is a URI that identifies data in a provider. Content URIs include the symbolic name of the entire provider—its *authority*—and a name that points to a table—a *path*. When you call a client method to access a table in a provider, the content URI for the table is one of the arguments.
- The **`[Uri](https://developer.android.com/reference/android/net/Uri)`** and **`[Uri.Builder](https://developer.android.com/reference/android/net/Uri.Builder)`** classes contain convenience methods for constructing well-formed URI objects from strings. The **`[ContentUris](https://developer.android.com/reference/android/content/ContentUris)`** class contains convenience methods for appending ID values to a URI.
- To retrieve data from a provider, your application needs read access permission for the provider. you have to specify that you need this permission in your manifest, using the `[<uses-permission>](https://developer.android.com/guide/topics/manifest/uses-permission-element)` element and the exact permission name defined by the provider.
- To insert data into a provider, you call the `[ContentResolver.insert()](https://developer.android.com/reference/android/content/ContentResolver#insert(android.net.Uri,%20android.content.ContentValues))` method. This method inserts a new row into the provider and returns a content URI for that row.
- The data for the new row goes into a single `[ContentValues](https://developer.android.com/reference/android/content/ContentValues)` object
- To update `[ContentResolver.update()](https://developer.android.com/reference/android/content/ContentResolver#update(android.net.Uri,%20android.content.ContentValues,%20java.lang.String,%20java.lang.String[]))`
- **Batch access** to a provider is useful for inserting a large number of rows, for inserting rows in multiple tables in the same method call, and in general for performing a set of operations across process boundaries as a transaction, called an *atomic operation*.
- Data access using intents: Intents can provide indirect access to a content provider. You can let the user access data in a provider even if your application doesn't have access permissions by either getting a result intent back from an application that has permissions or by activating an application that has permissions and letting the user do work in it.
- A content provider manages access to a central repository of data. You implement a provider as one or more classes in an Android application, along with elements in the manifest file. One of your classes implements a subclass of `[ContentProvider](https://developer.android.com/reference/android/content/ContentProvider)`, which is the interface between your provider and other applications.
- Although content providers are meant to make data available to other applications, you can have activities in your application that let the user query and modify the data managed by your provider.
- You *don't* need a provider to use databases or other types of persistent storage if the use is entirely within your own application
- If you make a change to your repository that isn't backward-compatible, you need to mark the repository with a new version number. You also need to increase the version number for your app that implements the new content provider. Making this change prevents system downgrades from causing the system to crash when it attempts to reinstall an app that has an incompatible content provider.

## Storage Access Framework

- SAF includes the following:
    - D**ocument provider:** a content provider that lets a storage service, such as Google Drive, reveal the files it manages. A document provider is implemented as a subclass of the `[DocumentsProvider](https://developer.android.com/reference/android/provider/DocumentsProvider)` class.
    - **Client app:** a custom app that invokes the `[ACTION_CREATE_DOCUMENT](https://developer.android.com/reference/android/content/Intent#ACTION_CREATE_DOCUMENT)`, `[ACTION_OPEN_DOCUMENT](https://developer.android.com/reference/android/content/Intent#ACTION_OPEN_DOCUMENT)`, and `[ACTION_OPEN_DOCUMENT_TREE](https://developer.android.com/reference/android/content/Intent#ACTION_OPEN_DOCUMENT_TREE)` intent actions and receives the files returned by document providers.
    - **Picker:** a system UI that lets users access documents from all document providers that satisfy the client app's search criteria.
- SAF supports multiple user accounts and transient roots such as USB storage providers, which only appear if the drive is plugged in.
- Under each root is a single document. That document points to 1 to *N* documents, each of which in turn can point to 1 to *N* documents.
- Developers must create a subclass of the abstract class **`DocumentsProvider`** and implement required methods like **`queryRoots()`**, **`queryChildDocuments()`**, **`queryDocument()`**, and **`openDocument()`**.
- The **`queryRoots()`** method returns information about the root directories of the document provider.
- The **`queryChildDocuments()`** method lists files in a specified directory.
- The **`queryDocument()`** method provides information about a specific file.
- The **`openDocument()`** method returns a **`ParcelFileDescriptor`** representing the specified file.
- Can add functionality using: the flags **`FLAG_SUPPORTS_DELETE`**, **`FLAG_SUPPORTS_RENAME`**, **`FLAG_SUPPORTS_COPY`**, **`FLAG_SUPPORTS_MOVE`**, and **`FLAG_SUPPORTS_REMOVE`** indicate the supported features.
- can allow client apps to create files within the document provider by implementing the **`createDocument()`** method.