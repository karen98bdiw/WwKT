package com.example.wwkt

import com.google.gson.annotations.SerializedName
import java.util.*

class ResponsParser {

    @SerializedName("code")
    var code:Float? = null
    @SerializedName("lang")
    var lang:String? = null
    @SerializedName("text")
    var text: ArrayList<Any> = arrayListOf()

}