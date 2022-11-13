package com.ersin.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ersin.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapterList by lazy{ Adapter()}
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        val itemList= Database.getItems()

        adapterList.updateList(itemList)
        binding.recyclerView.apply {
        layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        adapter=adapterList

        }
    }
}