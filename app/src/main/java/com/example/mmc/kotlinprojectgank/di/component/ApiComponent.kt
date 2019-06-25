package com.example.mmc.kotlinprojectgank.di.component

import com.example.mmc.kotlinprojectgank.App
import com.example.mmc.kotlinprojectgank.di.module.ApiModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent{
    fun inject(app: App)
    fun plus(module: FuckGoodsModule): FuckGoodsComponents
    fun plus(module:RandomModule):RandomComponent
}