package com.ersin.fragmentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ersin.fragmentdemo.data.ThirdFragment
import com.ersin.fragmentdemo.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var param1: String
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ThirdFragment.ARG_PARAM1).toString()
            if (param1=="null")
                param1=""

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            firstTextView.text=param1
        }
        binding.firstPrevious.setOnClickListener {
            var  bundle = Bundle()
            if(binding.firstEdittext.text != null){
                val argument= binding.firstEdittext.text.toString()
                bundle.putString(ThirdFragment.ARG_PARAM1, argument)
            }
            binding.firstEdittext.text.clear()
            binding.firstTextView.text=null
            findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment,bundle)
        }
        binding.firstNext.setOnClickListener{
            var  bundle = Bundle()
            if(binding.firstEdittext.text != null){
                val argument= binding.firstEdittext.text.toString()
                bundle.putString(ThirdFragment.ARG_PARAM1, argument)
            }
            binding.firstEdittext.text.clear()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}