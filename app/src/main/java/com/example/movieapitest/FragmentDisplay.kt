package com.example.movieapitest

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_display.*
import kotlinx.android.synthetic.main.fragment_display.view.*
import kotlin.collections.ArrayList

class FragmentDisplay: Fragment() {

    lateinit var listener: (data: MovieResponse) -> Unit

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = (context as MainActivity)::createDetailedFragment
    }

    companion object{
        val KEY_FRAGMENT_DISPLAY = "KEY_FRAGMENT_DISPLAY"

        fun createFragmentDisplay(dataSet: List<MovieResponse>)
            : FragmentDisplay{
            //todo create fragment
            //todo create Bundle
            //todo assign the bundle to the Fragment
            //todo return the fragment
            val fragmentDisplay = FragmentDisplay()
            val bundle = Bundle()

            val parcelableDatSet = MovieDataSet(dataSet
                    as ArrayList<MovieResponse>)

            bundle.putParcelableArrayList(KEY_FRAGMENT_DISPLAY,
                dataSet as java.util.ArrayList<out Parcelable>)

            fragmentDisplay.arguments = bundle
            return fragmentDisplay
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_display,
            container,
            false)
//        arguments?.let{
//            it.getParcelableArrayList<MovieResponse>(KEY_FRAGMENT_DISPLAY)?.let{
//                inflateRecyclerView(it)
//            }
//        }
        arguments?.getParcelableArrayList<MovieResponse>(KEY_FRAGMENT_DISPLAY)
            ?.let{
                inflateRecyclerView(it, view)
            }
        return view
    }

    private fun inflateRecyclerView(dataSet:
                                    ArrayList<MovieResponse>, view: View){
        val linearLayoutManager =
            LinearLayoutManager(activity)
//        val gridLayoutManager =
//            GridLayoutManager(this, 3)
//        val staggeredLayoutManager =
//            StaggeredGridLayoutManager(4,
//                StaggeredGridLayoutManager.HORIZONTAL)

        view.recyclerview.layoutManager = linearLayoutManager
        view.recyclerview.adapter = MovieAdapter(dataSet,
            listener)
    }

}