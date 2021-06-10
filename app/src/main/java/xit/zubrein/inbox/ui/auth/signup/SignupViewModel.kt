package xit.zubrein.inbox.ui.auth.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelSignup
import xit.zubrein.inbox.ui.auth.signup.listener.SignupListener
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val repository: SignupRepository) : ViewModel() {

    private val TAG = "SignupViewModel"
    var listener : SignupListener? = null

    fun createAccount(userData : ModelAuthCredentials) {

        listener?.onCallStart()

        val response : LiveData<ModelSignup> = repository.createAccount(userData).catch {
                e ->
            Log.d(TAG, "Create account: ${e.message}")
            listener?.onFailed(e.localizedMessage!!.toString())
        }.asLiveData()

        listener?.onReceived(response)

    }

}