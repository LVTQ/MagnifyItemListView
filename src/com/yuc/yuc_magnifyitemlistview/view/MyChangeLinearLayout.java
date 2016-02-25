package com.yuc.yuc_magnifyitemlistview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

@SuppressLint("NewApi")
public class MyChangeLinearLayout extends LinearLayout{
	
	public static int minheight = 250;
	public static int maxheight = 500;
	
	public static int endBigLoc = maxheight/2+100;//结束放大的位置
	public static int startBigLoc = endBigLoc+minheight*3+120;//开始放大的位置
	
	public MyChangeLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MyChangeLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyChangeLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	private boolean isLast = false;//最后几个设置为透明
	
	public void setLast(boolean b){
		isLast=b;
	}
	
	
	public void onItemChange(int scrollY,int currentItem){
		
//		L.e("第"+currentItem+":"+scrollY);
		
		if (scrollY%maxheight==0) {
			return;
		}
		
		//计算距离顶部的距离
		int itemTop = getItemTop(currentItem, scrollY);
		int itemHerght = getCurrentItemHerght(itemTop);
		//最后一个是全透明的,为了保证最后一条数据能被完全展开
		if (isLast) {
			setAlpha(0);
			ViewGroup parent = (ViewGroup) getParent();
			setMinimumHeight(parent.getHeight()-endBigLoc-maxheight);
		}else{
			setAlpha(getCurrentItemAlpha(itemTop, 0.2f, 1));
			setMinimumHeight(itemHerght);
		}
		View childAt = getChildAt(0);
		LinearLayout.LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
		layoutParams.height=itemHerght;
		
//		if (currentItem==0||currentItem==1) {
//			L.e("di:"+currentItem+" :"+itemHerght);
//		}
	}
	
	/**
	 * 计算当前item的距离顶部的距离
	 * @param item
	 * @return
	 */
	private int getItemTop(int item,int scrollY){
		if (item==0) {
			return -(scrollY%maxheight);
		}
		int itemTop = getItemTop(item-1,scrollY);
		int currentItemHerght = getCurrentItemHerght(itemTop);
//		L.e("第"+item+"  "+(currentItemHerght+itemTop));
		return currentItemHerght+itemTop;
		
	}
	
	/**
	 * 根据当前item距离顶部的距离,计算当前item的高度
	 * @param top
	 * @return
	 */
	private int getCurrentItemHerght(int top){
		if (top<=endBigLoc) {
//			setMinimumHeight(height+dheight);
			return maxheight;
		}else if(top>=startBigLoc){
//			setMinimumHeight(height);
			return minheight;
		}else{
			//渐变
			int h=(int) (minheight+((startBigLoc-top+0.0)/(startBigLoc-endBigLoc))*(maxheight-minheight));
//			L.e("调整:"+currentItem+"  top:"+top+"  gaodu:"+h);
//			setMinimumHeight(h);
			return h;
		}
	}
	/**
	 * 根据当前item距离顶部的距离,计算当前item的透明度
	 * @param top
	 * @return
	 */
	private float getCurrentItemAlpha(int top,float start,float end){
		if (top<=endBigLoc) {
			return end;
		}else if(top>=startBigLoc){
			return start;
		}else{
			//渐变
			float h=start+((startBigLoc-top+0.0f)/(startBigLoc-endBigLoc))*(end-start);
			
			return h;
		}
	}
	
}
