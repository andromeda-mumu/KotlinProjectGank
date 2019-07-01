package com.example.mmc.kotlinprojectgank.mvp.model

import com.example.mmc.kotlinprojectgank.api.GankApi
import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.bean.JsonResult
import com.example.mmc.kotlinprojectgank.mvp.contract.RandomContract
import rx.Observable
import javax.inject.Inject

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
class RandomModel
@Inject constructor(private val api:GankApi):RandomContract.Model{
    override fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>> {
        return api.getRandom(type)
    }
}