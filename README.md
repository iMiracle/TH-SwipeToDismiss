TH-SwipeToDismiss
====================================

Sample code that shows how to make `ListView` support the swipe-to-dismiss Android UI pattern with feedback.
How to use:

1. Add the `SwipeListViewTouchListener.java` to your project.
2. Add the `SwipeListViewTouchListner` to your listView as shown below:

			SwipeListViewTouchListener touchListener = new SwipeListViewTouchListener(
				listView, new SwipeListViewTouchListener.OnSwipeCallback() {
					@Override
					public void onSwipeLeft(ListView listView,
							int[] reverseSortedPositions) {

						if (reverseSortedPositions != null
								&& reverseSortedPositions.length > 0) {
							for (int i : reverseSortedPositions) {

								customAdapter.remove(i);
							}
							customAdapter.notifyDataSetChanged();
						}

					}

					@Override
					public void onSwipeRight(ListView listView,
							int[] reverseSortedPositions) {

						if (reverseSortedPositions != null
								&& reverseSortedPositions.length > 0) {
							for (int i : reverseSortedPositions) {

								customAdapter.remove(i);
							}
							customAdapter.notifyDataSetChanged();
						}
					}
				}, true,
				true);
				
3. Set the touchListener to your listView: 
 	
 		listView.setOnTouchListener(touchListener); 
		listView.setOnScrollListener(touchListener.makeScrollListener());
		
 
4. Include the `remove(int position)` method in your adapter as shown in `CustomAdapter.java`.

5. Set your desired color by changing the color in SwipeListViewTouchListener.java

		mDownView.setBackgroundColor(Color.GREEN);
		

 

 ![alt text](https://raw.github.com/torryharris/TH-SwipeToDismiss/master/Right%20Swipe.png "Right Swipe")
 ![alt text](https://raw.github.com/torryharris/TH-SwipeToDismiss/master/Left%20Swipe.png "Left Swipe")
 
See the original [Roman Nurik's Android-SwipeToDismiss](https://plus.google.com/+RomanNurik/posts/Fgo1p5uWZLu).

