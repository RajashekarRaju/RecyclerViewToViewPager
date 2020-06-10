package com.developersbreach.recyclerviewtoviewpager.model

import android.content.Context
import android.os.Parcelable
import com.developersbreach.recyclerviewtoviewpager.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sports(
    val id: Int,
    val icon: Int,
    val title: String,
    val subtitle: String,
    val about: String
) :
    Parcelable {

    companion object {
        fun sportsList(context: Context): List<Sports> {
            return listOf(
                Sports(
                    0,
                    R.drawable.ic_rugby,
                    context.getString(R.string.title_rugby),
                    context.getString(R.string.subtitle_rugby),
                    context.getString(R.string.about_rugby)
                ),
                Sports(
                    1,
                    R.drawable.ic_cricket,
                    context.getString(R.string.title_cricket),
                    context.getString(R.string.subtitle_cricket),
                    context.getString(R.string.about_cricket)
                ),
                Sports(
                    2,
                    R.drawable.ic_hockey,
                    context.getString(R.string.title_hockey),
                    context.getString(R.string.subtitle_hockey),
                    context.getString(R.string.about_hockey)
                ),
                Sports(
                    3,
                    R.drawable.ic_basketball,
                    context.getString(R.string.title_basketball),
                    context.getString(R.string.subtitle_basketball),
                    context.getString(R.string.about_basketball)
                ),
                Sports(
                    4,
                    R.drawable.ic_volleyball,
                    context.getString(R.string.title_volleyball),
                    context.getString(R.string.subtitle_volleyball),
                    context.getString(R.string.about_volleyball)
                ),
                Sports(
                    5,
                    R.drawable.ic_esports,
                    context.getString(R.string.title_esports),
                    context.getString(R.string.subtitle_esports),
                    context.getString(R.string.about_esports)
                ),
                Sports(
                    6,
                    R.drawable.ic_kabaddi,
                    context.getString(R.string.title_kabbadi),
                    context.getString(R.string.subtitle_kabbadi),
                    context.getString(R.string.about_kabbadi)
                ),
                Sports(
                    7,
                    R.drawable.ic_baseball,
                    context.getString(R.string.title_baseball),
                    context.getString(R.string.subtitle_baseball),
                    context.getString(R.string.about_baseball)
                ),
                Sports(
                    8,
                    R.drawable.ic_mma,
                    context.getString(R.string.title_mma),
                    context.getString(R.string.subtitle_mma),
                    context.getString(R.string.about_mma)
                ),
                Sports(
                    9,
                    R.drawable.ic_soccer,
                    context.getString(R.string.title_soccer),
                    context.getString(R.string.subtitle_soccer),
                    context.getString(R.string.about_soccer)
                ),
                Sports(
                    10,
                    R.drawable.ic_handball,
                    context.getString(R.string.title_handball),
                    context.getString(R.string.subtitle_handball),
                    context.getString(R.string.about_handball)
                ),
                Sports(
                    11,
                    R.drawable.ic_tennis,
                    context.getString(R.string.title_tennis),
                    context.getString(R.string.subtitle_tennis),
                    context.getString(R.string.about_tennis)
                )
            )
        }
    }
}