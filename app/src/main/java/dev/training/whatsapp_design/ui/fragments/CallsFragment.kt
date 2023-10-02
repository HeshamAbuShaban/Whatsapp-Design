package dev.training.whatsapp_design.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dev.training.whatsapp_design.adapters.CallAdapter
import dev.training.whatsapp_design.data.local.dummy.Factory
import dev.training.whatsapp_design.databinding.FragmentCallBinding
import javax.inject.Inject

@AndroidEntryPoint
class CallsFragment : Fragment() {
    private lateinit var binding: FragmentCallBinding

    @Inject
    lateinit var callAdapter: CallAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCallBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        setupCallsRecycler()
    }

    private fun setupCallsRecycler() {
        with(binding.rvCallUsers) {
            this.adapter = callAdapter.apply {
                calls = Factory.listOfCalls
            }
        }
    }
}