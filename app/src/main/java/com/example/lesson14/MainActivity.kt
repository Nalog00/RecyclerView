package com.example.lesson14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 1
    private val adapter: ListAdapter = ListAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        setDate()
    }

    private fun setDate() {
        val models: MutableList<User> = mutableListOf()
        val model: User = User()
        model.title = "Title${count}"
        model.descriptor = "Description${count}"
        models.add(model)
        adapter.setData(models)
    }

    fun onItemClicked(user: User) {
        count+=user.cr
        Toast.makeText(this, " Title ${user.cr} is Clicked", Toast.LENGTH_SHORT).show()
        val models: MutableList<User> = mutableListOf()
        for (i in 0 until count) {
            val model: User = User()
            model.title = "Title${i+1}"
            model.descriptor = "Description${i+1}"
            model.cr+=i
            models.add(model)
        }
        adapter.setData(models)
    }
}