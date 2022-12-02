package com.example.myandroiddemos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myandroiddemos.databinding.FragmentSaveBinding
import com.example.myandroiddemos.presentation.MainActivity
import com.example.myandroiddemos.presentation.adapter.NewsAdapter
import com.example.myandroiddemos.presentation.viewModel.NewsViewModel

class SaveFragment : Fragment() {

    private lateinit var binding : FragmentSaveBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_save, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initAdapter()

        viewModel.getSaveNewsUseCase().observe(viewLifecycleOwner){
            adapter.differ.submitList(it)
        }
    }

    private fun initViewModel() {
        viewModel = (requireActivity() as MainActivity).viewModel
    }

    private fun initAdapter() {
        adapter = (requireActivity() as MainActivity).newsAdapter

        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_article", it)
            }
            findNavController().navigate(R.id.action_saveFragment_to_infoFragment, bundle)
        }

        binding.rvSavedNews.apply {
            adapter = this@SaveFragment.adapter
        }
    }

}