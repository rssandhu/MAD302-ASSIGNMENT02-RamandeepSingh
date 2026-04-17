Here is a ready‑to‑use README.md for today’s RecyclerView product‑list assignment:

text
# MAD302-01 Android Development – Product List Assignment

## Overview
This Android application displays a list of products using `RecyclerView`, handles item clicks, navigates to a detail screen, and passes product data between screens using `Intent`.

Key features:
- Displays at least **6 products** (name, price, description).
- Uses `RecyclerView` with a custom `Adapter` and `ViewHolder`.
- Implements **lambda‑based click handling** for items.
- Navigates from the main screen to a detail screen using `Intent`.
- Passes product data as extras and reads it in a **null‑safe** way.
- Includes full documentation (file headers, class/method comments, inline comments).

---

## Features

- **Product List Screen (`MainActivity`)**  
  - Shows products in a `RecyclerView`.  
  - Each item includes product name, price, and description.  
  - Tapping a product opens the detail screen.

- **Detail Screen (`DetailActivity`)**  
  - Receives product data from `MainActivity` via `Intent` extras.  
  - Safely retrieves data using null‑safe Kotlin (`?:` operator).  
  - Displays product name, price, and description in a clean layout.

- **Navigation and Data Passing**  
  - Uses `Intent` to navigate from `MainActivity` to `DetailActivity`.  
  - Stores product fields as `String` extras (`product_name`, `product_price`, `product_description`).  
  - Uses `putExtra` on the sending side and `getStringExtra` with null checks on the receiving side.

---

## File Structure
app/
├── src/main/
│ ├── kotlin/com/example/productlistapp/
│ │ ├── MainActivity.kt # Main screen with RecyclerView
│ │ ├── DetailActivity.kt # Detail screen showing product info
│ │ ├── Product.kt # Data class for a product
│ │ └── ProductAdapter.kt # RecyclerView adapter with lambda click
│ ├── res/layout/
│ │ ├── activity_main.xml # Contains RecyclerView
│ │ ├── activity_detail.xml # Detail screen layout
│ │ └── item_product.xml # Individual product row layout
│ └── AndroidManifest.xml # Declares MainActivity and DetailActivity

text

---

## How It Works

1. **MainActivity**  
   - Creates a list of at least 6 `Product` objects.  
   - Sets up `RecyclerView` with `ProductAdapter`.  
   - `ProductAdapter` uses a lambda `onItemClick` that opens `DetailActivity` and passes product data via `Intent`.

2. **ProductAdapter**  
   - Binds each `Product` to an item view (`item_product.xml`).  
   - Attaches a click listener that calls the lambda, passing the clicked `Product`.

3. **DetailActivity**  
   - Reads `Intent` extras: `product_name`, `product_price`, `product_description`.  
   - Uses the null‑safe Kotlin form `intent.getStringExtra(...) ?: "default value"` to avoid `NullPointerException`.  
   - Displays the values in `TextView` widgets.

---

## Setup

### 1. Dependencies
The project uses the following core dependencies (already declared in `build.gradle`):

```groovy
implementation "androidx.core:core-ktx:1.13.1"
implementation "androidx.appcompat:appcompat:1.7.0"
implementation "com.google.android.material:material:1.12.0"
implementation "androidx.constraintlayout:constraintlayout:2.1.4"
implementation "androidx.recyclerview:recyclerview:1.3.2"
implementation "androidx.cardview:cardview:1.0.0"
```

### 2. Permissions
No runtime permissions are required for this assignment, so no `<uses-permission>` lines are needed in `AndroidManifest.xml`.

### 3. Manifest
Make sure `DetailActivity` is declared:

```xml
<activity android:name=".DetailActivity" />
```

---

## Documentation

- Each Kotlin file includes a **file header** with:
  - Course code and lab/assignment number.
  - Your full name and student ID.
  - Date of submission.
  - Short description of what the file does.
- Every class and method has a **doc‑style comment** (`/** ... */`) describing its purpose, parameters, and return values.
- Significant logic lines include **inline comments** (`//`) explaining the intent, without commenting every line.

---

## How to Run

1. Open the project in **Android Studio**.
2. Sync Gradle to ensure dependencies are resolved.
3. Build and run on an emulator or device.
4. Tap any product to see its details on the `DetailActivity` screen.

---

## Notes

- The app uses **mock data** (hard‑coded `Product` objects) instead of loading from a real API or database, as required for this lab.
- This implementation demonstrates RecyclerView best practices:
  - Clear separation between data (`Product`), UI (`RecyclerView`), and navigation (`Intent`).
  - Lambda‑driven item clicks instead of anonymous inner classes.
  - Null‑safe extra reading on the detail screen.