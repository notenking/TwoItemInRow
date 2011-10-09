package me.two.item;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;

public class TwoItemInOneRowActivity extends ListActivity  {

	private MyListAdapter myAdapter;
	private String[] mStrings = new String[20];
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		for (int i = 0; i < 20; i++) {
			mStrings[i] = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		}
		myAdapter = new MyListAdapter(this, "");
		
		setListAdapter(myAdapter);
	}

	private class MyListAdapter extends ArrayAdapter<String>  implements OnScrollListener{
		private Context mContext;
		/*
		 * public MyListAdapter(Context context) { mContext = context; }
		 */
		public MyListAdapter(Activity activity, String channel) {
			super(activity, 0);
			mContext = (Context) activity;
			// initFooterView(activity);
		}
		public int getCount() {
			if(mContext.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
				return mStrings.length % 3  !=0 ? (mStrings.length / 3 + 1) : (mStrings.length / 3);
			}
				
			return mStrings.length % 2 == 1 ? (mStrings.length / 2 + 1) : (mStrings.length / 2);
			// return
			// myAdapter.getCount()%2==1?(myAdapter.getCount()/2+1):(myAdapter.getCount()/2);
		}

		public View getView(final int position, View convertView, ViewGroup parent) {
			Log.e("position=", "pos=" + position);
			if(mContext.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
				LinearLayout ll;
				if (convertView == null) {
					ll = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.itemrow, parent, false);
				} else {
					ll = (LinearLayout) convertView;
				}

				DontPressWithParentLinearLayout leftLayout = (DontPressWithParentLinearLayout) ll.findViewById(R.id.layout_left);
				DontPressWithParentLinearLayout middleLayout = (DontPressWithParentLinearLayout) ll.findViewById(R.id.layout_middle);
				DontPressWithParentLinearLayout rightLayout = (DontPressWithParentLinearLayout) ll.findViewById(R.id.layout_right);

				TextView textLeft = (TextView) ll.findViewById(R.id.text_left);
				TextView textRight = (TextView) ll.findViewById(R.id.text_right);
				TextView textMiddle = (TextView) ll.findViewById(R.id.text_middle);
				String testLeft = mStrings[3 * position].toString();
				textLeft.setText(testLeft);
				leftLayout.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						Toast.makeText(TwoItemInOneRowActivity.this, "" + 3 * position, Toast.LENGTH_SHORT).show();
					}
				});

				if (3 * position + 1 < mStrings.length) {
					String testMiddle = mStrings[3 * position + 1].toString();
					textMiddle.setText(testMiddle);
					middleLayout.setOnClickListener(new OnClickListener() {
						public void onClick(View arg0) {
							Toast.makeText(TwoItemInOneRowActivity.this, "" + (3 * position + 1), Toast.LENGTH_SHORT).show();
						}
					});
				} else {
					textRight.setText("");
				}
				
				if (3 * position + 2 < mStrings.length) {
					String testRight = mStrings[3 * position + 2].toString();
					textRight.setText(testRight);
					rightLayout.setOnClickListener(new OnClickListener() {
						public void onClick(View arg0) {
							Toast.makeText(TwoItemInOneRowActivity.this, "" + (3 * position + 2), Toast.LENGTH_SHORT).show();
						}
					});
				} else {
					textRight.setText("");
				}
				return ll;
			}else{
			LinearLayout ll;
			if (convertView == null) {
				ll = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.itemrow, parent, false);
			} else {
				ll = (LinearLayout) convertView;
			}

			DontPressWithParentLinearLayout leftLayout = (DontPressWithParentLinearLayout) ll.findViewById(R.id.layout_left);
			DontPressWithParentLinearLayout rightLayout = (DontPressWithParentLinearLayout) ll.findViewById(R.id.layout_right);

			TextView textLeft = (TextView) ll.findViewById(R.id.text_left);
			TextView textRight = (TextView) ll.findViewById(R.id.text_right);
			String testLeft = mStrings[2 * position].toString();
			textLeft.setText(testLeft);
			leftLayout.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					Toast.makeText(TwoItemInOneRowActivity.this, "" + 2 * position, Toast.LENGTH_SHORT).show();
				}
			});

			if (2 * position + 1 < mStrings.length) {
				String testRight = mStrings[2 * position + 1].toString();
				textRight.setText(testRight);
				rightLayout.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						Toast.makeText(TwoItemInOneRowActivity.this, "" + (2 * position + 1), Toast.LENGTH_SHORT).show();
					}
				});
			} else {
				textRight.setText("");
			}
			return ll;
			}
		}
		
		@Override
		public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onScrollStateChanged(AbsListView arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}
	}

}
