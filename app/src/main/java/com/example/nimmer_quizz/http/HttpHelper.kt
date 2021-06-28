package com.example.nimmer_quizz.http

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.net.URL

class HttpHelper {

    fun post (json: String) : String {
        //definir url do server
        val URL ="http://192.168.56.1:8080/teacher"


        //definir cabeçalho
        val headerHttp = "application/json; charset = utf-8".toMediaTypeOrNull()

        //criar um clienmt

        val client = OkHttpClient()

        // criar body da requisição

        val body = RequestBody.create(headerHttp, json)

        //construir a requisição http  para o servidor

        var request = Request.Builder().url(URL).post(body).build()


        //utilizar o client para fazer a requisição e receber a resposta
        var response = client.newCall(request).execute()

        return response.body. toString()
    }
    fun get(){
        //definir url do server
        val URL ="http://192.168.56.1:8080/teacher"

        //criar um client

        val client = OkHttpClient()

        //criar requisição GET
        val request = Request.Builder().url(URL).get().build()

        //Enviar a requisição para o servidor
        val response = client.newCall(request).execute()

        //Extrair body da requisição
        val responseBody = response.body

        //Exibir o body da requisição
        if (responseBody!= null){
            val json = responseBody.string()
            println("respsosta==========="+ json)
        }

    }
}