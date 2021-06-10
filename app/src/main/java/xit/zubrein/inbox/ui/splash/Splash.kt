package xit.zubrein.inbox.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import xit.zubrein.inbox.Utils.pref.PrefKeys
import xit.zubrein.inbox.R
import xit.zubrein.inbox.base.BaseActivity
import xit.zubrein.inbox.databinding.ActivitySplashBinding
import xit.zubrein.inbox.model.ModelDomain
import xit.zubrein.inbox.ui.auth.signup.SignupActivity
import xit.zubrein.inbox.utils.Navigator

@AndroidEntryPoint
class Splash : BaseActivity<ActivitySplashBinding>() , SplashListener{

    override fun getView() = R.layout.activity_splash

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {

        splashViewModel.listener = this
        splashViewModel.getDomain()

    }

    override fun onCallStart() {

    }

    override fun onReceived(response: LiveData<ModelDomain>) {
        response.observe(this, Observer {
            if(it.member[0].domain.isNotEmpty()){
                pref.putString(PrefKeys.DOMAIN_NAME,it.member[0].domain)
                Navigator.sharedInstance.navigate(this,SignupActivity::class.java)
                finish()
            }
        })
    }

    override fun onFailed(message: String) {

    }
}