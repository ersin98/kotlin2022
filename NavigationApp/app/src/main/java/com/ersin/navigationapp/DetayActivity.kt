package com.ersin.navigationapp

import android.content.Intent
import android.net.MailTo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ersin.navigationapp.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val ad = intent?.extras?.getString(AD).toString()
            val soyad = intent?.extras?.getString(SOYAD).toString()
            val email= intent?.extras?.getString(EMAIL).toString()
        //inentler için de let ile birleştirilebilir
        binding.apply {
            name.text=ad
            lastName.text=soyad
            mail.text=email
        }
        binding.gonder.setOnClickListener{
                mesajGonder(email)
        }
    }
    fun mesajGonder(mail: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"//gönderim tipini bilmiyoruz sen seçtir dedik
            putExtra(Intent.EXTRA_EMAIL, mail)
        }
        startActivity(intent)
    }
    companion object{//javadaki string mantığında. Doğrudan bunları başka aktivitelerde
    //kullanabiliriz
        const val AD = "ad"
        const val SOYAD = "soyad"
        const val EMAIL = "email"

        //iki aktivitede kullanılacak keyleri kontrol altına aldık.
    }
}