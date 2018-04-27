package com.nbs.belajarkotlin

import android.os.Parcel
import android.os.Parcelable

data class FootballTeam(val name: String?, val image: Int?): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FootballTeam> {
        override fun createFromParcel(parcel: Parcel): FootballTeam {
            return FootballTeam(parcel)
        }

        override fun newArray(size: Int): Array<FootballTeam?> {
            return arrayOfNulls(size)
        }
    }
}