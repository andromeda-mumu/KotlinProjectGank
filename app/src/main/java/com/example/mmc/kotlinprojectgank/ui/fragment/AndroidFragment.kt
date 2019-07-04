package com.example.mmc.kotlinprojectgank.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.databinding.ViewRecyclerBinding
import com.example.mmc.kotlinprojectgank.di.component.FuckGoodsModule
import com.example.mmc.kotlinprojectgank.getMainComponent
import com.example.mmc.kotlinprojectgank.mvp.contract.FuckGoodsContract
import com.example.mmc.kotlinprojectgank.mvp.presenter.FuckGoodsPresenter
import com.example.mmc.kotlinprojectgank.router.GankClientUri
import com.example.mmc.kotlinprojectgank.router.GankRouter
import com.example.mmc.kotlinprojectgank.ui.adapter.FuckGoodsAdapter
import java.net.URLEncoder
import javax.inject.Inject

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
class AndroidFragment :BaseBindingFragment<ViewRecyclerBinding>(),FuckGoodsContract.View{
    private var mList = ArrayList<FuckGoods>()
    private lateinit var mAdapter:FuckGoodsAdapter
    private var mPage = 1
    @Inject lateinit var mPresenter:FuckGoodsPresenter
    override fun createDataBinding(inflater: LayoutInflater?,container:ViewGroup?,savedInstanceState: Bundle?): ViewRecyclerBinding {
        return ViewRecyclerBinding.inflate(inflater,container,false)
    }
    override fun initView(){
        mAdapter = FuckGoodsAdapter(mList)
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this) //注入
        with(mBinding!!){
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = LinearLayoutManager(context)

            recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if(!recyclerView?.canScrollVertically(1)!!){ //两个!!啥意思
                        mPresenter.getData(++mPage,ANDROID)
                    }
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                }
            })
        }

        mPresenter.getData(mPage,ANDROID)

        mAdapter.setOnItemClickListener {
            pos-> //-> 符号之前的是参数，符号之后的是方法逻辑
            val url = URLEncoder.encode(mList[pos].url)
            GankRouter.router(context,GankClientUri.DETAIL+url)
        }
    }

    override fun setData(results:List<FuckGoods>){
        mList.addAll(results)
        mAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unSubscibe()
    }

   companion object {
       val ANDROID="ANDROID"
       fun newInstance():AndroidFragment{
           val fragment = AndroidFragment()
           val bundle = Bundle()
           fragment.arguments = bundle
           return fragment
       }
   }
}
