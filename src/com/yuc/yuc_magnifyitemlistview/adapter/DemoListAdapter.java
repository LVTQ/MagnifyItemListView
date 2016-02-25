package com.yuc.yuc_magnifyitemlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuc.yuc_magnifyitemlistview.R;
import com.yuc.yuc_magnifyitemlistview.util.DensityUtils;

public class DemoListAdapter extends MagnifyListviewAdapter{
	
	private LayoutInflater inflater;
	
	public DemoListAdapter(Context context){
		super(context);
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMyCount() {
		return 30;
	}
	
	@Override
	public View getMyView(int item, View view, ViewGroup arg2) {
		
		if (view==null) {
			view = inflater.inflate(R.layout.commodity_list_item_layout, null);
		}
		
		return view;
	
	}

	@Override
	public int getMinheight() {
		return DensityUtils.dp2px(context, 50);
	}

	@Override
	public int getMaxheight() {
		return DensityUtils.dp2px(context, 150);
	}

	@Override
	public int getEndBigLoc() {
		return getMaxheight()/2;
	}

	@Override
	public int getStartBigLoc() {
		return (int) (getEndBigLoc()+getMaxheight()*2.5);
	}
	
	
}
