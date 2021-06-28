package com.example.nimmer_quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nimmer_quizz.adapters.AlphaAdapters
import com.example.nimmer_quizz.model.AlphaChar
import com.example.nimmer_quizz.repository.Repository
import kotlinx.android.synthetic.main.home_activity.*

lateinit var  toggle: ActionBarDrawerToggle

class home_Activity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private var recyclerView:RecyclerView ? = null
    private var gridLayoutManager:GridLayoutManager ? = null
    private var arrayList:ArrayList<AlphaChar> ? = null
    private var alphaAdapters:AlphaAdapters ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        recyclerView = findViewById(R.id.technicalCourseList)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL  , false)
        recyclerView?.layoutManager =gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapters = AlphaAdapters(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdapters

        // Variaveis do Consumo com RETROFIT
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuItem1 -> Toast.makeText(applicationContext,
                "item 1 clicado", Toast.LENGTH_SHORT).show()

                R.id.menuItem2 -> Toast.makeText(applicationContext,
                    "item 2 clicado", Toast.LENGTH_SHORT).show()

                R.id.menuItem3 -> Toast.makeText(applicationContext,
                    "item 3 clicado", Toast.LENGTH_SHORT).show()
            }
            true
        }

        button_provisorio_turmas.setOnClickListener{
            openNextActivity()
        }


        //GET COM RETROFIT

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {response->
          if (response.isSuccessful){
              Log.d("Response",response.body()?.userId.toString())
              Log.d("Response",response.body()?.id.toString())
              Log.d("Response",response.body()?.title!!)
              Log.d("Response",response.body()?.body!!)
          }
            else{
              Log.d("Response",response.errorBody().toString())
          }

        })

    }

    private fun setDataInList() :ArrayList<AlphaChar>{
        var items:ArrayList<AlphaChar> = ArrayList()

            items.add(AlphaChar(R.drawable.quizgames , "curso 1"))
            items.add(AlphaChar(R.drawable.team , "curso 2"))
            items.add(AlphaChar(R.drawable.logo , "curso 3"))
            items.add(AlphaChar(R.drawable.quizgames , "curso 4"))


        return items
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true

        }
        return super.onOptionsItemSelected(item)
    }

    private fun  openNextActivity(){
        val intent = Intent(this, turmas_teacher::class.java)
        startActivity(intent)
    }

}