package com.example.nimmer_quizz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nimmer_quizz.model.Post
import com.example.nimmer_quizz.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch{
            val response = repository.getPost()
            myResponse.value = response
        }
    }

}