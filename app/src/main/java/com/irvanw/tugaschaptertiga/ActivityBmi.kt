package com.irvanw.tugaschaptertiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityBmi : AppCompatActivity() {

    lateinit var edtUmur: EditText
    lateinit var edtBb : EditText
    lateinit var edtTinggi: EditText
    lateinit var tvBMI : TextView
    lateinit var tvKategori : TextView
    lateinit var tvUmur : TextView
    lateinit var tvTinggi : TextView
    lateinit var tvBB : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        edtUmur = findViewById(R.id.edtUmur)
        edtTinggi = findViewById(R.id.edtTinggi)
        edtBb = findViewById(R.id.edtBerat)

        var btnHitung: Button = findViewById(R.id.btnHitung)
        var btnReset: Button = findViewById(R.id.btnReset)

        tvUmur = findViewById(R.id.tvUmur)
        tvTinggi = findViewById(R.id.tvTinggi)
        tvBB = findViewById(R.id.tvBB)
        tvBMI = findViewById(R.id.tvBMI)
        tvKategori = findViewById(R.id.tvKategori)


        btnHitung.setOnClickListener(){

            validateInput()
        }

        btnReset.setOnClickListener(){
            reset()
        }

    }

    fun hitung(bb: Double,tinggi:Double):Double{
        var meter = tinggi/100
        var hasil = (bb/(meter*meter))

        return hasil
    }

    fun validateInput(){
        if(TextUtils.isEmpty(edtUmur.text.toString()) || TextUtils.isEmpty(edtBb.text.toString()) || TextUtils.isEmpty(edtTinggi.text.toString()) ) {
            Toast.makeText(this, "Harap isi semua field yang ada", Toast.LENGTH_SHORT).show()
        } else {
            tvUmur.setText("Umur Anda : "+edtUmur.text.toString() + " tahun")
            tvTinggi.setText("Tinggi : "+edtTinggi.text.toString() + " cm")
            tvBB.setText("Berat Badan : "+edtBb.text.toString() + "kg")
            var hasilBMI : Double = hitung(edtBb.text.toString().toDouble(),edtTinggi.text.toString().toDouble())
            tvBMI.setText("BMI ANDA : " +hasilBMI.toString())
            tvKategori.setText("Kategori : "+kategori(hasilBMI))
        }
    }

    fun kategori(bmi: Double):String{
        var kategori: String = "Not Yet Initiated"
        if(bmi <16.0 ){
            kategori = "Terlalu kurus"
        } else if (bmi >=16 && bmi <=17){
            kategori = "Cukup kurus"
        } else if(bmi >17.0 && bmi < 18.5){
            kategori = "Sedikit kurus"
        } else if(bmi >=18.5 && bmi < 25){
            kategori = "Normal"
        } else if(bmi >=25 && bmi < 30){
            kategori = "Gemuk"
        } else if(bmi >30 && bmi < 35){
            kategori = "Obesitas Kelas I"
        } else if(bmi >=35 && bmi <40){
            kategori = "Obesitas Kelas II"
        } else {
            kategori = "Obesitas Kelas III"
        }

        return kategori
    }

    fun reset(){
        edtUmur.setText(null)
        edtBb.setText(null)
        edtTinggi.setText(null)

        tvUmur.setText("Umur Anda : ")
        tvTinggi.setText("Tinggi : ")
        tvBB.setText("Berat Badan : ")
        tvBMI.setText("BMI Anda : ")
        tvKategori.setText("Kategori : ")
    }
}