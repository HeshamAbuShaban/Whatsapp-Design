package dev.training.whatsapp_design.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import dev.training.whatsapp_design.R
import dev.training.whatsapp_design.data.local.dummy.Call
import dev.training.whatsapp_design.databinding.ItemCallBinding
import javax.inject.Inject

class CallAdapter @Inject constructor(
    val glide: RequestManager,
) : RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    inner class CallViewHolder(private val binding: ItemCallBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(call: Call) {
            with(binding) {
                //..leave img for now
                glide.load(call.img).into(ivUPic)

                tvUName.text = call.name
                tvDate.text = call.date


                val conditionIcon =
                    if (call.condition == 1) R.drawable.ic_incoming else R.drawable.ic_outgoing
//                glide.load(conditionIcon).into(ivCallCondition)
                ivCallCondition.setImageResource(conditionIcon)

                if (call.type == 0) ivCallAction.setImageResource(R.drawable.ic_videocam)
//                    glide.load(R.drawable.ic_video-cam).into(ivCallAction)

            }
        }
    }

    private inner class DifferImpl : DiffUtil.ItemCallback<Call>() {
        override fun areItemsTheSame(oldItem: Call, newItem: Call): Boolean =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: Call, newItem: Call): Boolean =
            oldItem.date == newItem.date
    }

    private val differ: AsyncListDiffer<Call> = AsyncListDiffer(this, DifferImpl())

    var calls: List<Call>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder =
        CallViewHolder(
            ItemCallBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = calls.size

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val call = calls[position]
        holder.bind(call)
    }

}