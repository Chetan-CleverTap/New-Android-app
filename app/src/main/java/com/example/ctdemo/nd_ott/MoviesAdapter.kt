package com.example.ctdemo.nd_ott

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ItemMoviesBinding


class MoviesAdapter(
    val context: OTTHomeActivity,
    private val movies: List<String>
) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding: ItemMoviesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_movies,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(context, position, movies[position])
    }


    class MyViewHolder(var binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: OTTHomeActivity, position: Int, image: String) {

//            val inputstream: InputStream = context.assets.open(
//                "images/"
//                        + image
//            )
//            val drawable =
//                Drawable.createFromStream(inputstream, null)
//            imageView.setImageDrawable(drawable)

            Glide.with(context)
                .load(image)
                .centerCrop()
                .into(binding.imageRec)

//            binding.textRec.text = image
        }
    }
}