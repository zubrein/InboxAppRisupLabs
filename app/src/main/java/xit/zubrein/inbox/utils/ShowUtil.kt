package xit.zubrein.inbox.utils

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.toast_error.view.*
import kotlinx.android.synthetic.main.toast_info.view.*
import kotlinx.android.synthetic.main.toast_success.view.*
import xit.zubrein.inbox.R

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun Fragment.toast(message: String) {
    requireContext().toast(message)
}

fun Context.success_toast(message : String){
    val myToast = Toast(applicationContext)
    myToast.duration = Toast.LENGTH_SHORT
    myToast.setGravity(Gravity.BOTTOM, 0, 250)
    val v: View = View.inflate(this,R.layout.toast_success,null)
    v.success_message.text = message
    myToast.view = v
    myToast.show()
}
fun Fragment.success_toast(message : String){
    val myToast = Toast(requireContext())
    myToast.duration = Toast.LENGTH_SHORT
    myToast.setGravity(Gravity.BOTTOM, 0, 250)
    val v: View = View.inflate(requireContext(),R.layout.toast_success,null)
    v.success_message.text = message
    myToast.view = v
    myToast.show()
}

fun Context.error_toast(message : String){
    val myToast = Toast(applicationContext)
    myToast.duration = Toast.LENGTH_SHORT
    myToast.setGravity(Gravity.BOTTOM, 0, 250)
    val v: View = View.inflate(this,R.layout.toast_error,null)
    v.error_message.text = message
    myToast.view = v
    myToast.show()
}
fun Fragment.error_toast(message : String){
    val myToast = Toast(requireContext())
    myToast.duration = Toast.LENGTH_SHORT
    myToast.setGravity(Gravity.BOTTOM, 0, 250)
    val v: View = View.inflate(requireContext(),R.layout.toast_error,null)
    v.error_message.text = message
    myToast.view = v
    myToast.show()
}

fun Context.info_toast(message : String){
    val myToast = Toast(applicationContext)
    myToast.duration = Toast.LENGTH_SHORT
    myToast.setGravity(Gravity.BOTTOM, 0, 250)
    val v: View = View.inflate(this,R.layout.toast_info,null)
    v.info_message.text = message
    myToast.view = v
    myToast.show()
}
fun Fragment.info_toast(message : String){
    val myToast = Toast(requireContext())
    myToast.duration = Toast.LENGTH_SHORT
    myToast.setGravity(Gravity.BOTTOM, 0, 250)
    val v: View = View.inflate(requireContext(),R.layout.toast_info,null)
    v.info_message.text = message
    myToast.view = v
    myToast.show()
}

@BindingAdapter("loadImage")
fun loadImage(view:ImageView,url:String){
    Glide.with(view.context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher) // change this
        .into(view)

}