package com.example.mmc.kotlinprojectgank.ui

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
@BindingAdapter("load_image")
fun loadImage(imageView:ImageView,url:String?)=
        Glide.with(imageView.context).load(url)
                .crossFade()
                .into(imageView)

@BindingAdapter("load_asset")
fun loadAsset(imageView: ImageView,id:Int)=
        Glide.with(imageView.context).load(id).into(imageView)