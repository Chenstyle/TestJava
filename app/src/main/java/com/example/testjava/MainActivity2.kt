package com.example.testjava

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn_test.setOnClickListener(clickBtnLis)
    }


    private val clickBtnLis = View.OnClickListener { v ->
        println(v?.id)
        Toast.makeText(this@MainActivity2, "Oh I see", Toast.LENGTH_SHORT).show()
    }
}