package com.example.lesson14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val activity: MainActivity): RecyclerView.Adapter<ListViewHolder>(){
    var models: MutableList<User> = mutableListOf()
    fun setData(data: MutableList<User>) {
        models = data
        notifyDataSetChanged()

    }
    fun addUser(position: Int){
        models.add(position,User("Title ${models.size+1}", "Description ${models.size+1}"))
        notifyItemInserted(position)
        notifyItemRangeChanged(position,models.size)
    }
    fun removed(position: Int){
        models.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,models.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModel(models[position],itemCount, position, activity)

    }

}