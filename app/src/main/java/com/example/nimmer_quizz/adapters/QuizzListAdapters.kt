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
import com.example.nimmer_quizz.model.QuizzListModel

class QuizzListAdapters( var context: Context, var arrayList: ArrayList<QuizzListModel>)
    :RecyclerView.Adapter<QuizzListAdapters.ItemHolder>(){
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_for_quizz,parent,false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount():Int{
        return arrayList.size
    }

    override fun onBindViewHolder(holder:ItemHolder, position:Int){
        var alphaQuizz: QuizzListModel = arrayList.get(position)

        holder.icons.setImageResource(alphaQuizz.iconsQuizz!!)
        holder.alphas.text = alphaQuizz.alphaQuizz
        holder.alphasDescription.text = alphaQuizz.descriptionQuizz

        holder.alphasDescription.setOnClickListener{
            Toast.makeText(context,alphaQuizz.alphaQuizz,Toast.LENGTH_LONG).show()
        }
    }

    class ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.cover_image)
        var alphas = itemView.findViewById<TextView>(R.id.quizz_text_view)
        var alphasDescription = itemView.findViewById<TextView>(R.id.quizz_description_view)
    }

}

