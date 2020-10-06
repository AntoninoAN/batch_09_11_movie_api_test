package com.example.movieapitest

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class MovieResponse(
    val title: String,
    val image: String,
    val rating: Double,
    val releaseYear: Int,
    val genre: List<String>
) : Parcelable

@Parcelize
data class MovieDataSet(
    val dataSet: ArrayList<MovieResponse>
): Parcelable


//data class MovieResponse2(
//    val title: String?,
//    val image: String?,
//    val rating: Double?,
//    val releaseYear: Int?,
//    val genre: List<String>?
//): Parcelable{


class MovieResponse2(
    private val title: String?) {

    constructor(flag: Boolean) : this(null) {}
}

//val movie = MovieResponse2("","",0)
//
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readValue(Double::class.java.classLoader) as? Double,
//        parcel.readValue(Int::class.java.classLoader) as? Int,
//        parcel.createStringArrayList()) {
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    override fun writeToParcel(p0: Parcel?, p1: Int) {
//        p0?.let {
//            it.writeString(image)
//            it.writeDouble(rating!!)
//        }
//    }
//
//    companion object CREATOR : Parcelable.Creator<MovieResponse2> {
//        override fun createFromParcel(parcel: Parcel): MovieResponse2 {
//            return MovieResponse2(parcel)
//        }
//
//        override fun newArray(size: Int): Array<MovieResponse2?> {
//            return arrayOfNulls(size)
//        }
//    }
//}