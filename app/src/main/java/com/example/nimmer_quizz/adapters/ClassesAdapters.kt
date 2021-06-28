package com.example.nimmer_quizz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nimmer_quizz.R
import com.example.nimmer_quizz.model.ClassesModel

class ClassesAdapters( var context: Context , var arrayList: ArrayList<ClassesModel>)
    :RecyclerView.Adapter<ClassesAdapters.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_classes , parent , false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var alphaClasses: ClassesModel = arrayList.get(position)

        holder.icons.setImageResource(alphaClasses.iconsClasses!!)
        holder.alphas.text = alphaClasses.alphaClasses

        holder.alphas.setOnClickListener{
            Toast.makeText(context, alphaClasses.alphaClasses, Toast.LENGTH_LONG).show()
        }
    }


    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var icons = itemView.findViewById<ImageView>(R.id.icons_classes)
        var alphas = itemView.findViewById<TextView>(R.id.classes_text_view)

    }
}