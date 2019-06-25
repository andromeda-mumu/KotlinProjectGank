package com.example.mmc.kotlinprojectgank.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
@Module
class AppModule(private val context:Context){
    @Provides fun provideContext()=context
}