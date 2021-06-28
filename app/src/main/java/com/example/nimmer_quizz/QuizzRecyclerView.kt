package com.example.nimmer_quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.nimmer_quizz.adapters.QuizzListAdapters
import com.example.nimmer_quizz.model.QuizzListModel
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_turmas_teacher.*


class QuizzRecyclerView : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    private var listAdapters : QuizzListAdapters? = null
    private var arrayList:ArrayList<QuizzListModel>? = null
    private var quizzlist = listOf<QuizzListModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_recycler_view)


        recyclerView = findViewById(R.id.quizz_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)
        arrayList = setDataList()
        listAdapters = QuizzListAdapters(applicationContext,arrayList!!)
        recyclerView?.adapter = listAdapters


        // botão para abrir a Modal de criação de turma

        button_dialog.setOnClickListener{
            val dialog = AddDialogFragmaentQuizz()
            dialog.show(supportFragmentManager, dialog.tag)
        }
    }


    private fun  setDataList():ArrayList<QuizzListModel>{
        var  items: ArrayList<QuizzListModel> = ArrayList()

        items.add(QuizzListModel(R.drawable.kotlin,"Quizz de Kotlin","quizz com questoes de desenvolvimento mobile"))
        items.add(QuizzListModel(R.drawable.node,"Quizz de Node","quizz com questoes de desenvolvimento backend"))
        items.add(QuizzListModel(R.drawable.react,"Quizz de ReactJS","quizz com questoes de desenvolvimento web"))
        return items
    }

}