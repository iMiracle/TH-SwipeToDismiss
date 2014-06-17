TH-SwipeToDismiss
====================================

A mini-library/sample code that shows how to make a `ListView` support the swipe-to-dismiss Android UI pattern with feedback.

![alt text](https://raw.github.com/torryharris/TH-SwipeToDismiss/master/TH-SwipeToDismiss.gif "")

## How to use:

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
		

##Demo
<a href="https://play.google.com/store/apps/details?id=com.thbs.swipetodismiss">
  <img alt="Get it on Google Play"
       src="https://developer.android.com/images/brand/en_generic_rgb_wo_60.png" />
</a>
 
## Are you using this framework?
   If you are using this framework in your app, please feel free to add your app to the [wiki](https://github.com/torryharris/TH-SwipeToDismiss/wiki/Wiki) 
 
 
See the original [Roman Nurik's Android-SwipeToDismiss](https://github.com/romannurik/Android-SwipeToDismiss).

