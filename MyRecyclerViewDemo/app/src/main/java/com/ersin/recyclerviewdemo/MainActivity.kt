package com.ersin.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ersin.recyclerviewdemo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private var ItemList =
        arrayListOf(
            Item("başlık","içerik1", UUID.randomUUID().toString()),
            Item("başlık1","içerik2", UUID.randomUUID().toString()),
            Item("başlık2","içerik3", UUID.randomUUID().toString()),
            Item("başlık3","içerik4", UUID.randomUUID().toString()),
            Item("başlık4","içerik5", UUID.randomUUID().toString()),
            Item("başlık5","içerik6", UUID.randomUUID().toString()),
            Item("başlık6","içerik8", UUID.randomUUID().toString()),
            Item("başlık7","içerik9", UUID.randomUUID().toString()),
            Item("başlık8","içerik10", UUID.randomUUID().toString()),
            Item("başlık9","içerik11", UUID.randomUUID().toString()),
            Item("başlık10","içerik12", UUID.randomUUID().toString()),
            Item("başlık10","içerik13", UUID.randomUUID().toString()),
        )

    private lateinit var binding: ActivityMainBinding
    private val adapterList by lazy{ Adapter(onButtonDeleteClick ={onDeleteItem(it)})}

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        val itemList= ItemList
        adapterList.updateList(itemList)
        binding.buttonAdd.setOnClickListener { addItem() }
        binding.recyclerView.apply {
        layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        adapter=adapterList
        }




    }
    private fun onDeleteItem(item: Item){
        ItemList.remove(item)
        adapterList.updateList(ItemList)
        binding.recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter=adapterList
        }
    }


    private fun addItem(){
        val header = binding.editTextText.text?.toString()
        val text = binding.editTextText.text?.toString()
        val newItem = Item(header, text,UUID.randomUUID().toString())
        ItemList.add(newItem)
        adapterList.updateList(ItemList)
        binding.recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter=adapterList
        }
    }
}