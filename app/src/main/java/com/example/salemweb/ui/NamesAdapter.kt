package com.example.salemweb.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.salemweb.R
import com.example.salemweb.SelectListener

class NamesAdapter(private val names: List<String>, private val listener: SelectListener): RecyclerView.Adapter<NamesAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trending_repo_row, parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = names[position]
        holder.cardView.setOnClickListener{
            listener.onItemSelected(position)
        }
    }

    override fun getItemCount(): Int = names.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val name: TextView = itemView.findViewById(R.id.name_textView)
    }
}