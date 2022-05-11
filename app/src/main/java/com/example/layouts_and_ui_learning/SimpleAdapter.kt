package com.example.layouts_and_ui_learning

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<String>()
    private var headerText: String? = null

    // ---------------
    // Header
    // Elements 0 - n
    // Footer
    // ---------------

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> R.layout.view_holder_header
            data.size + 1 -> R.layout.view_holder_footer
            else -> R.layout.view_holder_textview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.view_holder_header -> SimpleHeaderViewHolder(parent)
            R.layout.view_holder_footer -> SimpleFooterViewHolder(parent)
            else -> SimpleViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SimpleHeaderViewHolder -> holder.onBind(headerText)
            is SimpleFooterViewHolder -> holder.onBind()
            is SimpleViewHolder -> holder.onBind(data[position - 1], position)
        }
    }

    override fun getItemCount(): Int {
        return data.size + 2
    }

    fun setData(data: List<String>, headerText: String) {
        this.data.clear()
        this.data.addAll(data)
        this.headerText = headerText
    }

    inner class SimpleViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_textview, parent, false)
    ) {
        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun onBind(textToDisplay: String, position: Int) {

            val color = if (position % 2 == 0) {
                itemView.context.getColor(R.color.light_gray_background)
            } else {
                itemView.context.getColor(R.color.white)
            }
            textView.text = textToDisplay
            itemView.setBackgroundColor(color)
        }
    }

    inner class SimpleHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_header, parent, false)
    ) {
        private val headerTextView: TextView = itemView.findViewById(R.id.headerTextView)

        fun onBind(headerText: String?) {

            val textToDisplay = headerText ?: "No header for you!"
            headerTextView.text = textToDisplay
        }
    }

    inner class SimpleFooterViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_footer, parent, false)
    ) {
        private val leftButton: Button = itemView.findViewById(R.id.leftButton)
        private val rightButton: Button = itemView.findViewById(R.id.rightButton)

        fun onBind() {

            leftButton.setOnClickListener {
                Log.i("Left", "L button clicked!")
            }
            rightButton.setOnClickListener {
                Log.i("Right", "R button clicked!")
            }
        }
    }
}