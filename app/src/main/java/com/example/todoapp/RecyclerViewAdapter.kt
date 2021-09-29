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
            ToDoTitleTextView.text = ""
            ToDoBoxCheckBox.isChecked = false
            ToDoTitleTextView.text = items[position].title
            ToDoBoxCheckBox.isChecked = items[position].checked
            if(ToDoBoxCheckBox.isChecked){
                ToDoTitleTextView.setTextColor(Color.parseColor("#8FE0BC"))
            }else{
                ToDoTitleTextView.setTextColor(Color.parseColor("#30b077"))
            }

            ToDoBoxCheckBox.setOnCheckedChangeListener { button, isChecked ->
                items[position].checked = !items[position].checked
                if(isChecked)
                    ToDoTitleTextView.setTextColor(Color.parseColor("#8FE0BC"))
                else ToDoTitleTextView.setTextColor(Color.parseColor("#30b077"))

            }
        }
    }


    override fun getItemCount() = items.size

}
