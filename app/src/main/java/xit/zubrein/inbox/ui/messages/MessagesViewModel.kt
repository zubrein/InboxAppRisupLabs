package xit.zubrein.inbox.ui.messages

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import xit.zubrein.inbox.model.ModelAuthCredentials
import xit.zubrein.inbox.model.ModelMessage
import xit.zubrein.inbox.model.ModelSignin
import xit.zubrein.inbox.ui.auth.login.LoginRepository
import xit.zubrein.inbox.ui.auth.login.listener.SigninListener
import xit.zubrein.inbox.ui.messages.listener.MessageListener
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(private val repository: MessagesRepository) : ViewModel() {

    private val TAG = "MessageViewModel"
    var listener : MessageListener? = null

    fun getMessage() {

        listener?.onCallStart()

        val response : LiveData<ModelMessage> = repository.getMessage().catch {
                e ->
            Log.d(TAG, "login: ${e.message}")
            listener?.onFailed(e.message!!.toString())
        }.asLiveData()

        listener?.onReceived(response)

    }

}