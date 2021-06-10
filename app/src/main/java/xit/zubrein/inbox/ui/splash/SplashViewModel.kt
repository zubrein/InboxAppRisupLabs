package xit.zubrein.inbox.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject
constructor(private val repository: SplashRepository) : ViewModel() {

    private val TAG = "SplashRepostory"
    var listener : SplashListener? = null

    fun getDomain() {

        listener?.onCallStart()

        val response = repository.getDomain().
        catch {
            e ->
            listener?.onFailed(e.localizedMessage!!)
        }.asLiveData()

        listener?.onReceived(response)

    }

}