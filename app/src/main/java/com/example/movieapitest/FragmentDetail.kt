package com.example.movieapitest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.view.*

class FragmentDetail: Fragment() {
    companion object{
        val KEY_FRAGMENT_DETAIL = "KEY_FRAGMENT_DETAIL"
        fun createFragmentDetail(dataItem: MovieResponse)
            : FragmentDetail{
            val fragment = FragmentDetail()
            val bundle = Bundle()
            bundle.putParcelable(KEY_FRAGMENT_DETAIL,
                dataItem)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_detail,
            container,
            false)

        arguments?.getParcelable<MovieResponse>(KEY_FRAGMENT_DETAIL)
            ?.let {
                bindData(view, it)
            }
        return view
    }

    private fun bindData(view: View,
                         dataItem: MovieResponse){
        view.tv_movie_title_detail.text = dataItem.title
        view.tv_movie_rating_detail.text = dataItem.rating.toString()
        view.tv_movie_release_detail.text = dataItem.releaseYear.toString()
        view.tv_movie_genre_detail.text = dataItem.genre.toString()
        Picasso.get().load(dataItem.image).into(view.iv_movie_poster_detail)
    }
}