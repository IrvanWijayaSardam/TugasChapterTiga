package com.irvanw.tugaschaptertiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.irvanw.tugaschaptertiga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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