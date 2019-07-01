package com.example.mmc.kotlinprojectgank.mvp.presenter

import android.util.Log
import com.example.mmc.kotlinprojectgank.mvp.contract.FuckGoodsContract
import com.example.mmc.kotlinprojectgank.mvp.model.FuckGoodsModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
class FuckGoodsPresenter
@Inject constructor(private val mModel:FuckGoodsModel,
                    private val mView:FuckGoodsContract.View)
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