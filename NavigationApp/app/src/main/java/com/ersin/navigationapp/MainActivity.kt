package com.ersin.navigationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.ersin.navigationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding//adım bir
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)//adım iki
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)//adım üç
        binding.ButtonOnay.setOnClickListener{
            val ad = binding.editTextTextPersonName.text.toString()
            //val kullanılmasının sebebi kullanıcıdan alınan verinin sonradan değiştirilmeyecek olması
            val soyad= binding.editTextTextPersonName2.text.toString()
            val  email = binding.editTextTextEmailAddress.text.toString()

            //intent = gerçekleştirilebilecek bir aksiyon demektir. en çok activity başlatmak için kullanılır

            //explicit detaylı şekile sen yazarsın. Spesifiktir
            //Implicit soyuttur. İşlemi söylersin nasıl yapılacağını android kendi belirler

            val  intent = Intent(this , DetayActivity::class.java)//nerde olduğumuuz ve neyeye gideceğimizi yazdık

            intent.putExtra(DetayActivity.AD,ad)//onu temsil eden cümle (key) ve kendisi
            intent.putExtra(DetayActivity.SOYAD,soyad)
            intent.putExtra(DetayActivity.EMAIL,email)//düz String de yazabilirdik ama bu şekile
            //daha okunaklı oluyor
            startActivity(intent)
        }
    }


}