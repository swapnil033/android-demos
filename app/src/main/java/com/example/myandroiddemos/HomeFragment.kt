package com.example.myandroiddemos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myandroiddemos.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.button2.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_enterNameFragment)
        }

        binding.button3.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_termsFragment)

        }

        return binding.root
    }

}