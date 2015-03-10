package me.ghui.gradledemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by vann on 12/20/14.
 */
public class MainActivity extends ActionBarActivity {
    private static final int NUM_LIST_ITEM = 10;
    ListView mListview;
    ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private ArrayList<String> getListItems() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < NUM_LIST_ITEM; i++) {
            list.add("Image " + i);
        }
        return list;
    }

    private void init() {
        mAdapter = new ListAdapter(this, getListItems());
        mListview = (ListView) findViewById(R.id.listview);
        mListview.setAdapter(mAdapter);
    }

}
