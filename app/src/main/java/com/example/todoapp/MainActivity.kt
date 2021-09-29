package com.example.todoapp

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var toDoList: ArrayList<ToDo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toDoList = ArrayList()

        floatingActionButton = findViewById(R.id.floatingActionButton)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerViewAdapter = RecyclerViewAdapter(toDoList)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener {
            addEntryDialog()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {

        }
        return super.onOptionsItemSelected(item)
    }

    private fun addEntryDialog() {
        val builder = AlertDialog.Builder(this)

        val dialogView = LayoutInflater.from(this).inflate(R.layout.add_entry_dialog, null)
        val dialogEditText = dialogView.findViewById<TextView>(R.id.dialog_editText)

        builder.setPositiveButton("Add", DialogInterface.OnClickListener { _, _ ->
            toDoList.add(ToDo(dialogEditText.text.toString(), false))
        })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
                dialog.cancel()
            })

        val alert = builder.create()
        alert.setView(dialogView)
        alert.show()
    }
}