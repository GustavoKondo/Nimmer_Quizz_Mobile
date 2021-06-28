package com.example.nimmer_quizz.repository

import com.example.nimmer_quizz.api.RetrofitInstance
import com.example.nimmer_quizz.model.Post
import retrofit2.Response

class Repository {

    suspend fun  getPost(): Response<Post> {
        return RetrofitInstance.api.getpost()
    }
}