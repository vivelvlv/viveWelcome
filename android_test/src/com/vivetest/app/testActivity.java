package com.vivetest.app;

import android.app.Activity;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 9020MT on 2014/8/23.
 */
public class testActivity extends Activity {

    private ListView listView;
    private Button add;
    private MyPerson observable;
    private int i = 1;
    private Button change;
    private ListView lv;
    private List<MyObserver> myObservers;
    private Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            // 将信息加入list中显示
            testAdapter myListAdapter = new testAdapter(testActivity.this, myObservers);
            lv.setAdapter(myListAdapter);
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listView);
//        testAdapter simpleAdapter = new testAdapter(this,myObservers);
//        listView.setAdapter(simpleAdapter);
        observable = new MyPerson();
        myObservers = new ArrayList<MyObserver>();
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {//add new observer

            @Override
            public void onClick(View view) {
                MyObserver myObserver = new MyObserver(i);
                i++;
                observable.addObserver(myObserver);//set observer to watch the subject MyPerson
                myObservers.add(myObserver);//add this new observer to observers list, for show
                handler.sendEmptyMessage(0);//send to UI,show observers list
            }
        });
        change = (Button)findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                observable.setAge(10 + i);
                observable.setName("a" + i);
                observable.setSex("男" + i);
                handler.sendEmptyMessage(0);
                //update MyPerson contents
                //and then ,all oberserver list items  update fuction will be executed
            }
        });
    }
}
