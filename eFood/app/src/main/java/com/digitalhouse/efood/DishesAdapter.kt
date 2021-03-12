package com.digitalhouse.efood

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// Create the basic adapter extending from RecyclerView.Adapter
// Pass in the activity to have access to its functions
class DishesAdapter(private val dishesList: MutableList<Dish>, private val activity: DishesActivity) : RecyclerView.Adapter<DishViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        // Get the ViewHolder to be inflated
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val dishView = inflater.inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(dishView)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        // Get the data model based on position
        val dish: Dish = dishesList.get(position)
        // Set item views based on views and data model
        holder.imageView.setImageResource(dish.imageID)
        holder.titleView.setText(dish.name)

        holder.itemView.setOnClickListener() {
            val intent = Intent(activity, DishDetailActivity::class.java).apply {
                putExtra("name",dish.name)
                putExtra("description", dish.description)
            }
            activity.startActivity(intent)
        }
    }

    override fun getItemCount() = dishesList.size
}