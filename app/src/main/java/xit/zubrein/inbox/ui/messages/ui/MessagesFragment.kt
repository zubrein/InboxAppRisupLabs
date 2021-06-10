package xit.zubrein.inbox.ui.messages.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import xit.zubrein.inbox.R
import xit.zubrein.inbox.utils.pref.PrefKeys
import xit.zubrein.inbox.adapter.MessageAdapter
import xit.zubrein.inbox.base.BaseFragment
import xit.zubrein.inbox.databinding.FragmentMessagesBinding
import xit.zubrein.inbox.model.ModelMessage
import xit.zubrein.inbox.ui.auth.login.ui.LoginFragmentDirections
import xit.zubrein.inbox.ui.messages.MessagesViewModel
import xit.zubrein.inbox.ui.messages.listener.MessageListener
import xit.zubrein.inbox.utils.error_toast

class MessagesFragment : BaseFragment<FragmentMessagesBinding, MessagesViewModel>(),
    MessageListener {

    override fun getLayout() = R.layout.fragment_messages

    override fun getViewModel() = MessagesViewModel::class.java

    override fun onViewReady() {

        if(!pref.getBoolean(PrefKeys.LOGIN_STATUS,false)){
            val action = MessagesFragmentDirections.actionMessagesFragmentToLoginFragment()
            findNavController().navigate(action)
        }else {

            viewModel.listener = this
            viewModel.getMessage()

            binding.logout.setOnClickListener {
                val action = MessagesFragmentDirections.actionMessagesFragmentToLoginFragment()
                findNavController().navigate(action)
                pref.clearPreference()
            }
        }
    }

    override fun onCallStart() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onReceived(response: LiveData<ModelMessage>) {
        response.observe(this, Observer {
            if(it.member != null) {
                binding.progressBar.visibility = View.GONE
                val adapter by lazy { MessageAdapter(requireContext()) }
                binding.messageRV.adapter = adapter
                adapter.addItems(it.member!!)
            }
        })
    }

    override fun onFailed(message: String) {
        binding.progressBar.visibility = View.GONE
        error_toast(message)
    }

}
