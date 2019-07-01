package com.example.mmc.kotlinprojectgank.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLink
import com.example.mmc.kotlinprojectgank.R
import com.example.mmc.kotlinprojectgank.router.GankClientUri

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
@DeepLink(GankClientUri.ABOUT)
class AboutActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}