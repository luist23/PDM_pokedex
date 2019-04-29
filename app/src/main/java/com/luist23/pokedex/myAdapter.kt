package com.luist23.pokedex

import com.luist23.pokedex.pojos.Pokemon
import java.util.*

object AppConstants{
    val dataset_saveinstance_key = "CLE"
    val MAIN_LIST_KEY = "key_list_pokemos"
}

interface MyPokemonAdapter {
    fun changeDataSet(newDataSet : List<Pokemon>)
}