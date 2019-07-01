package com.example.mmc.kotlinprojectgank.mvp.presenter

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
open class BasePresenter{
    var compositeSubscription = CompositeSubscription()

    protected fun addSubscription(subscription: Subscription){
        compositeSubscription.add(subscription)
    }

    fun unSubscibe(){
        if(compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe()
        }
    }
}