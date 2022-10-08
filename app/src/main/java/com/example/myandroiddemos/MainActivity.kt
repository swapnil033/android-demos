package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myandroiddemos.adapter.SubscriberAdapter
import com.example.myandroiddemos.databinding.ActivityMainBinding
import com.example.myandroiddemos.db.Subscriber
import com.example.myandroiddemos.db.SubscriberDatabase
import com.example.myandroiddemos.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityRecyclerView"

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: SubscriberViewModel
    private lateinit var adapter: SubscriberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val viewModelFactory = SubscriberViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[SubscriberViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.statusMessage.observe(this){
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SubscriberAdapter { subscriber -> itemClick(subscriber) }.apply {
            binding.recyclerView.adapter = this
        }
        displayList()
    }

    private fun displayList(){
        viewModel.subscribers.observe(this){
            Log.d(TAG, "displayList: ${it.toString()}")
            adapter.setList(it)
        }
    }

    private fun itemClick(subscriber: Subscriber){
        //Toast.makeText(this, "selected subscriber is ${subscriber.name}", Toast.LENGTH_SHORT).show()
        viewModel.initUpdateAndDelete(subscriber)
    }

}