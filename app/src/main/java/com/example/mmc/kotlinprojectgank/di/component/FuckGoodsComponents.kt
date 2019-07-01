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
interface FuckGoodsComponents {
    fun inject(fragment: AndroidFragment)
    fun inject(fragment: IOSFragment)
    fun inject(fragment: GirlFragment)

}
@Module
class FuckGoodsModule(private val mView:FuckGoodsContract.View){
    @Provides fun getView()=mView
}