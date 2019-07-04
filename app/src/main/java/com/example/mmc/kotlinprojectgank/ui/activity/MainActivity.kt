package com.example.mmc.kotlinprojectgank.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.example.mmc.kotlinprojectgank.R
import com.example.mmc.kotlinprojectgank.bean.FuckGoods
import com.example.mmc.kotlinprojectgank.databinding.ActivityMainBinding
import com.example.mmc.kotlinprojectgank.di.component.RandomModule
import com.example.mmc.kotlinprojectgank.getMainComponent
import com.example.mmc.kotlinprojectgank.mvp.contract.RandomContract
import com.example.mmc.kotlinprojectgank.mvp.presenter.RandomPresenter
import com.example.mmc.kotlinprojectgank.router.GankClientUri
import com.example.mmc.kotlinprojectgank.router.GankRouter
import com.example.mmc.kotlinprojectgank.toast
import com.example.mmc.kotlinprojectgank.ui.fragment.AndroidFragment
import com.example.mmc.kotlinprojectgank.ui.fragment.FragmentHolder
import com.example.mmc.kotlinprojectgank.ui.fragment.GirlFragment
import com.example.mmc.kotlinprojectgank.ui.fragment.IOSFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import javax.inject.Inject
/**
 * Created by wangjiao on 2019/6/25.
 * description:
 */
class MainActivity : BaseBindingActivity<ActivityMainBinding>(),RandomContract.View{

    lateinit var mFragments :MutableList<Fragment>
    @Inject lateinit var mPresenter:RandomPresenter //通过注入的方式，已经获得了实例，在第一次使用时，才注入，有实例

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    override fun initView(){
        initFragments()
        getMainComponent().plus(RandomModule(this)).inject(this) //注入
        viewPager.adapter = object :FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(position:Int)= mFragments[position]
            override fun getCount()=mFragments.size
        }
        viewPager.offscreenPageLimit = 4

        navigationView.setOnNavigationItemSelectedListener { item->
            var tab =0
            when(item.itemId){
                R.id.menu_android->tab =0
                R.id.menu_ios->tab =1
                R.id.menu_girl->tab =2
                R.id.menu_about ->tab =3
            }
            viewPager.currentItem = tab
            false
        }

        floatingButton.setOnClickListener{
            mPresenter.getRandom("Android")
        }
    }

    override fun onRandom(goods:FuckGoods){
        val url = URLEncoder.encode(goods.url)
        toast("手气不错~")
        GankRouter.router(this,GankClientUri.DETAIL+url)
    }

    private fun initFragments() {
        mFragments = ArrayList()
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(IOSFragment.newInstance())
        mFragments.add(GirlFragment.newInstance())
        mFragments.add(FragmentHolder())
    }

}

