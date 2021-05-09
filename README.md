# Rate the Cat

This application fetches Cat images from the [TheCatAPI](https://docs.thecatapi.com/api-reference/images/images-search) and displays the images in a Grid. The app uses MVVM architecture for separation of the logic and UI.

### API usage

BASE URL - "https://api.thecatapi.com/v1/"
GET modifier -"images/search?limit=40&page=1&sub_id=User-287" , where "User-287" is the sub_id, from which the voting results will be fetched. The Image limit is let to 40 pcs.

The resulting JSON response gets parsed into a Kotlin Data class, via GSON.

### App includes

- List fragment where the images are displayed using RecyclerView with a custom adapter. Along with ViewModel and data binding.
- List fragment includes a placeholder if there is no internet.
_ List view items include placeholders for loading and for errors in fetching the images.
- List fragment data is saved between state changes.
- Items in the list are clickable and once clicked navigate to the Rating fragment page.
- Rating fragment page displays the clicked Cat image and Raiting controls (like and dislike).
- Like/Dislike buttons will turn from gray to RED/GREEN if the image was already liked/disliked by the "User-287" user.

### Not included

- Like/Dislike buttons are not set up to make POST requests. Not navigate back to List gragment after a click.
- No Error handlers for the POST requests (Retry and Cancel buttons not added as well).

### Libraries used

- Coroutines - for async fetching of the data.
- Retrofit - for making the HTTPS requests. GSON for adapting JSON data.
- Glide - for image processing.
- Navigation - for making the navigation between pages.
- SafeArgs - for passing data between Fragments.
- RecyclerView - for displaying the list of items.

### Images

![Cat Image List](/screenshots/ListPage.png?raw=true)

![Cat Rating Page](/screenshots/DetailsPage.png?raw=true)