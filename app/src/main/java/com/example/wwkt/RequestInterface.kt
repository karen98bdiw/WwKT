package com.example.wwkt

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import kotlin.collections.ArrayList

interface RequestInterface {

    @GET("translate")
    abstract fun callRequest(@Query("key") key:String,@Query("text") text:String,@Query("lang") lang:String): Call<ResponsParser>

}