package com.example.mmc.kotlinprojectgank.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
class DataBoundViewHolder<T:ViewDataBinding>(val binding:T):RecyclerView.ViewHolder(binding.root)