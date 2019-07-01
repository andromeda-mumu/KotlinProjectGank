package com.example.mmc.kotlinprojectgank.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mmc.kotlinprojectgank.R
import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.databinding.ViewRecyclerBinding
import com.example.mmc.kotlinprojectgank.di.component.FuckGoodsModule
import com.example.mmc.kotlinprojectgank.getMainComponent
import com.example.mmc.kotlinprojectgank.mvp.contract.FuckGoodsContract
import com.example.mmc.kotlinprojectgank.mvp.presenter.FuckGoodsPresenter
import com.example.mmc.kotlinprojectgank.ui.activity.ImageActivity
import com.example.mmc.kotlinprojectgank.ui.adapter.GirlAdapter
import kotlinx.android.synthetic.main.view_recycler.*
import javax.inject.Inject

/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
class GirlFragment :BaseBindingFragment<ViewRecyclerBinding>(),FuckGoodsContract.View{
    private lateinit var mRecyclerView:RecyclerView
    private var mList = ArrayList<FuckGoods>()
    private lateinit var mAdapter: GirlAdapter
    private var mPage = 1
    @Inject lateinit var mPresenter :FuckGoodsPresenter

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewRecyclerBinding {
        return ViewRecyclerBinding.inflate(inflater,container,false)
    }

    override fun initView(){
        mAdapter = GirlAdapter(mList)
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)
        with(mBinding!!){
            mRecyclerView = recyclerView
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = GridLayoutManager(context,2)
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if(!recyclerView?.canScrollVertically(1)!!){
                        mPresenter.getData(++mPage,GIRL)
                    }
                }

                override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                }
            })
            mPresenter.getData(mPage,GIRL)
        }
        mAdapter.setOnItemClickListener {
            pos->
            val imageView = recyclerView.findViewHolderForAdapterPosition(pos)?.itemView?.findViewById(R.id.iv_girl) as ImageView
            ImageActivity.startActivity(context,imageView,mList[pos].url)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unSubscibe()
    }

    override  fun setData(results:List<FuckGoods>){
        mList.addAll(results)
        mAdapter.notifyDataSetChanged()
    }

    companion object {
        val GIRL = "GIRL"
        fun newInstance():GirlFragment{
            val fragment = GirlFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


}