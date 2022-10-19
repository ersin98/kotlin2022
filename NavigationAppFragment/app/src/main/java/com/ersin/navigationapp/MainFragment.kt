package com.ersin.navigationapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ersin.navigationapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return inflater.inflate(R.layout.fragment_main, container, false)
        //bunu binding için olana çeviriyoruz
        binding= FragmentMainBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ButtonOnay.setOnClickListener{
            val ad = binding.editTextTextPersonName.text.toString()
            val soyad= binding.editTextTextPersonName2.text.toString()
            val  email = binding.editTextTextEmailAddress.text.toString()

            val action = MainFragmentDirections.actionMainFragmentToDetayFragment(ad,soyad,email)
            this.findNavController().navigate(action)
            //intentler ile değil navigation kütüphanesi ile çalıştık
            /*
            val  intent = Intent(this , DetayActivity::class.java)
            intent.putExtra(DetayActivity.AD,ad)
            intent.putExtra(DetayActivity.SOYAD,soyad)
            intent.putExtra(DetayActivity.EMAIL,email)
            startActivity(intent)*/
        }
    }
}