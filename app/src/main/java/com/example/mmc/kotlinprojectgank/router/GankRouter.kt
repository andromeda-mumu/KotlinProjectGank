package com.example.mmc.kotlinprojectgank.router

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
object GankRouter{
    fun router(context: Context,uri:String){
        val intent = Intent()
        intent.data = Uri.parse(uri)
        intent.action = Intent.ACTION_VIEW
        context.startActivity(intent)
    }
}