package com.example.mymuvie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymuvie.databinding.ActivityMainBinding
import com.example.mymuvie.databinding.MovieItemBinding

class MovieAdapter( private val action:(MovieModel)->Unit, var muvies: ArrayList<MovieModel>): RecyclerView.Adapter<MovieHolder>() {
    private var binding: ActivityMainBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding : MovieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(muvies[position], action)
    }

    override fun getItemCount(): Int {
        return muvies.size
    }
}

class MovieHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(movieModel:MovieModel, action: (MovieModel) -> Unit){

        binding.contentCardMovie.setBackgroundResource(movieModel.banerMovie)
        binding.nameMovie.text = movieModel.nameMovie
        binding.longMovie.text = movieModel.longMovie
        binding.actorsMovie.text = movieModel.actorsMovie
        binding.ratingMovie.text = movieModel.ratingMovie

        binding.play.setOnClickListener(View.OnClickListener {
            action(movieModel)
        })
    }
}