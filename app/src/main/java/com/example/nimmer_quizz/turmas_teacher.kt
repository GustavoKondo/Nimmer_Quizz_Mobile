package com.example.nimmer_quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nimmer_quizz.adapters.ClassesAdapters
import com.example.nimmer_quizz.model.AlphaChar
import com.example.nimmer_quizz.model.ClassesModel
import kotlinx.android.synthetic.main.activity_turmas_teacher.*

class turmas_teacher : AppCompatActivity() {

    private var recyclerView:RecyclerView ? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList:ArrayList<ClassesModel> ? = null
    private var classesAdapters: ClassesAdapters? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turmas_teacher)

        recyclerView = findViewById(R.id.classesList)
        gridLayoutManager = GridLayoutManager(applicationContext,2,LinearLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = setDataList()
        classesAdapters =  ClassesAdapters(applicationContext,arrayList!!)
        recyclerView?.adapter = classesAdapters

        // botão para abrir a Modal de criação de turma

        button_dialog.setOnClickListener{
            val dialog = AddDialogFragmentClasses()
            dialog.show(supportFragmentManager, dialog.tag)
        }

    }

    private  fun setDataList():ArrayList<ClassesModel>{
        var items: ArrayList<ClassesModel> = ArrayList()

        items.add(ClassesModel(R.drawable.instagram , "turma 1"))
        items.add(ClassesModel(R.drawable.facebook , "turma 2"))
        items.add(ClassesModel(R.drawable.logo , "turma 3"))

        return items
    }
}