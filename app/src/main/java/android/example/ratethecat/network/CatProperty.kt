package android.example.ratethecat.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatProperty(
    val id: String,
    val url: String,
    var include_vote: String?
    ) : Parcelable
