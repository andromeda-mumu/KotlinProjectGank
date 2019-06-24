package com.example.mmc.kotlinprojectgank

import android.app.Application

/**
 * Created by wangjiao on 2019/6/24.
 * description:
 */
class App:Application(){

    companion object {
        lateinit var instance:App
    }
    init {
        instance = this
    }


    override fun onCreate() {
        super.onCreate()

    }
}