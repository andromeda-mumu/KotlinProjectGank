package com.example.mmc.kotlinprojectgank.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.airbnb.deeplinkdispatch.DeepLink
import com.example.mmc.kotlinprojectgank.R
import com.example.mmc.kotlinprojectgank.databinding.ActivityDetailBinding
import com.example.mmc.kotlinprojectgank.router.GankClientUri
import kotlinx.android.synthetic.main.activity_detail.*
import java.net.URLDecoder

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
@DeepLink("gank://androidwing.net/detail/{${GankClientUri.DEFALT_PARAM_URL}}")
class DetailActivity:BaseBindingActivity<ActivityDetailBinding>(){
    var url = ""
    override fun initView() {
        if(intent.getBooleanExtra(DeepLink.IS_DEEP_LINK,false)){
            url = URLDecoder.decode(intent.extras.getString(GankClientUri.DEFALT_PARAM_URL))
        }
        setupToolbar(toolbar)
        tv_title.text="Gank.io"
        webView.loadUrl(url)
        webView.setWebViewClient(object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(url)
                return true
            }
        })

    }

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityDetailBinding{
        return DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }
}