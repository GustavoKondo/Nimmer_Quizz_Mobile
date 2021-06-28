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
import com.example.nimmer_quizz.model.AlphaChar

class AlphaAdapters( var context: Context , var arrayList: ArrayList<AlphaChar>)
    :RecyclerView.Adapter<AlphaAdapters.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

       val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_for_cursos , parent , false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var alphaChar: AlphaChar = arrayList.get(position)

        holder.icons.setImageResource(alphaChar.iconsChar!!)
        holder.alphas.text = alphaChar.alphaChar

        holder.alphas.setOnClickListener{
            Toast.makeText(context, alphaChar.alphaChar, Toast.LENGTH_LONG).show()
        }
    }


    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var icons = itemView.findViewById<ImageView>(R.id.icons_cursos)
        var alphas = itemView.findViewById<TextView>(R.id.cursos_text_view)

    }
}