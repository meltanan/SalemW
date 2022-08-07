package com.example.salemweb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.salemweb.R
import com.example.salemweb.SelectListener
import com.example.salemweb.showToast
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(), SelectListener {
    private val viewModel: HomeActivityViewModel by viewModels()
    private lateinit var additionButton: Button
    private lateinit var editText: EditText
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUi()
    }

    private fun addNumber(number: Int) {
        viewModel.viewModelScope.launch {
            val result = viewModel.addingNumber(number)
            showToast("The value is $result")
        }
    }

    private fun setupUi() {
        val names = viewModel.getNamesList()
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NamesAdapter(names, this)
        editText = findViewById(R.id.editText)
        additionButton = findViewById(R.id.button)
        additionButton.setOnClickListener(){
            if (!editText.text.isNullOrEmpty()){
                editText.text.toString().toIntOrNull()?.let { it1 -> addNumber(it1) }.run {
                    showToast("Input must be a number! Try again please")
                }
            }
            else showToast("Input is required")
        }
    }

    override fun onItemSelected(index: Int) {
        val names = viewModel.getNamesList()
        val reversedName = names[index].reversed()
        showToast(reversedName)
    }
}