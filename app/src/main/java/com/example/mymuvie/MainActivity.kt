package com.example.mymuvie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymuvie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var movieAdapter:MovieAdapter? = null
    private var movies:ArrayList<MovieModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        movies = ArrayList<MovieModel>()
        movies?.add(
            MovieModel(R.drawable.bad_boys, getString(R.string.badBoys),
            getString(R.string.badBoysLong), getString(R.string.badBoysActors), getString(R.string.badBoysRating)))
        movies?.add(
            MovieModel(R.drawable.avengers, getString(R.string.avengers), getString(R.string.avengersLong),
                getString(R.string.avengersActors), getString(R.string.avengersRating))
        )
        movies?.add(
            MovieModel(R.drawable.transformers, getString(R.string.transformers), getString(R.string.transformersLong),
                getString(R.string.transformersActors), getString(R.string.transformersRating))
        )
        movies?.add(
            MovieModel(R.drawable.fast, getString(R.string.fast), getString(R.string.fastLong),
                getString(R.string.fastActors), getString(R.string.fastRating))
        )
        movies?.add(
            MovieModel(R.drawable.mk, getString(R.string.mk), getString(R.string.mkLong),
                getString(R.string.mkActors), getString(R.string.mkRating))
        )
        movies?.add(
            MovieModel(R.drawable.underworld, getString(R.string.underworld), getString(R.string.underworldLong),
                getString(R.string.underworldActors), getString(R.string.underworldRating))
        )
        movies?.add(
            MovieModel(R.drawable.pirates, getString(R.string.pirates), getString(R.string.piratesLong),
                getString(R.string.piratesActors), getString(R.string.piratesRating))
        )
        movies?.add(
            MovieModel(R.drawable.future, getString(R.string.future), getString(R.string.futureLong),
                getString(R.string.futureActors), getString(R.string.futureRating))
        )

        binding?.catalogMovies?.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter({movieModel: MovieModel->action(movieModel)}, movies!!)
        binding?.catalogMovies?.adapter = movieAdapter
    }

    private fun action(movieModel: MovieModel) {

        val detailsMovie = DetailsMuvie()
        val parameters = Bundle()
        parameters.putString("nameMovie", movieModel.nameMovie)
        parameters.putString("longMovie", movieModel.longMovie)
        parameters.putString("actorsMovie", movieModel.actorsMovie)
        parameters.putString("ratingMovie", movieModel.ratingMovie)

        detailsMovie.arguments = parameters
        detailsMovie.show(supportFragmentManager, "details")

    }
}