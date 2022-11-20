package com.ersin.recyclerviewdemo

sealed class DataItem{
    data class Item(val header:String,val text:String):DataItem()
    data class SamePartItem(val text:String):DataItem()
}