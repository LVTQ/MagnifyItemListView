package com.yuc.yuc_magnifyitemlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.yuc.yuc_magnifyitemlistview.R;
import com.yuc.yuc_magnifyitemlistview.view.MyChangeLinearLayout;

public abstract class MagnifyListviewAdapter extends BaseAdapter{
	
	protected Context context;
//	private LayoutInflater inflater;
	
	public  MagnifyListviewAdapter(Context context) {
		this.context=context;
		
		MyChangeLinearLayout.minheight=getMinheight();
		MyChangeLinearLayout.maxheight=getMaxheight();
		MyChangeLinearLayout.endBigLoc=getEndBigLoc();
		MyChangeLinearLayout.startBigLoc=getStartBigLoc();
		
	}
	
	@Override
	public int getCount() {
		return getMyCount()+1;
	}
	
	public abstract int getMyCount();

	@Override
	public View getView(int item, View view, ViewGroup arg2) {
		
		if (view==null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.listview_magnify_item_layout, null);
			LinearLayout listview_item_ll = (LinearLayout) view.findViewById(R.id.listview_item_ll);
			listview_item_ll.addView(getMyView(item, null, arg2));
			
			//初始化高度
			MyChangeLinearLayout v = (MyChangeLinearLayout) view;
			v.onItemChange(1, item);
		}else{
			view = getMyView(item, view, arg2);
			
			view.setMinimumHeight(getMaxheight());
			View childAt = ((ViewGroup)view).getChildAt(0);
			LinearLayout.LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
			layoutParams.height=getMaxheight();
		}
		
		
		MyChangeLinearLayout v = (MyChangeLinearLayout) view;
		if (getCount()-1==item) {
			v.setLast(true);
		}else{
			v.setLast(false);
		}
		
		
		return view;
	}
	
	public abstract View getMyView(int item, View view, ViewGroup arg2);
	
	/**
	 * 最小高度
	 * @return
	 */
	public abstract int getMinheight();
	/**
	 * 最大高度
	 * @return
	 */
	public abstract int getMaxheight();
	/**
	 * 完全展开位置-Y轴
	 * @return
	 */
	public abstract int getEndBigLoc();
	/**
	 * 完全展开位置-Y轴
	 * @return
	 */
	public abstract int getStartBigLoc();
	
}
