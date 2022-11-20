package com.ersin.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ersin.recyclerviewdemo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {


    val itemList= Database.getItems()
    private lateinit var binding: ActivityMainBinding
    private val adapterList by lazy{ Adapter(onButtonDeleteClick ={
        onDeleteItem(it)
    })}

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)



        adapterList.updateList(itemList)
        binding.buttonAdd.setOnClickListener {
            val header = binding.editTextText2.text.toString()
            val text = binding.editTextText.text.toString()

            val newItem= whatIsIt(header,text)
            if (newItem != DataItem.Item("null","null")){
                addItem(newItem)
                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()
            }

        }
        binding.recyclerView.apply {
        layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        adapter=adapterList
        }


    }

    private fun onDeleteItem(item: DataItem){
        itemList.remove(item)
        adapterList.updateList(itemList)
        binding.recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter=adapterList
        }
        val snack = Snackbar.make(binding.root, "APPLIED", Snackbar.LENGTH_LONG)//LENGTH_INDEFINITE
        snack.setAction("UNDO") {
            addItem(item)
        }
        snack.show()
    }

    private fun whatIsIt(header:String?,text:String?): DataItem {
        binding.editTextText.hint= getString(R.string.header)
        binding.editTextText2.hint=getString(R.string.text)

        var newitem:DataItem
        newitem= DataItem.Item("null","null")

        if (text.isNullOrBlank() && text.isNullOrEmpty() && !header.isNullOrBlank() && !header.isNullOrEmpty() ){
            newitem= DataItem.SamePartItem(header)//text boş header dolu
        }
        else if (!text.isNullOrBlank() && !text.isNullOrEmpty() && header.isNullOrBlank() && header.isNullOrEmpty()){
            newitem= DataItem.SamePartItem(text)// header boş text dolu
        }
        else if (!text.isNullOrBlank() && !text.isNullOrEmpty() && !header.isNullOrBlank() && !header.isNullOrEmpty()){
            newitem = if (header == text){
                DataItem.SamePartItem(text)
            } else{
                DataItem.Item(header,text)
            }
        }
        else{
            val snack = Snackbar.make(binding.root, "empty data cannot be saved", Snackbar.LENGTH_SHORT)//LENGTH_INDEFINITE
            snack.setAction("OKEY") {
                binding.editTextText.hint=getString(R.string.empty_error)
                binding.editTextText2.hint=getString(R.string.empty_error)
            }
            snack.show()
        }
        return newitem
    }
    private fun addItem(item: DataItem){
        itemList.add(item)
        adapterList.updateList(itemList)
        binding.recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter=adapterList
        }
    }
}