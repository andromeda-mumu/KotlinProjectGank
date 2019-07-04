package com.example.mmc.kotlinprojectgank.di.component

import com.example.mmc.kotlinprojectgank.mvp.contract.FuckGoodsContract
import com.example.mmc.kotlinprojectgank.ui.fragment.AndroidFragment
import com.example.mmc.kotlinprojectgank.ui.fragment.GirlFragment
import com.example.mmc.kotlinprojectgank.ui.fragment.IOSFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
@Subcomponent(modules = arrayOf(FuckGoodsModule::class))
interface FuckGoodsComponents { //对fragment进行注入，也就会去查找fragment里面别@inject注解标记的依赖对象，然后找到实例
    fun inject(fragment: AndroidFragment) //这里不能使用父类，因此要单独写子类
    fun inject(fragment: IOSFragment)
    fun inject(fragment: GirlFragment)

}
@Module
class FuckGoodsModule(private val mView:FuckGoodsContract.View){ //但这个参数不是从注入里找的，而是在fragment里传入的
    @Provides fun getView()=mView  //这里就提供view这个依赖实例
}