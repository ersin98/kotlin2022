package com.ersin.fragmentdemo.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ersin.fragmentdemo.R
import com.ersin.fragmentdemo.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var param1: String
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1).toString()
            if (param1=="null")
                param1=""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            thirdTextView.text=param1
        }

        binding.thirdPrevious.setOnClickListener {
            var  bundle = Bundle()
            if(binding.thirdEdittext.text != null){
                val argument= binding.thirdEdittext.text.toString()
                bundle.putString(ARG_PARAM1, argument)
            }
            binding.thirdEdittext.text.clear()
            findNavController().navigate(R.id.action_thirdFragment_to_SecondFragment,bundle)
        }
        binding.thirdNext.setOnClickListener{
            var  bundle = Bundle()
            if(binding.thirdEdittext.text != null){
                val argument= binding.thirdEdittext.text.toString()
                bundle.putString(ARG_PARAM1, argument)
            }
            binding.thirdEdittext.text.clear()
            findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment,bundle)
        }
    }
    companion object {
        const val ARG_PARAM1="param1"
    }

    override fun onDestroyView() {//yeni sayfalarda destroy ilemini unutma
        super.onDestroyView()
        _binding = null
    }

}