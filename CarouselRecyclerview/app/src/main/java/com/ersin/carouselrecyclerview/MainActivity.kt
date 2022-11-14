package com.ersin.carouselrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ersin.carouselrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val movieList = ArrayList<MovieModel>()
        movieList.add(MovieModel(R.drawable.example,"Example"))
        movieList.add(MovieModel(R.drawable.example1,"Example1"))
        movieList.add(MovieModel(R.drawable.example2,"Example2"))
        movieList.add(MovieModel(R.drawable.example3,"Example3"))
        movieList.add(MovieModel(R.drawable.example4,"Example4"))

        val adapter = MovieAdapter(movieList)
        binding.carouselRecyclerview.adapter = adapter
        binding.apply {
            carouselRecyclerview.adapter = adapter
            carouselRecyclerview.set3DItem(true)
            carouselRecyclerview.setAlpha(true)
            carouselRecyclerview.setInfinite(true)
        }


    }
}