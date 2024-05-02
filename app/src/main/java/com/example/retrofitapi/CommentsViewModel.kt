package com.example.retrofitapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentsViewModel : ViewModel() {
    private val _comments = MutableLiveData<List<Comments>>()
    val comments: LiveData<List<Comments>> = _comments

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val Tag: String = "CHECK_RESPONSE"

    init {
        getAllComments()
    }

    private fun getAllComments() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)

        api.getComments().enqueue(object : Callback<List<Comments>?> {
            override fun onResponse(call: Call<List<Comments>?>, response: Response<List<Comments>?>) {
                if (response.isSuccessful) {
                    response.body()?.let { comments ->
                        _comments.value = comments
                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>?>, t: Throwable) {
                Log.i(Tag, "onFailure: ${t.message}")
            }
        })
    }
}
