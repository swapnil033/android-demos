package com.example.myandroiddemos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myandroiddemos.databinding.FragmentEnterNameBinding

class EnterNameFragment : Fragment() {

    private lateinit var binding : FragmentEnterNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enter_name, container, false)

        binding.button4.setOnClickListener {
            val bundle = bundleOf("name" to binding.editTextTextPersonName2.text.toString())
            it.findNavController().navigate(R.id.action_enterNameFragment_to_enterEmailFragment, bundle)
        }

        return binding.root
    }
}