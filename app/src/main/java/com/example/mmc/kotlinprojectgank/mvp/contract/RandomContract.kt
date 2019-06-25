package com.example.mmc.kotlinprojectgank.mvp.contract

import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.bean.JsonResult
import rx.Observable

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
interface RandomContract{
    interface View{
        fun onRandom(goods:FuckGoods)
    }
    interface Model{
        fun getRandom(type:String):Observable<JsonResult<List<FuckGoods>>>
    }
    interface Presenter{
        fun getRandom(type:String)
    }
}