package xit.zubrein.inbox.adapter

import android.content.Context
import android.util.Log
import xit.zubrein.inbox.R
import xit.zubrein.inbox.base.BaseRecyclerviewAdapter
import xit.zubrein.inbox.databinding.ItemMessageBinding
import xit.zubrein.inbox.model.HydraM
import xit.zubrein.inbox.model.ModelMessage

class MessageAdapter(private val context: Context) :
    BaseRecyclerviewAdapter<HydraM, ItemMessageBinding>() {

    override fun getLayout() = R.layout.item_message

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ItemMessageBinding>,
        position: Int
    ) {
        holder.binding.apply {
            val item = items[position]
            subject = item.subject
            Log.d("recyling", "onBindViewHolder:${item.subject} ")
            from = item.from.name
            body = item.intro
            name = item.from.name[0].toString()
        }
    }

}