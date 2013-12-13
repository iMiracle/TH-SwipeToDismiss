package com.thbs.swipetodismiss;

import java.util.List; 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter

{

	LayoutInflater inflater;
	List<String> items;
	public static ImageView img;

	public CustomAdapter(Context context, List<String> items) {
		super();

		this.items = items;
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public void remove(int position) {
		items.remove(position);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		View vi = convertView;

		if (convertView == null)
			vi = inflater.inflate(R.layout.item_row, null);
		TextView tt = (TextView) vi.findViewById(R.id.txtTitle);
		tt.setText(items.get(position).toString());
		String text = items.get(position).toString();
		img = (ImageView) vi.findViewById(R.id.imgThumbnail);
		
		if (text.equalsIgnoreCase("Line 1")||text.equalsIgnoreCase("Line 6")||text.equalsIgnoreCase("Line 11")){
			img.setImageResource(R.drawable.square_blue_light);
		}
		if (text.equalsIgnoreCase("Line 2")||text.equalsIgnoreCase("Line 7")||text.equalsIgnoreCase("Line 12")){
			img.setImageResource(R.drawable.square_blue_dark);
		}
		if (text.equalsIgnoreCase("Line 3")||text.equalsIgnoreCase("Line 8")||text.equalsIgnoreCase("Line 13")){
			img.setImageResource(R.drawable.square_green_light);
		}
		if (text.equalsIgnoreCase("Line 4")||text.equalsIgnoreCase("Line 9")||text.equalsIgnoreCase("Line 14")){
			img.setImageResource(R.drawable.square_green_dark);
		}
		if (text.equalsIgnoreCase("Line 5")||text.equalsIgnoreCase("Line 10")||text.equalsIgnoreCase("Line 15")){
			img.setImageResource(R.drawable.square_black);
		}
		 
	 	
		return vi;
	}
}
