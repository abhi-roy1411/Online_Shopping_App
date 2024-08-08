package com.example.chatwiseassignment

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExpandProduct: AppCompatActivity() {

    lateinit var myAdapter: MyAdapter;
    lateinit var recyclerView: RecyclerView;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                val responseBody = response.body()
                val productArray = responseBody?.products!!

                myAdapter = MyAdapter(this@ExpandProduct, productArray)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@ExpandProduct)
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Log.d(TAG, "onFailure: "+t.message)
            }

        })

    }
}