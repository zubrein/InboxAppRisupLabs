package xit.zubrein.inbox.ui.messages.listener

import androidx.lifecycle.LiveData
import xit.zubrein.inbox.model.ModelDomain
import xit.zubrein.inbox.model.ModelMessage
import xit.zubrein.inbox.model.ModelSignin
import xit.zubrein.inbox.model.ModelSignup

interface MessageListener {

    fun onCallStart()

    fun onReceived(response : LiveData<ModelMessage>)

    fun onFailed(message : String)
}