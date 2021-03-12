package com.digitalhouse.efood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DishesActivity : AppCompatActivity() {

    val recycler by lazy { findViewById<RecyclerView>(R.id.dishes_recycler_view) }
    val restaurantImageView by lazy { findViewById<ImageView>(R.id.dishes_image_view) }
    val titleView by lazy { findViewById<TextView>(R.id.dishes_restaurant_title) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishes)
        val extras = intent.extras
        val restaurant = getRestaurant(extras)

        restaurantImageView.setImageResource(restaurant.imageID)
        titleView.setText(restaurant.title)

        val dishesList = getDishes()

        val adapter = DishesAdapter(dishesList, this)
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
    }

    private fun getDishes(): MutableList<Dish> {
        val list = mutableListOf<Dish>()
        val gingerSauceSalad = Dish("Ginger sauce salad", 1)
        list.add(gingerSauceSalad)
        val gingerSauceSalad2 = Dish("Ginger sauce salad", 2)
        list.add(gingerSauceSalad2)
        val gingerSauceSalad3 = Dish("Ginger sauce salad", 3)
        list.add(gingerSauceSalad3)
        val gingerSauceSalad4 = Dish("Ginger sauce salad", 4)
        list.add(gingerSauceSalad4)
        val gingerSauceSalad5 = Dish("Ginger sauce salad", 5)
        list.add(gingerSauceSalad5)
        val gingerSauceSalad6 = Dish("Ginger sauce salad", 6)
        list.add(gingerSauceSalad6)
        val gingerSauceSalad7 = Dish("Ginger sauce salad", 7)
        list.add(gingerSauceSalad7)

        return list
    }

    private fun getRestaurant(extras: Bundle?) : Restaurant {
        val restaurantTitle = extras?.getString("title") ?: "Restaurant"
        val restaurantID = extras?.getInt("id") ?: 0
        val restaurantimageID = extras?.getInt("image ID") ?: 0
        val restaurantAddress = extras?.getString("address") ?: "Address"
        val restaurantClosingHours = extras?.getString("closing hours") ?: "Closing hours"

        val restaurant = Restaurant(restaurantTitle, restaurantID)
        restaurant.imageID = restaurantimageID
        restaurant.address = restaurantAddress
        restaurant.closingHours = restaurantClosingHours

        return restaurant
    }
}