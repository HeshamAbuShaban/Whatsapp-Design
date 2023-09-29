package dev.training.whatsapp_design.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.training.whatsapp_design.databinding.FragmentGroupBinding

class GroupFragment : Fragment() {
    private lateinit var binding: FragmentGroupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
//        binding = FragmentGroupBinding.inflate(inflater, container, false)
        binding = FragmentGroupBinding.inflate(layoutInflater)
        return binding.root
    }

}