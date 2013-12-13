package com.thbs.swipetodismiss;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity { 
	
	CustomAdapter customAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView listView = (ListView) findViewById(android.R.id.list);

		List<String> list = new ArrayList<String>();
		list.add("Line 1");
		list.add("Line 2");
		list.add("Line 3");
		list.add("Line 4");
		list.add("Line 5");
		list.add("Line 6");
		list.add("Line 7");
		list.add("Line 8");
		list.add("Line 9");
		list.add("Line 10");
		list.add("Line 11");
		list.add("Line 12");
		list.add("Line 13");
		list.add("Line 14");
		list.add("Line 15");  
		

		customAdapter = new CustomAdapter(getApplicationContext(), list);

		// Set your CustomAdapter to your ListView
		listView.setAdapter(customAdapter);
		// Set the SwipeListViewTouchListener to look for Swipe and perform
		// relevant actions
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
							Toast.makeText(getApplicationContext(),
									"Left swipe", Toast.LENGTH_SHORT).show();
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
							Toast.makeText(getApplicationContext(),
									"Right swipe", Toast.LENGTH_SHORT).show();
							customAdapter.notifyDataSetChanged();
						}
					}
				}, true, // Left swipe action = dismiss. set it to false to
							// dismiss without animation
				true); // Right swipe action = dismiss. Set it to false to
						// dismiss without animation

		listView.setOnTouchListener(touchListener);
		// Setting this scroll listener is required to ensure that during
		// ListView scrolling, we don't look for swipes.
		listView.setOnScrollListener(touchListener.makeScrollListener());

	}

}
