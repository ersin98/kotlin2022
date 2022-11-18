package com.ersin.recyclerviewdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import androidx.recyclerview.widget.LinearLayoutManager
import com.ersin.recyclerviewdemo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {

    private var ItemList =
        arrayListOf(
            Item("What is Lorem Ipsum?","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", UUID.randomUUID().toString()),
            Item("header","Duis vitae erat congue, accumsan tortor et, pellentesque turpis.", UUID.randomUUID().toString()),
            Item("123","Pellentesque sit amet odio venenatis, tempor mi id, viverra nisl.", UUID.randomUUID().toString()),
            Item("deneme","Aliquam in lacus ut lacus commodo viverra non a est.", UUID.randomUUID().toString()),
            Item("Sed vitae.","Fusce a nunc vitae lacus vestibulum commodo.", UUID.randomUUID().toString()),
            Item("Aliquam vitae.","Sed tempus metus at aliquet molestie.", UUID.randomUUID().toString()),
            Item("Fusce metus.","Etiam congue orci quis mi lobortis, a fringilla magna luctus.", UUID.randomUUID().toString()),
            Item("In hac.","Nulla eleifend nisl sollicitudin augue vehicula, eget pellentesque sapien blandit.", UUID.randomUUID().toString()),
            Item("Curabitur lorem.","Pellentesque commodo est non condimentum dignissim.", UUID.randomUUID().toString()),
            Item("Integer quis.","Praesent porta justo sed metus dignissim, nec imperdiet quam facilisis.", UUID.randomUUID().toString()),
            Item("Suspendisse molestie.","Integer facilisis lacus eu eros imperdiet, id volutpat risus varius.", UUID.randomUUID().toString()),
            Item("In eleifend.","Duis eu diam auctor, porta quam at, accumsan quam.", UUID.randomUUID().toString()),
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
        binding.buttonAdd.setOnClickListener {
            val header = binding.editTextText2.text?.toString()
            val text = binding.editTextText.text?.toString()
            val newItem = Item(header, text,UUID.randomUUID().toString())
            addItem(newItem)
            binding.editTextText.text.clear()
            binding.editTextText2.text.clear()
        }
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
        val snack = Snackbar.make(binding.root, "APPLIED", Snackbar.LENGTH_SHORT)//LENGTH_INDEFINITE
        snack.setAction("UNDO") {
            addItem(item)
        }
        snack.show()

    }


    private fun addItem(item:Item){

        ItemList.add(item)
        adapterList.updateList(ItemList)
        binding.recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter=adapterList
        }
    }
}