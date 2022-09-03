package com.irvanw.tugaschaptertiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.irvanw.tugaschaptertiga.databinding.ActivityOutputBinding

class ActivityOutput : AppCompatActivity() {
    lateinit var binding: ActivityOutputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataSerial()
        getDataIntent()
        getDataBundle()
        getDataParcel()

    }


    fun getDataIntent(){
        var umurIntent : String = intent.getStringExtra("umur").toString()
        var tinggiIntent: String = intent.getStringExtra("tinggi").toString()
        var beratIntent: String = intent.getStringExtra("bb").toString()

        binding.tvUmurIntent.setText("Umur Anda : "+umurIntent)
        binding.tvTinggiIntent.setText("Tinggi Anda : "+tinggiIntent)
        binding.tvBBIntent.setText("Berat Badan : "+beratIntent)
        val BMI : Double = hitung(beratIntent.toDouble(),tinggiIntent.toDouble())
        binding.tvBMIIntent.setText("BMI Anda : " + BMI.toString())
        binding.tvkategoriIntent.setText("Kategori : "+kategori(BMI).toString())
    }

    fun getDataBundle(){
        var bund = intent.extras

        var umurBundle = bund!!.getString("umur")
        var tinggiBundle = bund!!.getString("tinggi")
        var beratBundle = bund!!.getString("bb")

        binding.tvUmurBundle.setText("Umur Anda : "+umurBundle)
        binding.tvTinggiBundle.setText("Tinggi Anda : "+tinggiBundle)
        binding.tvBBBundle.setText("Berat Badan : "+beratBundle)
        val BMI : Double = hitung(beratBundle!!.toDouble(),tinggiBundle!!.toDouble())
        binding.tvBMIBundle.setText("BMI Anda : " + BMI.toString())
        binding.tvKategoriBundle.setText("Kategori : "+kategori(BMI).toString())

    }

    fun getDataSerial(){
        var data = intent.getSerializableExtra("dataSerial") as DataSerial
        binding.tvUmurSerial.setText("Umur Anda : "+data.umur)
        binding.tvTinggiSerial.setText("Tinggi : "+data.tinggi)
        binding.tvBBSerial.setText("Berat Badan : "+data.berat)
        val BMI : Double = hitung(data.berat.toDouble(),data.tinggi.toDouble())
        binding.tvBMISerial.setText("BMI Anda : "+BMI.toString())
        binding.tvkategoriSerial.setText("Kategori : "+kategori(BMI).toString())
    }


    fun getDataParcel(){
        var dataParcel = intent.getParcelableExtra("dataParcel") as DataParcelable?
        binding.tvUmurParcel.setText("Umur Anda : "+dataParcel?.umur)
        binding.tvTinggiParcel.setText("Tinggi : "+dataParcel?.tinggi)
        binding.tvBBParcel.setText("Berat Badan : "+dataParcel?.berat)
        val BMIParcel : Double = hitung(dataParcel!!.berat.toDouble(),dataParcel!!.tinggi.toDouble())
        binding.tvBMIParcel.setText("BMI Anda : "+BMIParcel.toString())
        binding.tvKategoriParcel.setText("Kategori : "+kategori(BMIParcel))
    }


    fun hitung(bb: Double,tinggi:Double):Double{
        var meter = tinggi/100
        var hasil = (bb/(meter*meter))

        return hasil
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
}