package com.example.rv_kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_kotlin.R
import com.example.rv_kotlin.data.TextModel
import com.example.rv_kotlin.fragmets.TextFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       supportFragmentManager.beginTransaction()
           .replace(R.id.fragment_container_view, TextFragment())
           .commit()
    }
}