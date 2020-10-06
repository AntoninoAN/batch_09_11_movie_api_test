package com.example.movieapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNetworkCall()
    }

    fun createDetailedFragment(data: MovieResponse){
        //todo create detail fragment (layout/subclass)
        Log.d(TAG, "createDetailedFragment: ")
        //todo supportfragmentmanager
        //todo invoke the factory method
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                FragmentDetail.createFragmentDetail(data))
            .commit()
    }

    private fun initNetworkCall(){
//        Thread() {
        MovieAPI.initRetrofit()
            .getMeMovies()
            .enqueue(object : Callback<List<MovieResponse>>{
                override fun onFailure(call: Call<List<MovieResponse>>,
                                       t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                    Toast.makeText(this@MainActivity,
                        "Error Message",
                        Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(
                    call: Call<List<MovieResponse>>,
                    response: Response<List<MovieResponse>>
                ) {
                    if(response.isSuccessful){
                        //todo inflate fragment
                        //todo pass data
                        val dataSet = response.body()
                        dataSet?.let {
                            val fragment = FragmentDisplay
                                .createFragmentDisplay(dataSet)
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.fragment_container,
                                fragment)
                                .commit()
                        }
                    }
                }
            })
        //}
    }
}

/*
RV
1.- Item Layout
2.- Recyclerview Adapter/ViewHolder
3.- Layout Manager
*/

/*
Steps for Retrofit
1.- Create the Interface
2.- Create Retrofit
3.- Implement the Callback.
 */