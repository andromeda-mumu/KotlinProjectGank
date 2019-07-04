package com.example.mmc.kotlinprojectgank.mvp.presenter

import android.util.Log
import com.example.mmc.kotlinprojectgank.mvp.contract.FuckGoodsContract
import com.example.mmc.kotlinprojectgank.mvp.model.FuckGoodsModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by wangjiao on 2019/6/25.
 * description:  这个链接数据和视图的桥梁
 */
class FuckGoodsPresenter
@Inject constructor(private val mModel:FuckGoodsModel,//这个是通过构造方法上面的@inject注入的
                    private val mView:FuckGoodsContract.View) //这个view是通过module的provides注入的，所以依然可以寻找到注入的实例
    :FuckGoodsContract.Presenter,BasePresenter(){
    override fun getData(page: Int, type: String) {
        addSubscription(mModel.getData(page,type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if(!res.error){
                        mView.setData(res.results)
                    }
                },{
                    e->
                    Log.d("=mmc=","----error android presenter----"+e.message)
                })
        )
    }

}