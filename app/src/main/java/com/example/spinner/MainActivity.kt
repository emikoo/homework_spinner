package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var spCities: Spinner? = null
    private var tvCities: TextView? = null
    private var isFirst = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setupSpinner()
        setupListeners()
    }

    private fun initView(){
        spCities = findViewById(R.id.spCities)
        tvCities = findViewById(R.id.tvCities)
    }

    private fun setupSpinner(){
        val adapter =
                ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCities?.adapter = adapter
    }

    private fun setupListeners(){
        spCities?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (isFirst){
                    val selectedItem = parent?.getItemAtPosition(position).toString()
                    tvCities?.text = selectedItem
                }
                isFirst = true
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
}