package com.vivetest.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 9020MT on 2014/8/23.
 */
public class testAdapter extends BaseAdapter {

    private Context context;
    public List<?> list = null;
    public LayoutInflater inflater = null;
    public testAdapter(Context context, List<?> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        if(list == null)
            return 0;
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.layout_test_item,null);
        TextView id = (TextView)view.findViewById(R.id.watcherId);
        TextView content = (TextView)view.findViewById(R.id.watcherContent);
        if(list.size() != 0) {
            if(((MyObserver)list.get(i)).getMyPerson()!= null) {
                MyObserver myObserver = (MyObserver) list.get(i);
                id.setText("观察者ID = " + myObserver.getI());
                content.setText("观察到的内容 = " + myObserver.getMyPerson().toString());
            }else{
                id.setText("增加新观察者ID = "+((MyObserver)list.get(i)).getI() );
                content.setText("观察到的内容 = 暂时没有" );
            }
        }else{
            id.setText("观察者ID = " + 0);
            content.setText("观察到的内容 = " + 0);
        }
        return view;
    }
}
