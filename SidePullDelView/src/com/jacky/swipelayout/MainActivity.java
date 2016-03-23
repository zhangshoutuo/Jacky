package com.jacky.swipelayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.jacky.swipelayout.adapter.MyAdapter;

public class MainActivity extends Activity {

	private static final String TAG = "TAG";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView mList = (ListView) findViewById(R.id.lv);
		mList.setAdapter(new MyAdapter(MainActivity.this));
		
		
	}

}
