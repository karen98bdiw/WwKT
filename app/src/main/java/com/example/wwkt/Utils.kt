package com.example.wwkt

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class Utils {

    companion object {

           val BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/"
           val API_KEY = "trnsl.1.1.20190609T144822Z.c9cb1523015a8ec2.d86184d1277e69937239b3456b9d00a7d8c60a3a"


           fun doRequestSetResult(text:String,requestInterface:RequestInterface,apiKey:String,outputArea:TextView){
               val call: Call<ResponsParser> = requestInterface.callRequest(apiKey,text,"en-ru")

               call.enqueue(object :retrofit2.Callback<ResponsParser>{
                   override fun onFailure(call: Call<ResponsParser>, t: Throwable) {

                   }

                   override fun onResponse(call: Call<ResponsParser>, response: Response<ResponsParser>) {
                           outputArea.setText(response.body()?.text?.get(0).toString())
                   }

               })

           }
       }



    }



