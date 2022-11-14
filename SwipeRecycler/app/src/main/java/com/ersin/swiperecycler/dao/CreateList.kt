package com.ersin.swiperecycler.dao

import com.ersin.swiperecycler.model.Car

class CreateList {
    fun createCarlist():ArrayList<Car>{
        val list:ArrayList<Car> = ArrayList()
        val car1=Car("name1","country1")
        val car2=Car("name2","country2")
        val car3=Car("name3","country3")

        list.add(car1)
        list.add(car2)
        list.add(car3)
        return list
    }
}