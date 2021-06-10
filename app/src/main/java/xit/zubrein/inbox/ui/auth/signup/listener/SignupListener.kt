package xit.zubrein.inbox.ui.auth.signup.listener

import androidx.lifecycle.LiveData
import xit.zubrein.inbox.model.ModelDomain
import xit.zubrein.inbox.model.ModelSignup

interface SignupListener {

    fun onCallStart()

    fun onReceived(response : LiveData<ModelSignup>)

    fun onFailed(message : String)
}