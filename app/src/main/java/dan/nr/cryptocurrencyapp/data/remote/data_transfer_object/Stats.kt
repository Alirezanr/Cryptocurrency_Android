package dan.nr.cryptocurrencyapp.data.remote.data_transfer_object


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("contributors")
    val contributors: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("subscribers")
    val subscribers: Int
)