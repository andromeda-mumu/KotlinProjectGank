package com.example.mmc.kotlinprojectgank.mvp.model

import com.example.mmc.kotlinprojectgank.api.GankApi
import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.bean.JsonResult
import com.example.mmc.kotlinprojectgank.mvp.contract.FuckGoodsContract
import com.example.mmc.kotlinprojectgank.ui.fragment.AndroidFragment
import com.example.mmc.kotlinprojectgank.ui.fragment.GirlFragment
import com.example.mmc.kotlinprojectgank.ui.fragment.IOSFragment
import rx.Observable
import javax.inject.Inject

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
class FuckGoodsModel
@Inject constructor(private val api: GankApi):FuckGoodsContract.Model{
    override fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        when(type){
            AndroidFragment.ANDROID->return api.getAndroidData(page)
            IOSFragment.IOS -> return api.getiOSData(page)
            GirlFragment.GIRL->return api.getGirlData(page)
            else->return api.getAndroidData(page)
        }
    }
}