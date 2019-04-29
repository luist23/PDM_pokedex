package com.luist23.pokedex.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.luist23.pokedex.R
import com.luist23.pokedex.pojos.Pokemon
import kotlinx.android.synthetic.main.viewer_pokemon.*

class pokemonViewerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewer_pokemon)

        setSupportActionBar(toolbarviewer)
        collapsingtoolbarviewer.setExpandedTitleTextAppearance(R.style.ExpandedAppBar)
        collapsingtoolbarviewer.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar)

        val reciever: Pokemon = intent?.extras?.getParcelable("POKEMON") ?: Pokemon()
        init(reciever)
    }

    fun init(pokemon: Pokemon){
        Glide.with(this)
                .load(pokemon.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(app_bar_image_viewer)
        collapsingtoolbarviewer.title = pokemon.Title
        app_bar_rating_viewer.text = pokemon.imdbRating
        plot_viewer.text = pokemon.Plot
        director_viewer.text = pokemon.Director
        actors_viewer.text = pokemon.Actors
        genre_viewer.text = pokemon.Genre
        released_viewer.text = pokemon.Released
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {onBackPressed();true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}