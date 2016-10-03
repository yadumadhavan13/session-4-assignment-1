package com.example.y.sortinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mlistview;
    private ArrayList<String> mitems;
    private Button ascending_button;
    private Button descending_button;
    Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistview = (ListView) findViewById(R.id.months_listview);
        ascending_button = (Button) findViewById(R.id.ascendingbutton);
        descending_button = (Button) findViewById(R.id.descendingbutton);

        mitems = new ArrayList<>();

        mitems.add("January");
        mitems.add("February");
        mitems.add("March");
        mitems.add("April");
        mitems.add("May");
        mitems.add("June");
        mitems.add("July");
        mitems.add("August");
        mitems.add("September");
        mitems.add("October");
        mitems.add("November");
        mitems.add("December");

        myadapter = new Myadapter();
        mlistview.setAdapter(myadapter);



        ascending_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                ascending();
                myadapter.notifyDataSetChanged();



            }
        });
        descending_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                descending();
                myadapter.notifyDataSetChanged();

            }
        });


    }
    class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mitems.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.months_row_view,parent,false);
                holder = new ViewHolder();
                holder.bindview(convertView);
                convertView.setTag(holder);
                Log.e("MainActivity","convertView is NULL");
            }else{
                Log.e("MainActivity","convertview is not null" );
                holder = (ViewHolder)convertView.getTag();
            }
            holder.tv_months_list.setText(mitems.get(position));
            return convertView;
        }
    }
    public class ViewHolder{
        TextView tv_months_list;

         void bindview(View convertView){
            tv_months_list = (TextView) convertView.findViewById(R.id.textview_months_list);
        }

    }
    public void ascending(){
        Collections.sort(this.mitems);

    }
    public void descending(){
        Collections.sort(this.mitems,Collections.<String>reverseOrder());
    }
}
