package com.ersin.navigationapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ersin.navigationapp.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var ad:String
    private lateinit var soyad:String
    private lateinit var email:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            ad=it.getString(AD).toString()
            soyad=it.getString(SOYAD).toString()
            email=it.getString(EMAIL).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {//container parametresini sebebi fragment lerin tek başlarına olamamaları
        //
        binding = FragmentDetayBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            name.text=ad
            lastName.text=soyad
            mail.text=email
        }
        binding.gonder.setOnClickListener{
            mesajGonder(email)
        }
    }
    fun mesajGonder(mail: String) {//uygulama dışı bir şey olduğundan navigation içine almadık
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, mail)
        }
        startActivity(intent)
    }
    companion object{
    const val AD = "ad"
        const val SOYAD = "soyad"
        const val EMAIL = "email"
    }
}