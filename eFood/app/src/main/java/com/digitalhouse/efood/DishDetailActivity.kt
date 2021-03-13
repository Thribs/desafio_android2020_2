package com.digitalhouse.efood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DishDetailActivity : AppCompatActivity() {

    val backButton by lazy { findViewById<FloatingActionButton>(R.id.dish_detail_back_button) }
    val imageView by lazy { findViewById<ImageView>(R.id.dish_detail_image_view) }
    val descriptionView by lazy { findViewById<TextView>(R.id.dish_detail_description) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)
        val extras = intent.extras
        val dish = getDish(extras)

        backButton.setOnClickListener() {
            startActivity(Intent(this, DishesActivity::class.java))
            finish()
        }
        imageView.setImageResource(dish.imageID)
        descriptionView.setText(dish.description)
    }

    private fun getDish(extras: Bundle?): Dish {
        val dishName = extras?.getString("name") ?: ""
        val dishID = extras?.getInt("id") ?: 0
        val dishImageID = extras?.getInt("imageID") ?: R.drawable.aoyama_moema_ginger_salad
        val dishDescription = extras?.getString("description") ?: ""

        val dish = Dish(dishName, dishID)
        dish.description = dishDescription
        dish.imageID = dishImageID

        return dish
    }
}