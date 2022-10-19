package com.ersin.navigationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ersin.navigationapp.databinding.ActivityMainBinding



//Navigation Component Java kütüphanesiyle gelir
// 3 parçaan oluşur.
//Navigation Graph, NavHost ve NavController
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //navHost un görevi Navigation Graph ile navController arasındaki bağlantıyı kurmak
        navController=navHostFragment.navController
    }
}