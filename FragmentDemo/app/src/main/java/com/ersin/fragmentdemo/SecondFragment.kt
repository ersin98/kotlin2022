package com.ersin.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ersin.fragmentdemo.data.ThirdFragment
import com.ersin.fragmentdemo.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var param1: String
    private var _binding: FragmentSecondBinding? = null
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

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            secondTextView.text=param1
        }
        binding.secondPrevious.setOnClickListener {
            var  bundle = Bundle()
            if(binding.secondEdittext.text != null){
                val argument= binding.secondEdittext.text.toString()
                bundle.putString(ThirdFragment.ARG_PARAM1, argument)
            }
            binding.secondEdittext.text.clear()
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment,bundle)
        }
        binding.secondNext.setOnClickListener{
            var  bundle = Bundle()
            if(binding.secondEdittext.text != null){
                val argument= binding.secondEdittext.text.toString()
                bundle.putString(ThirdFragment.ARG_PARAM1, argument)
            }
            binding.secondEdittext.text.clear()
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment,bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}