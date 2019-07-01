package com.example.mmc.kotlinprojectgank.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mmc.kotlinprojectgank.databinding.FragmentAboutBinding

/**
 * Created by wangjiao on 2019/6/26.
 * description:
 */
class FragmentHolder : BaseBindingFragment<FragmentAboutBinding>(){
    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): FragmentAboutBinding{
        return FragmentAboutBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        val text ="Kotlin \n"
                .plus("Dagger 2\n")
                .plus("Rxjava\n")
                .plus("retrofit 2\n")
                .plus("okhttp 3 \n")
                .plus("dataBinding\n")
                .plus("DeepLinkDispatch\n")
                .plus("Gson\n")
                .plus("Glide")
        mBinding?.tvThank?.text =text
    }
}