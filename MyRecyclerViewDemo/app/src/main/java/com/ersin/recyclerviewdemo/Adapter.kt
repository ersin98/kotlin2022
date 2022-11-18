package com.ersin.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.ersin.recyclerviewdemo.databinding.ItemDesignBinding
import java.util.*

class Adapter(val onButtonDeleteClick:(Item)->Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(val itemBinding:ItemDesignBinding,val onButtonDeleteClick:(Item)->Unit):RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: Item){
            itemBinding.item=item
            itemBinding.buttonDelete.setOnClickListener {
                onButtonDeleteClick(item)
            }
        }


    }
    private val itemList= arrayListOf<Any>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false),onButtonDeleteClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(itemList[position] as  Item)
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun updateList(updateList: List<Any>){
        itemList.clear()
        itemList.addAll(updateList)
    }

}