package com.irvanw.tugaschaptertiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnGoto : Button = findViewById(R.id.btnGotoBMI)
        var btnGotoMahasiswa : Button = findViewById(R.id.btnMahasiswa)


        btnGoto.setOnClickListener(){
            val intent= Intent(this@MainActivity,ActivityBmi::class.java)
            startActivity(intent)
        }

        btnGotoMahasiswa.setOnClickListener(){
            val intent= Intent(this@MainActivity,ActivityMahasiswa::class.java)
            startActivity(intent)
        }

    }
}