package com.yuc.yuc_magnifyitemlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.yuc.yuc_magnifyitemlistview.adapter.DemoListAdapter;

public class MainActivity extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		lv = (ListView) findViewById(R.id.lv);
		DemoListAdapter adapter = new DemoListAdapter(this);
		lv.setAdapter(adapter);
		
	}
}
