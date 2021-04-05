package com.example.animatedshet.mainscreen

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable

data class MainModel(
     var _name: String,
     var _wishes: String,
     var _info: String,
     var backgroundImagePath: String,
     var downToUpImagePath: String
) : BaseObservable(), Parcelable {

    private val listOfBackgroundPaths =
        listOf("background_1.jpg", "background_2.jpg", "background_3.jpg")
    private var currentBackground = 0
    private val listOfImages = listOf("fotka_1.png", "fotka_2.png", "fotka_3.jpg")
    private var currentDownToUpImage = 0

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
        currentBackground = parcel.readInt()
        currentDownToUpImage = parcel.readInt()
    }

    fun getNextBackground(): String {
        currentBackground++
        if (currentBackground > listOfBackgroundPaths.size - 1) {
            currentBackground = 0
        }
        val path = listOfBackgroundPaths[currentBackground]
        backgroundImagePath = path
        return path
    }

    private fun getCurrentBackground() = listOfBackgroundPaths[currentBackground]

    fun getNextImage(): String {
        currentDownToUpImage++
        if (currentDownToUpImage > listOfImages.size - 1) {
            currentDownToUpImage = 0
        }
        val path = listOfImages[currentDownToUpImage]
        downToUpImagePath = path
        return path
    }

    private fun getCurrentImage() = listOfImages[currentDownToUpImage]

    companion object CREATOR : Parcelable.Creator<MainModel> {
        override fun createFromParcel(parcel: Parcel): MainModel {
            return MainModel(parcel)
        }

        override fun newArray(size: Int): Array<MainModel?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.apply {
            writeString(_name)
            writeString(_wishes)
            writeString(_info)
            writeString(backgroundImagePath)
            writeString(downToUpImagePath)
        }
    }
}
