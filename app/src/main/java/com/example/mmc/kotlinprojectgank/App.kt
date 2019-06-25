package com.example.mmc.kotlinprojectgank

import android.app.Application
import com.example.mmc.kotlinprojectgank.di.component.DaggerApiComponent
import com.example.mmc.kotlinprojectgank.di.module.ApiModule
import com.example.mmc.kotlinprojectgank.di.module.AppModule

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
        //先自动生成
        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }
}