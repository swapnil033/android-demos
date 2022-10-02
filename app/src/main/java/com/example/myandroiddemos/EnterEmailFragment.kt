package com.example.myandroiddemos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myandroiddemos.databinding.FragmentEnterEmailBinding

class EnterEmailFragment : Fragment() {
    private lateinit var binding : FragmentEnterEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enter_email, container, false)

        val name = requireArguments().getString("name").toString()

        binding.button5.setOnClickListener {
            val bundle = bundleOf(
                "email" to binding.editTextTextEmailAddress.text.toString(),
                "name" to name
            )
            it.findNavController().navigate(R.id.action_enterEmailFragment_to_welcomeFragment, bundle)
        }

        return binding.root
    }
}