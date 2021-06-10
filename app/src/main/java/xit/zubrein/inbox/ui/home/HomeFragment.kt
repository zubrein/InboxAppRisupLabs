package xit.zubrein.inbox.ui.home

import xit.zubrein.inbox.R
import xit.zubrein.inbox.base.BaseFragment
import xit.zubrein.inbox.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>() {

    override fun getLayout() =  R.layout.fragment_home

    override fun getViewModel() = HomeViewModel::class.java

    override fun onViewReady() {
        
    }


}