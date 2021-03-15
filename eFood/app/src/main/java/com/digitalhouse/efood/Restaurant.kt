package com.digitalhouse.efood

data class Restaurant(val title: String, val id: Int) {
    var dishesList = mutableListOf<Dish>()
    var mainDishesList = mutableListOf<Dish>()
    var imageID: Int = 0
    var address: String = ""
    var closingHours: String = ""
}

val tonyRomasRestaurant = Restaurant("Tony Roma's", 1)