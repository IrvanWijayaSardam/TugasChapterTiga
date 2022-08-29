package com.irvanw.tugaschaptertiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityMahasiswa : AppCompatActivity() {
    lateinit var edtNama : EditText
    lateinit var edtNim : EditText
    lateinit var edtNilaiUas : EditText
    lateinit var edtNilaiUts : EditText
    lateinit var edtNilaiTugas : EditText

    lateinit var btnHitung : Button
    lateinit var btnReset: Button

    lateinit var tvNama : TextView
    lateinit var tvNim : TextView
    lateinit var tvUas : TextView
    lateinit var tvUts : TextView
    lateinit var tvTugas : TextView
    lateinit var tvTotal : TextView
    lateinit var tvRata : TextView
    lateinit var tvNilai : TextView
    lateinit var tvStatus : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa)

        edtNama = findViewById(R.id.edtNama)
        edtNim = findViewById(R.id.edtNim)
        edtNilaiUas = findViewById(R.id.edtUAS)
        edtNilaiUts = findViewById(R.id.edtUTS)
        edtNilaiTugas = findViewById(R.id.edtTugas)

        btnHitung = findViewById(R.id.btnHitungNilai)
        btnReset = findViewById(R.id.btnResetNilai)

        tvNama = findViewById(R.id.tvNamaMahasiswa)
        tvNim = findViewById(R.id.tvNim)
        tvUas = findViewById(R.id.tvUas)
        tvUts = findViewById(R.id.tvUts)
        tvTugas = findViewById(R.id.tvTugas)
        tvTotal = findViewById(R.id.tvTotal)
        tvRata = findViewById(R.id.tvRata)
        tvNilai = findViewById(R.id.tvNilaiHuruf)
        tvStatus = findViewById(R.id.tvStatus)



        onClick()

    }

    fun hitungNilai(uas:Int,uts:Int,tugas:Int):Int{
        val hasil : Int = (uas+uts+tugas)/3

        return hasil
    }

    fun onClick(){
        btnHitung.setOnClickListener(){
            validate()
        }
        btnReset.setOnClickListener(){
            reset()
        }

    }

    fun validate(){
        if(TextUtils.isEmpty(edtNama.text.toString()) || TextUtils.isEmpty(edtNim.text.toString()) || TextUtils.isEmpty(edtNilaiTugas.text.toString()) ||
            TextUtils.isEmpty(edtNilaiUas.text.toString()) || TextUtils.isEmpty(edtNilaiUts.text.toString())) {
            Toast.makeText(this, "Harap isi semua field yang disediakan", Toast.LENGTH_SHORT).show()
        }  else {
            tvNama.setText("Nama Mahasiswa : "+edtNama.text.toString())
            tvNim.setText("Nim : "+edtNim.text.toString())
            tvUas.setText("UAS : "+edtNilaiUas.text.toString())
            tvUts.setText("UTS : "+edtNilaiUts.text.toString())
            tvTugas.setText("Tugas : "+edtNilaiTugas.text.toString())
            var total : Int = Integer.parseInt(edtNilaiUas.text.toString()) + Integer.parseInt(edtNilaiUts.text.toString())+Integer.parseInt(edtNilaiTugas.text.toString())
            tvTotal.setText("Total : "+total.toString())
            var hasil : Int = hitungNilai(Integer.parseInt(edtNilaiUas.text.toString()),Integer.parseInt(edtNilaiUts.text.toString()),Integer.parseInt(edtNilaiTugas.text.toString()))
            tvRata.setText("Rata-Rata Nilai : "+hasil.toString())
            tvNilai.setText("Nilai Huruf : "+checkNilaiHuruf(hasil))
            tvStatus.setText("Status : "+checkStatus(checkNilaiHuruf(hasil)))
        }
    }

    fun checkNilaiHuruf(rata: Int): Char {
        var nHuruf : Char = 'A'
        when(rata) {
            in 0..60 -> nHuruf = 'F'
            in 61..70 -> nHuruf = 'D'
            in 71..80 -> nHuruf = 'C'
            in 81..90 -> nHuruf = 'B'
            in 91..100 -> nHuruf = 'A'
        }
        return nHuruf
    }

    fun checkStatus(nHuruf: Char): String{
        var status : String = "Not Yet Initiated"
        if(nHuruf == 'A'){
            status = "Lulus"
        } else if(nHuruf == 'B'){
            status = "Lulus"
        } else if(nHuruf == 'C'){
            status = "Lulus"
        } else if(nHuruf == 'D'){
            status = "Tidak Lulus"
        } else if(nHuruf == 'E'){
            status = "Tidak Lulus"
        }
        return status
    }

    fun reset(){
        tvNama.setText("Nama Mahasiswa : ")
        tvNim.setText("Nim : ")
        tvUas.setText("UAS : ")
        tvUts.setText("UTS : ")
        tvTugas.setText("Tugas : ")
        tvTotal.setText("Total : ")
        tvRata.setText("Rata-Rata Nilai : ")
        tvNilai.setText("Nilai Huruf : ")
        tvStatus.setText("Status : ")

        edtNama.setText(null)
        edtNim.setText(null)
        edtNilaiUas.setText(null)
        edtNilaiUts.setText(null)
        edtNilaiTugas.setText(null)

    }
}