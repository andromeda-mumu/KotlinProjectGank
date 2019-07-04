package com.example.mmc.kotlinprojectgank.mvp.contract

import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.bean.JsonResult
import rx.Observable

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 *  典型的MVP
 */
interface FuckGoodsContract{
    //视图设置数据
    interface View{
        fun setData(result: List<FuckGoods>)

    }
    //获取数据
    interface Model{
        fun getData(page:Int,type:String):Observable<JsonResult<List<FuckGoods>>>
    }
    //接口请求数据
    interface  Presenter{
        open fun getData(page:Int,type:String)
    }
}