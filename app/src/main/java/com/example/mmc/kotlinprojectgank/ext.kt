package com.example.mmc.kotlinprojectgank

import android.content.Context
import android.widget.Toast

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
fun Context.getMainComponent() = App.instance.apiComponent

fun Context.toast(msg:String,length:Int= Toast.LENGTH_SHORT){
    Toast.makeText(this,msg,length).show()
}