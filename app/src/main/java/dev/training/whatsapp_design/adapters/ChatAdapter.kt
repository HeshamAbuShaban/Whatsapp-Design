package dev.training.whatsapp_design.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import dev.training.whatsapp_design.data.local.dummy.User
import dev.training.whatsapp_design.databinding.ItemChatBinding
import javax.inject.Inject

class ChatAdapter @Inject constructor(
    val glide: RequestManager,
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: User) {
            with(binding) {
                //..leave img for now
                glide.load(chat.img).into(ivUPic)
                tvUName.text = chat.name
                tvDate.text = chat.recentMessageDate
                tvRecentMessage.text = chat.recentMessage
            }
        }
    }

    private inner class DifferImpl : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.id == newItem.id
    }

    private val differ: AsyncListDiffer<User> = AsyncListDiffer(this, DifferImpl())

    var chats: List<User>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder =
        ChatViewHolder(
            ItemChatBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = chats.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chats[position]
        holder.bind(chat)
    }

}