package com.example.movieapitest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MovieAdapter(val dataSet: List<MovieResponse>,
                   val listener: (dataItem: MovieResponse) -> Unit)
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    /**
     * render N items has this function returns.
     */

    class MovieViewHolder(val movieView: View)
        : RecyclerView.ViewHolder(movieView){

        fun onBind(dataItem: MovieResponse,
            listener: (dataItem: MovieResponse)->Unit){
            movieView.tv_item_movie_title.text =
                dataItem.title
            movieView.setOnClickListener {
                listener.invoke(dataItem)
            }
            Picasso.get().load(dataItem.image)
                .into(movieView.iv_item_movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                           viewType: Int): MovieViewHolder{
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout,
                    parent,
                    false)
        )
    }

    /**
     * Connect the data with the ViewHolder views.
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int){
        holder.onBind(dataSet[position],
            listener)
    }

    override fun getItemCount() = dataSet.size
}