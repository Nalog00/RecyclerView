package com.example.lesson14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private val adapter: ListAdapter = ListAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(1)
    }

    private fun setData(count: Int) {
        val models: MutableList<User> = mutableListOf()
        for (i in 0 until count) {
            val model = User()
            model.title = "Title${i + 1}"
            model.descriptor = "Description${i + 1}"
            models.add(model)
        }
        adapter.setData(models)

    }

    fun onOptionsButtonClick(view: View, position: Int) {
        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options, optionsMenu.menu)

        optionsMenu.setOnMenuItemClickListener() {
            when (it.itemId) {
                R.id.itemAdd -> {
                    adapter.addUser(position + 1)
                }
                R.id.itemDelete -> {
                    val button = AlertDialog.Builder(this)
                    button.setTitle("Важное сообщение!!")
                        .setMessage("Вы действительно хотите удалить этот поле? ")
                        .setPositiveButton("Да") { _, _ ->
                            adapter.removed(position)
                            Toast.makeText(this, "Удален поле", Toast.LENGTH_SHORT)
                                .show()
                        }
                    button.setNegativeButton("Нет") { _, _ ->
                        Toast.makeText(this, "Без изменений", Toast.LENGTH_SHORT).show()
                    }
                    button.show()
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }
}
