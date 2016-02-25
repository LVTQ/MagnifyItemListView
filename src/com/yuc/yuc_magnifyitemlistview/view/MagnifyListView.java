package com.yuc.yuc_magnifyitemlistview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class MagnifyListView extends ListView implements OnScrollListener{
	
	private int minHeight;
	private int maxHeight;

	public MagnifyListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setOnScrollListener(this);
	}

	public MagnifyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setOnScrollListener(this);
	}

	public MagnifyListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		setOnScrollListener(this);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
	}
	
	private int lastScroll;
	
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//		L.e("滚动:"+firstVisibleItem+"   "+visibleItemCount+"   "+totalItemCount);
		int myScrollY = getMyScrollY();
//		L.e("滚动:"+myScrollY);
		//防止进入死循环
		if (lastScroll!=myScrollY) {
			for (int i = 0; i < visibleItemCount; i++) {
				MyChangeLinearLayout childAt = (MyChangeLinearLayout) getChildAt(i);
				childAt.onItemChange(myScrollY, i);
			}
		}
		lastScroll=myScrollY;
//		for (int i = 0; i < visibleItemCount; i++) {
//			MyChangeLinearLayout childAt = (MyChangeLinearLayout) getChildAt(i);
//			childAt.onItemChange(getMyScrollY(), i);
//			AbsListView.LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
//			childAt.set
//		}
		
		
	}
	
	
	public int getMyScrollY() {
	     View c = this.getChildAt(0);
	     if (c == null ) {
	         return 0;
	     }
	     int firstVisiblePosition = getFirstVisiblePosition();
	     int top = c.getTop();
	     return -top + firstVisiblePosition * c.getHeight() ;
	}
}
