package com.digitalhouse.efood

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
class RestaurantViewHolder(private val restaurantView: View) : RecyclerView.ViewHolder(restaurantView) {
    // Your holder should contain and initialize a member variable
    // for any view that will be set as you render a row
    val titleView by lazy { restaurantView.findViewById<TextView>(R.id.restaurants_item_title) }
    val imageView by lazy { restaurantView.findViewById<ImageView>(R.id.restaurants_item_image_view) }
    val addressView by lazy { restaurantView.findViewById<TextView>(R.id.restaurants_item_address) }
    val closingHoursView by lazy { restaurantView.findViewById<TextView>(R.id.restaurants_item_closing_hours)}

}