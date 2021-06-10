package xit.zubrein.inbox.ui.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelSignin
import xit.zubrein.inbox.model.ModelSignup
import xit.zubrein.inbox.ui.auth.login.listener.SigninListener
import xit.zubrein.inbox.ui.auth.signup.SignupRepository
import xit.zubrein.inbox.ui.auth.signup.listener.SignupListener
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    private val TAG = "SigninViewModel"
    var listener : SigninListener? = null

    fun login(userData : ModelAuthCredentials) {

        listener?.onCallStart()

        val response : LiveData<ModelSignin> = repository.login(userData).catch {
                e ->
            Log.d(TAG, "login: ${e.message}")
            listener?.onFailed(e.message!!.toString())
        }.asLiveData()

        listener?.onReceived(response)

    }

}