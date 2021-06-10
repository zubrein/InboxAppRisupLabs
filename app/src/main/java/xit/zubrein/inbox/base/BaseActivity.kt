package xit.zubrein.inbox.base

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import xit.zubrein.inbox.ui.splash.SplashViewModel
import xit.zubrein.inbox.utils.LoadingBar
import xit.zubrein.inbox.utils.pref.PreferenceManager
import javax.inject.Inject


abstract class BaseActivity <T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: T

    val splashViewModel : SplashViewModel by viewModels()

    @Inject
    lateinit var loadingBar: LoadingBar

    @Inject
    lateinit var pref: PreferenceManager

    protected val TAG: String  by lazy {
        this.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,getView())
        onViewReady(savedInstanceState, intent)

    }

    abstract fun getView() : Int
    abstract fun onViewReady(savedInstanceState: Bundle?, intent: Intent)


}