package com.example.mmc.kotlinprojectgank.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.databinding.ItemGirlBinding

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
class GirlAdapter(private val mList:List<FuckGoods>):BaseBindingAdapter<ItemGirlBinding>(){
    override fun getItemCount():Int{
        return mList.size
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemGirlBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.girl = mList[holder.adapterPosition]
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<ItemGirlBinding> {
        return DataBoundViewHolder(ItemGirlBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}