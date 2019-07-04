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
interface RandomComponent{ //对mainactivity注入，找到mainActivity里面被@Inject注解标注的依赖，通过去randomModule找到提供的依赖实例，其实提供的view这个依赖实体
    fun inject(activity: MainActivity)
}
@Module
class RandomModule(private val mView:RandomContract.View){ //这里的view是在mainActivity中传入的
    @Provides fun getView()=mView
}