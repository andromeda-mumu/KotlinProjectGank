package com.example.mmc.kotlinprojectgank.di.component

import com.example.mmc.kotlinprojectgank.mvp.contract.RandomContract
import com.example.mmc.kotlinprojectgank.ui.activity.MainActivity
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
@Subcomponent(modules = arrayOf(RandomModule::class))
interface RandomComponent{
    fun inject(activity: MainActivity)
}
@Module
class RandomModule(private val mView:RandomContract.View){
    @Provides fun getView()=mView
}