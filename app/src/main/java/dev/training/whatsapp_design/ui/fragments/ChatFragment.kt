package dev.training.whatsapp_design.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dev.training.whatsapp_design.adapters.ChatAdapter
import dev.training.whatsapp_design.data.local.dummy.Factory
import dev.training.whatsapp_design.databinding.FragmentChatBinding
import javax.inject.Inject

@AndroidEntryPoint
class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding

    @Inject
    lateinit var chatAdapter: ChatAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        setupChatsRecycler()
    }

    private fun setupChatsRecycler() {
        with(binding.rvChatUsers) {
            this.adapter = chatAdapter.apply {
                chats = Factory.listOfChats
            }
        }
    }
}