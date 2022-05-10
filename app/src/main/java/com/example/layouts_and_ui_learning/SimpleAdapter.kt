package com.example.layouts_and_ui_learning

import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SimpleViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SimpleViewHolder).onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<String>) {
        this.data.clear()
        this.data.addAll(data)
    }

    inner class SimpleViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_textview, parent, false)
    ) {
        val textView: TextView = itemView.findViewById(R.id.textView)

        fun onBind(textToDisplay: String) {
            textView.text = textToDisplay
        }
    }
}