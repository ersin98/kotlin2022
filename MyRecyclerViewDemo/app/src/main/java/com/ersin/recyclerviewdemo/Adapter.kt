package com.ersin.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ersin.recyclerviewdemo.Database.TYPE_ITEM
import com.ersin.recyclerviewdemo.Database.TYPE_SamePartItem
import com.ersin.recyclerviewdemo.databinding.ItemDesignBinding
import com.ersin.recyclerviewdemo.databinding.SamePartItemDesignBinding

class Adapter(val onButtonDeleteClick:(DataItem)->Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ItemViewHolder(val itemBinding:ItemDesignBinding, val onButtonDeleteClick: (DataItem.Item) -> Unit):RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: DataItem.Item){
            itemBinding.item= item
            itemBinding.buttonDelete.setOnClickListener {
                onButtonDeleteClick(item)
            }
        }
    }
    class SamePartItemViewHolder( val samePartItemDesignBinding: SamePartItemDesignBinding, val onButtonDeleteClick: (DataItem.SamePartItem) -> Unit):RecyclerView.ViewHolder(samePartItemDesignBinding.root){
        fun bind(item: DataItem.SamePartItem){
            samePartItemDesignBinding.item=item
            samePartItemDesignBinding.buttonDeleteSame.setOnClickListener{
                onButtonDeleteClick(item)
            }
        }
    }
    private val itemList= arrayListOf<Any>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_ITEM -> ItemViewHolder(ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false),onButtonDeleteClick)
            TYPE_SamePartItem -> SamePartItemViewHolder(SamePartItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false),onButtonDeleteClick)
            else -> throw  java.lang.IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){//burası bir elemanlıyken tek başına kurtarır ama daha fazla elemanda getItemViewType lazım
            is ItemViewHolder -> holder.bind(itemList[position] as DataItem.Item)
            is SamePartItemViewHolder -> holder.bind(itemList[position] as DataItem.SamePartItem)
        }
    }

    override fun getItemCount(): Int =itemList.size

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position]){
            is DataItem.Item -> TYPE_ITEM
            is DataItem.SamePartItem -> TYPE_SamePartItem
            else -> throw  java.lang.IllegalArgumentException("Invalid Item")
        }
    }

    fun updateList(updateList: List<Any>){
        itemList.clear()
        itemList.addAll(updateList)
    }
}