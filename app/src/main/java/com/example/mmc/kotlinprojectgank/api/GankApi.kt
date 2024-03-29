package com.example.mmc.kotlinprojectgank.api

import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.bean.JsonResult
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
interface GankApi{

    /**
     * android所有数据
     */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>
    /**
     * IOS所有数据
     */
    @GET("data/iOS/10/{page}")
    fun getiOSData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>
    /**
     * 福利
     */
    @GET("data/福利/10/{page}")
    fun getGirlData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>

    /**
     * 手气不错
     */
    @GET("random/data/{type}/1")
    fun getRandom(@Path("type") type:String):Observable<JsonResult<List<FuckGoods>>>
}