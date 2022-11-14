package com.ersin.swiperecycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ersin.swiperecycler.R
import com.ersin.swiperecycler.databinding.RecyclerLayoutBinding
import com.ersin.swiperecycler.model.Car
import kotlinx.coroutines.NonDisposableHandle

class RecyclerAdapter(private val carList:ArrayList<Car>):RecyclerView.Adapter<RecyclerAdapter.CarWiewHolder>() {
    class CarWiewHolder(var binding: RecyclerLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarWiewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding= DataBindingUtil.inflate<RecyclerLayoutBinding>(inflater, R.layout.recycler_layout,parent,false)

        return CarWiewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarWiewHolder, position: Int) {
        var car = carList[position]
        val hb = holder.binding
        hb.car=car
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}