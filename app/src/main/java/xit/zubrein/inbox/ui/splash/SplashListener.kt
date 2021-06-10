package xit.zubrein.inbox.ui.splash

import androidx.lifecycle.LiveData
import xit.zubrein.inbox.model.ModelDomain

interface SplashListener {

    fun onCallStart()

    fun onReceived(response : LiveData<ModelDomain>)

    fun onFailed(message : String)
}