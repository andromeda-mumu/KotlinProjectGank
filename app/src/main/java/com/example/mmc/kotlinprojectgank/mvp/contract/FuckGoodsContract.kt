package com.example.mmc.kotlinprojectgank.mvp.contract

import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.bean.JsonResult
import rx.Observable

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
interface FuckGoodsContract{
    interface View{
        fun setData(result: List<FuckGoods>)

    }
    interface Model{
        fun getData(page:Int,type:String):Observable<JsonResult<List<FuckGoods>>>
    }

    interface  Presenter{
        open fun getData(page:Int,type:String)
    }
}