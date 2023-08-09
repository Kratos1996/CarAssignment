package com.harleenkaur.carShop

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

data class CarList(val carList : ArrayList<UserDefinedData> = ArrayList())

data class UserDefinedData(
    var make: String ="",
    var model: String="",
    var condition: String ="",
    var engineCylinder: String ="",
    var year: String ="",
    var numberOfDoors: String ="",
    var price: String="",
    var color: String = "",
    var isAvailable: Boolean = false,
    var dateSold: String ="",
    var carImageId: Int = 0
)
data class CompanyDetailsData(
    var companyName: String ="",
    var companyBio: String ="",
    var address: String="",
    var timing: String ="",
    var phone: String ="",
    var icon: String ="",
)


