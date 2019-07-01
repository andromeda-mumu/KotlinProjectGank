package com.example.mmc.kotlinprojectgank.mvp.presenter

import android.util.Log
import com.example.mmc.kotlinprojectgank.mvp.contract.RandomContract
import com.example.mmc.kotlinprojectgank.mvp.model.RandomModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
class RandomPresenter
@Inject constructor(private val mModel: RandomModel,
                    private val mView:RandomContract.View):RandomContract.Presenter,BasePresenter(){
    override fun getRandom(type: String) {
        addSubscription(mModel.getRandom(type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res->
                    if(!res.error){
                        mView.onRandom(res.results[0])
                    }
                },{ e->
                    Log.d("=mmc=","----error random presenter----"+e.message)}))
    }
}