package com.ersin.swiperecycler.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.ersin.swiperecycler.R
import com.ersin.swiperecycler.adapter.RecyclerAdapter
import com.ersin.swiperecycler.databinding.FragmentFeedBinding
import com.ersin.swiperecycler.viewmodel.FeedFragmentViewModel

class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel: FeedFragmentViewModel
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this)[FeedFragmentViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_feed,container,false)
        viewModel.list.observe(viewLifecycleOwner,{
            viewModel.createSwipeGesture(requireContext(),binding.recyclerView)
            adapter= RecyclerAdapter(it)
            binding.adapter=adapter
        })
        return binding.root
    }
}