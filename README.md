# RecyclerViewToViewPager
Android app repository which demonstrates on imlementing RecyclerView to ViewPager2 along with
jetpack components ViewModel, LiveData, NavigationComponent, Architecture.

![ReyclerView to ViewPager](https://i1.wp.com/developersbreach.com/wp-content/uploads/2020/05/RvTOVp.png?ssl=1&resize=1920%2C1080)

**Dependencies**
```gradle
implementation "androidx.viewpager2:viewpager2:1.0.0"
implementation 'androidx.recyclerview:recyclerview:1.1.0'
implementation 'com.google.android.material:material:1.1.0'
implementation 'androidx.navigation:navigation-fragment-ktx:2.2.2'
implementation 'androidx.navigation:navigation-ui-ktx:2.2.2'
implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
```

**Add ViewPager2 to xml layout**
```xml
<androidx.viewpager2.widget.ViewPager2
    android:id="@+id/my_view_pager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal" />
```

**ViewPager2 in Kotlin class**
```kotlin
// Get reference to ViewPager2
val viewPager2: ViewPager2 = view.findViewById(R.id.detail_view_pager)
// Create a new ViewPagerAdapter class
val viewPagerAdapter = ViewPagerAdapter()
// Add items to our recyclerView adpater
viewPagerAdapter.submitList(yourItemsList)
// Attach ViewPager2 with Adapter
viewPager2.adapter = viewPagerAdapter
// Get user clicked item position and set it to ViewPager2
viewPager2.setCurrentItem(selectedItem)
```

### Implementation has been clearly explained in blog (https://developersbreach.com)
### This repository has following branches which differs in features stated below.

### Branch - Master
Without DataBinding

### Branch - DataBinding
Applied to ViewModels, Layouts, Fragment, Two-Way Binding

### Branch - SimpleExample
No DataBiding, Removed Material ViewPager2, CustomViews Removed
