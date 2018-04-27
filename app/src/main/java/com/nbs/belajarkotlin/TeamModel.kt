package com.nbs.belajarkotlin

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TeamModel(
        @SerializedName("idTeam")
        var teamId: String? = null,

        @SerializedName("strTeam")
        var teamName: String? = null,

        @SerializedName("strTeamBadge")
        var teamBadge: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(teamId)
        parcel.writeString(teamName)
        parcel.writeString(teamBadge)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TeamModel> {
        override fun createFromParcel(parcel: Parcel): TeamModel {
            return TeamModel(parcel)
        }

        override fun newArray(size: Int): Array<TeamModel?> {
            return arrayOfNulls(size)
        }
    }
}