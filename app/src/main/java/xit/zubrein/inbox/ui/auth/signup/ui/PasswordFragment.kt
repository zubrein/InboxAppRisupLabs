package xit.zubrein.inbox.ui.auth.signup.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import xit.zubrein.inbox.utils.pref.PrefKeys
import xit.zubrein.inbox.R
import xit.zubrein.inbox.base.BaseFragment
import xit.zubrein.inbox.databinding.FragmentPasswordBinding
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelSignup
import xit.zubrein.inbox.ui.auth.signup.SignupViewModel
import xit.zubrein.inbox.ui.auth.signup.listener.SignupListener
import xit.zubrein.inbox.utils.error_toast
import xit.zubrein.inbox.utils.info_toast
import xit.zubrein.inbox.utils.success_toast

class PasswordFragment : BaseFragment<FragmentPasswordBinding,SignupViewModel>(),SignupListener {

    private val args: PasswordFragmentArgs by navArgs()

    override fun getLayout() = R.layout.fragment_password

    override fun getViewModel() = SignupViewModel::class.java

    override fun onViewReady() {

        val username = "${args.username}@${pref.getString(PrefKeys.DOMAIN_NAME)}"

        binding.createAccount.setOnClickListener {
            val password = binding.etPassword.text.toString().trim()
            if(password.length<8){
                info_toast("Password must be of at least 8 characters")
            }else{

                val userData = ModelAuthCredentials(username,password)

                viewModel.listener = this
                viewModel.createAccount(userData)

            }
        }

    }

    override fun onCallStart() {
        loadingBar.showDialog()
    }

    override fun onReceived(response: LiveData<ModelSignup>) {

        response.observe(this, Observer {
            if(it.type == "Account"){
                loadingBar.cancelDialog()
                success_toast("Account successfully created")
                val action = PasswordFragmentDirections.actionPasswordFragmentToLoginFragment()
                findNavController().navigate(action)
            }
        })
    }

    override fun onFailed(message: String) {
        loadingBar.cancelDialog()
        error_toast(message)
        findNavController().popBackStack(R.id.usernameFragment,true)
    }

}