package com.ersin.swiperecycler.swipe

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.ersin.swiperecycler.R
//import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator


abstract class SwipeGesture (context: Context):ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
    private  val deleteColor=ContextCompat.getColor(context, R.color.deleteColor)
    private val addColor= ContextCompat.getColor(context,R.color.addColor)
    private  val addIcon= R.drawable.ic_add
    private  val deleteIcon= R.drawable.ic_delete

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        //RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
         //   .addSwipeLeftActionIcon(deleteIcon)
         //   .addSwipeLeftBackgroundColor (deleteColor)
         //   .addSwipeRightActionIcon (addIcon)
         //   .addSwipeRightBackgroundColor(addColor)
         //   .create()
         //   .decorate()

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}