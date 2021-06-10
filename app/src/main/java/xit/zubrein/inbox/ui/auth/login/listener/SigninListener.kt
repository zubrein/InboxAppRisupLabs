package xit.zubrein.inbox.ui.auth.login.listener

import androidx.lifecycle.LiveData
import xit.zubrein.inbox.model.ModelDomain
import xit.zubrein.inbox.model.ModelSignin
import xit.zubrein.inbox.model.ModelSignup

interface SigninListener {

    fun onCallStart()

    fun onReceived(response : LiveData<ModelSignin>)

    fun onFailed(message : String)
}