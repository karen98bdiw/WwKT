package com.example.wwkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.MainThread
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.single.SingleObserveOn
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var gson:Gson
    lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gson = Gson()

        retrofit = Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

       val requestInterface = retrofit.create(RequestInterface::class.java)

        btn.setOnClickListener{
            var writenText = inputArea.text.toString()
            if(!TextUtils.isEmpty(writenText)){
                Utils.doRequestSetResult(writenText,requestInterface,Utils.API_KEY,outputArea)
            }else{
                Toast.makeText(this@MainActivity,"write text...",Toast.LENGTH_LONG).show()
            }
      }

    }


    fun isUserWriting(inputArea:EditText,lastPart:String) : Boolean{

        if(inputArea.text.toString().equals(lastPart)){
            return false
        }
        return true

    }
}
