package com.ersin.swiperecycler.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.ersin.swiperecycler.adapter.RecyclerAdapter
import com.ersin.swiperecycler.dao.CreateList
import com.ersin.swiperecycler.model.Car
import com.ersin.swiperecycler.swipe.SwipeGesture

class FeedFragmentViewModel :ViewModel() {
    val list = MutableLiveData<ArrayList<Car>>()
    private val dao = CreateList()

    init {
        createLiveData()
    }
    private fun createLiveData(): ArrayList<Car> {
        list.value=dao.createCarlist()
        return list.value!!
    }
    fun createSwipeGesture(context: Context,recyclerView: RecyclerView){
        val swipeGesture = object :SwipeGesture(context){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction){
                    ItemTouchHelper.RIGHT->{
                        //Do something
                    }
                    ItemTouchHelper.LEFT->{
                        //Do something
                    }
                }
            }

        }
        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView((recyclerView))

    }
}