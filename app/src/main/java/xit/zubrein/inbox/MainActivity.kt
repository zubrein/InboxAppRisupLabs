package xit.zubrein.inbox

import android.content.Intent
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import xit.zubrein.inbox.R
import xit.zubrein.inbox.base.BaseActivity
import xit.zubrein.inbox.databinding.ActivitySignupBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivitySignupBinding>()
{

    override fun getView() = R.layout.activity_signup

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {

    }


}