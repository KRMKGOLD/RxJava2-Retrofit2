package com.example.rxjava2_retrofit2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.rxjava2_retrofit2.model.Repo

class MainAdapter(private val context : Context, private var list : ArrayList<Repo>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItem(list : ArrayList<Repo>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val description = itemView.findViewById<TextView>(R.id.description)
        private val url = itemView.findViewById<TextView>(R.id.htmlUrl)

        fun bind(bindList : Repo) {
            name.text = bindList.name
            description.text = bindList.description
            url.text = bindList.htmlUrl
        }
    }
}