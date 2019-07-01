package com.example.mmc.kotlinprojectgank.ui.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
class NoScrollViewPager :ViewPager{
    private val isPaingEnable = false

    constructor(context:Context):super(context){

    }
    constructor(context: Context,attrs:AttributeSet):super(context,attrs){}

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return this.isPaingEnable && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return this.isPaingEnable && super.onInterceptTouchEvent(ev)
    }
    override fun scrollTo(x:Int,y:Int){
        super.scrollTo(x, y)
    }

}