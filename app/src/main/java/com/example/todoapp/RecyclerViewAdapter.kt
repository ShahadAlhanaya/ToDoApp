package com.example.todoapp

import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemRowBinding

class RecyclerViewAdapter(private val items: ArrayList<ToDo>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            ToDoTitleTextView.text = items[position].title
            ToDoBoxCheckBox.isChecked = items[position].checked
            ToDoBoxCheckBox.setOnCheckedChangeListener { _, isChecked ->
                items[position].checked = !items[position].checked
                if (isChecked) {
                    ToDoTitleTextView.setTextColor(Color.parseColor("#BCE784"))
                } else {
                    ToDoTitleTextView.setTextColor(Color.parseColor("#30b077"))
                }
            }

        }
    }


    override fun getItemCount() = items.size

//    fun deleteSelectedItems() {
//        for(i in 0 until items.size){
//            if(items[i].checked) items.removeAt(i)
//        }
//    }
    fun deleteItems(){
        items.removeAll{ item -> item.checked }
        notifyDataSetChanged()
    }

}
