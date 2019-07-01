package com.example.mmc.kotlinprojectgank.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.databinding.ItemFuckgoodsBinding

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
class FuckGoodsAdapter(private val mList:List<FuckGoods>):BaseBindingAdapter<ItemFuckgoodsBinding>(){
    override  fun getItemCount():Int{
        return mList.size
    }
    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemFuckgoodsBinding>, position:Int){
        super.onBindViewHolder(holder,position)
        holder.binding.fuckgoods = mList[position]
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType:Int):DataBoundViewHolder<ItemFuckgoodsBinding>{
        return DataBoundViewHolder(ItemFuckgoodsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}