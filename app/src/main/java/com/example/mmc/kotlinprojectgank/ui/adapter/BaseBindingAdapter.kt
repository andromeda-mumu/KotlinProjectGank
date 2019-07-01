package com.example.mmc.kotlinprojectgank.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
abstract class BaseBindingAdapter<B:ViewDataBinding>:RecyclerView.Adapter<DataBoundViewHolder<B>>(){
    var mListener:((pos:Int)->Unit)?=null

    override fun onBindViewHolder(holder: DataBoundViewHolder<B>, position: Int) {
        holder.binding.root.setOnClickListener{
            mListener?.invoke(holder.adapterPosition)
        }
    }

    fun setOnItemClickListener(listener:((pos:Int)->Unit)){
        mListener = listener
    }
}
