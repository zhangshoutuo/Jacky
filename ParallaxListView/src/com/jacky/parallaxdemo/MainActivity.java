package com.jacky.parallaxdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.jacky.parallaxdemo.ui.MyListView;
import com.jacky.parallaxdemo.util.Cheeses;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		final MyListView mListView = (MyListView) findViewById(R.id.lv);
		mListView.setOverScrollMode(View.OVER_SCROLL_NEVER);

		// 加Header
		final View mHeaderView = View.inflate(MainActivity.this, R.layout.view_header, null);
		final ImageView mImage = (ImageView) mHeaderView.findViewById(R.id.iv);
		mListView.addHeaderView(mHeaderView);
		
		mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				// 当布局填充结束之后, 此方法会被调用

				mListView.setParallaxImage(mImage);
				
				mHeaderView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
			}
		});
		
		// 填充数据
		mListView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Cheeses.NAMES));
		
	}

}
