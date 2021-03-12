package com.digitalhouse.efood

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
class DishViewHolder(dishView: View) : RecyclerView.ViewHolder(dishView) {
    // Your holder should contain and initialize a member variable
    // for any view that will be set as you render a row
    val imageView by lazy { dishView.findViewById<ImageView>(R.id.dishes_item_image_view) }
    val titleView by lazy { dishView.findViewById<TextView>(R.id.dishes_item_title) }
}