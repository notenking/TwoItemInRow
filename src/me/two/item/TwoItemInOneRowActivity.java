package me.two.item;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TwoItemInOneRowActivity extends ListActivity {

	private MyListAdapter myAdapter;
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myAdapter = new MyListAdapter(this,"");
        myAdapter.add("testa");
        myAdapter.add("testb");
        myAdapter.add("testc");
        myAdapter.add("testd");
        myAdapter.add("teste");
        myAdapter.add("testf");
        myAdapter.add("testg");
        myAdapter.add("testh");
        setListAdapter(myAdapter);
    }

	private class MyListAdapter extends ArrayAdapter {
        /*public MyListAdapter(Context context) {
            mContext = context;
        }*/
		public MyListAdapter(Activity activity, String channel) {
			super(activity, 0);
			mContext = (Context) activity;
			
			// initFooterView(activity);
		}

        public int getCount() {
            //return mStrings.length%2==1?(mStrings.length/2+1):(mStrings.length/2);
           // return myAdapter.getCount()%2==1?(myAdapter.getCount()/2+1):(myAdapter.getCount()/2);
        	return 4;
        }

        /*@Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return !mStrings[position].startsWith("-");
        }
*/
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
        	Log.e("position=","pos="+position);
            LinearLayout ll;
            if (convertView == null) {
            	ll = (LinearLayout) LayoutInflater.from(mContext).inflate(
                        R.layout.itemrow, parent, false);
            } else {
            	ll = (LinearLayout) convertView;
            }
            
            DontPressWithParentLinearLayout leftLayout = (DontPressWithParentLinearLayout)ll.findViewById(R.id.layout_left);
            DontPressWithParentLinearLayout rightLayout = (DontPressWithParentLinearLayout)ll.findViewById(R.id.layout_right);
            leftLayout.setOnClickListener(null);
            rightLayout.setOnClickListener(null);
            TextView textLeft = (TextView)ll.findViewById(R.id.text_left);
            TextView textRight = (TextView)ll.findViewById(R.id.text_right);
            String testLeft=myAdapter.getItem(2*position).toString();
            textLeft.setText(testLeft);
            String testRight=myAdapter.getItem(2*position+1).toString();
            if(2*position+1<myAdapter.getCount()){
            textRight.setText(testRight);
            }else{
            	textRight.setText("");
            }
            return ll;
        }

        private Context mContext;
    }
    
    private String[] mStrings = {
            "----------",
            "----------",
            "Abbaye de Belloc",
            "Abbaye du Mont des Cats",
            "Abertam",
            "----------",
            "Abondance",
            "----------",
            "Ackawi",
            "Acorn",
            "Adelost",
            "Affidelice au Chablis",
            "Afuega'l Pitu",
            "Airag",
            "----------",
            "Airedale",
            "Aisy Cendre",
            "----------",
            "Allgauer Emmentaler",
            "Alverca",
            "Ambert",
            "American Cheese",
            "Ami du Chambertin",
            "----------",
            "----------",
            "Anejo Enchilado",
            "Anneau du Vic-Bilh",
            "Anthoriro",
            "----------",
            "----------",
            "----abcdef------"
    };

}
