package com.digitalhouse.efood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestaurantsActivity : AppCompatActivity() {

    val recyler by lazy { findViewById<RecyclerView>(R.id.restaurants_recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        val restaurantsList = getRestaurants()
        val adapter = RestaurantsAdapter(restaurantsList, this)
        recyler.adapter = adapter
        recyler.layoutManager = LinearLayoutManager(this)
    }

    private fun getRestaurants(): MutableList<Restaurant> {
        val list = mutableListOf<Restaurant>()
        // Tony Roma's
        val tonyRomasRestaurant = Restaurant("Tony Roma's", 1)
        tonyRomasRestaurant.imageID = R.drawable.tony_romas_shrimp
        tonyRomasRestaurant.address = "Av. Lavandisca, 717 - Indianópolis, São Paulo"
        tonyRomasRestaurant.closingHours = "Closes at 10PM"
        list.add(tonyRomasRestaurant)

        // Aoyama - Moema
        val aoyamaMoemaRestaurant = Restaurant("Aoyama - Moema", 2)
        aoyamaMoemaRestaurant.imageID = R.drawable.aoyama_moema_ginger_salad
        aoyamaMoemaRestaurant.address = "Alameda dos Arapanés, 532 - Moema"
        aoyamaMoemaRestaurant.closingHours = "Closes at 12PM"
        list.add(aoyamaMoemaRestaurant)

        // Outback - Moema
        val outbackMoemaRestaurant = Restaurant("Outback - Moema", 3)
        outbackMoemaRestaurant.imageID = R.drawable.outback_moema_food_and_drink
        outbackMoemaRestaurant.address = "Av. Moaci, 187, 187 - Moema, São Paulo"
        outbackMoemaRestaurant.closingHours = "Closes at 10PM"
        list.add(outbackMoemaRestaurant)

        // Sí Señor
        val siSenorRestaurant = Restaurant("Sí Señor", 4)
        siSenorRestaurant.imageID = R.drawable.si_senor_breakfast
        siSenorRestaurant.address = "Alameda Jauaperi, 626 - Moema"
        siSenorRestaurant.closingHours = "Closes at 1AM"
        list.add(siSenorRestaurant)

        return list
    }
}