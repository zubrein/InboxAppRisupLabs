package xit.zubrein.inbox.ui.auth.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import xit.zubrein.inbox.Utils.pref.PrefKeys
import xit.zubrein.inbox.R
import xit.zubrein.inbox.base.BaseFragment
import xit.zubrein.inbox.databinding.FragmentLoginBinding
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelSignin
import xit.zubrein.inbox.ui.auth.login.LoginViewModel
import xit.zubrein.inbox.ui.auth.login.listener.SigninListener
import xit.zubrein.inbox.utils.Navigator
import xit.zubrein.inbox.utils.ValidationUtils
import xit.zubrein.inbox.utils.error_toast

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(), SigninListener {

    override fun getLayout() = R.layout.fragment_login

    override fun getViewModel() = LoginViewModel::class.java

    override fun onViewReady() {

        if(pref.getBoolean(PrefKeys.LOGIN_STATUS,false)){
            val action = LoginFragmentDirections.actionLoginFragmentToMessagesFragment()
            findNavController().navigate(action)
        }else{
            binding.domain = pref.getString(PrefKeys.DOMAIN_NAME)
            binding.login.setOnClickListener {
                val email = binding.etEmail.text.toString()
                val password = binding.etPassword.text.toString()

                if(!ValidationUtils.isValidEmail(email)){
                    error_toast("Enter a valid email")
                }else if ( password.length < 8){
                    error_toast("Password must be of at least 8 characters")
                }else{
                    val userData  = ModelAuthCredentials(email,password)
                    viewModel.listener = this
                    viewModel.login(userData)
                }

            }
            binding.register.setOnClickListener {
                val action = LoginFragmentDirections.actionLoginFragmentToUsernameFragment()
                findNavController().navigate(action)
            }
        }

    }

    override fun onCallStart() {
        loadingBar.showDialog()
    }

    override fun onReceived(response: LiveData<ModelSignin>) {
        response.observe(this, Observer {
            if (it.token != null) {
                loadingBar.showDialog()
                pref.putString(PrefKeys.AUTH_TOKEN,it.token!!)
                pref.putString(PrefKeys.AUTH_ID, it.id!!)
                pref.putBoolean(PrefKeys.LOGIN_STATUS,true)
                val action = LoginFragmentDirections.actionLoginFragmentToMessagesFragment()
                findNavController().navigate(action)
            }
        })
    }

    override fun onFailed(message: String) {
        loadingBar.cancelDialog()
        error_toast(message)
    }
}
