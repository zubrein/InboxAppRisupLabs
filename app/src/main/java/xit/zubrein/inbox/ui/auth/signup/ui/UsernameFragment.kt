package xit.zubrein.inbox.ui.auth.signup.ui

import androidx.navigation.fragment.findNavController
import xit.zubrein.inbox.utils.pref.PrefKeys
import xit.zubrein.inbox.R
import xit.zubrein.inbox.base.BaseFragment
import xit.zubrein.inbox.databinding.FragmentUsernameBinding
import xit.zubrein.inbox.ui.auth.signup.SignupViewModel
import xit.zubrein.inbox.utils.info_toast

class UsernameFragment : BaseFragment<FragmentUsernameBinding,SignupViewModel>() {

    override fun getLayout() = R.layout.fragment_username

    override fun getViewModel() = SignupViewModel::class.java

    override fun onViewReady() {

        binding.domain = pref.getString(PrefKeys.DOMAIN_NAME)
        binding.next.setOnClickListener {
            val username = binding.etUusername.text.toString().trim()
            if(username.length < 5){
                info_toast("Username must be of at least 5 characters")
            }else{
                val action =  UsernameFragmentDirections.actionUsernameFragmentToPasswordFragment(username)
                findNavController().navigate(action)
            }

        }

    }


}