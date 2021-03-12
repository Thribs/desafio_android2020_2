package com.digitalhouse.efood

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

// Create the basic adapter extending from RecyclerView.Adapter
// Pass in the activity to have access to its functions
class RestaurantsAdapter(private val restaurantsList: MutableList<Restaurant>, val activity: AppCompatActivity) :
        RecyclerView.Adapter<RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        // Get the ViewHolder to be inflated
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val restaurantView = inflater.inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(restaurantView)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        // Get the data model based on position
        val restaurant: Restaurant = restaurantsList.get(position)

        // Set item views based on views and data model
        holder.titleView.setText(restaurant.title)
        holder.imageView.setImageResource(restaurant.imageID)
        holder.addressView.setText(restaurant.address)
        holder.closingHoursView.setText(restaurant.closingHours)

        holder.itemView.setOnClickListener() {
            val intent = Intent(activity, DishesActivity::class.java).apply {
                putExtra("title",restaurant.title)
                putExtra("id",restaurant.id)
                putExtra("image ID",restaurant.imageID)
                putExtra("address",restaurant.address)
                putExtra("closing hours",restaurant.closingHours)
            }
            activity.startActivity(intent)
        }
    }
    override fun getItemCount() = restaurantsList.size
}
