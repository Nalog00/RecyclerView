package com.example.lesson14
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val tvTitle: TextView = itemView.tvTitle
    private val tvDescriptor: TextView = itemView.tvDescription
    fun populateModel(user: User, size: Int, position: Int, activity: MainActivity){
        tvTitle.text = user.title
        tvDescriptor.text = user.descriptor
        itemView.btnOptions.setOnClickListener {
            activity.onOptionsButtonClick(itemView.btnOptions,position)

        }

    }

}