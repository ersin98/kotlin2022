package com.ersin.recyclerviewdemo

object Database {
    const val TYPE_SamePartItem=0
    const val TYPE_ITEM=1

    fun getItems(): ArrayList<Any> {
        var itemList = arrayListOf<Any>()
        itemList.add( DataItem.Item("What is Lorem Ipsum?",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        itemList.add(DataItem.Item("header","Duis vitae erat congue, accumsan tortor et, pellentesque turpis."))
        itemList.add(DataItem.Item("123","Pellentesque sit amet odio venenatis, tempor mi id, viverra nisl."))
        itemList.add(DataItem.Item("deneme","Aliquam in lacus ut lacus commodo viverra non a est."))
        itemList.add(DataItem.SamePartItem("Nam convallis elit id urna pellentesque, vehicula dapibus augue volutpat."))
        itemList.add(DataItem.Item("Sed vitae.","Fusce a nunc vitae lacus vestibulum commodo."))
        itemList.add(DataItem.Item("Aliquam vitae.","Sed tempus metus at aliquet molestie."))
        itemList.add(DataItem.Item("Fusce metus.","Etiam congue orci quis mi lobortis, a fringilla magna luctus."))
        itemList.add(DataItem.Item("In hac.","Nulla eleifend nisl sollicitudin augue vehicula, eget pellentesque sapien blandit."))
        itemList.add(DataItem.Item("Curabitur lorem.","Pellentesque commodo est non condimentum dignissim."))
        itemList.add(DataItem.Item("Integer quis.","Praesent porta justo sed metus dignissim, nec imperdiet quam facilisis."))
        itemList.add(DataItem.Item("Suspendisse molestie.","Integer facilisis lacus eu eros imperdiet, id volutpat risus varius."))
        itemList.add(DataItem.Item("In eleifend.","Duis eu diam auctor, porta quam at, accumsan quam."))
        itemList.add(DataItem.SamePartItem("Nunc iaculis mauris id consectetur ullamcorper."))
        itemList.add(DataItem.SamePartItem("In dictum quam non nisi cursus, et tempor nunc dapibus"))

        return itemList
    }
}