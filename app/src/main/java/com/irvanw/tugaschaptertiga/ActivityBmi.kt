package com.irvanw.tugaschaptertiga

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.irvanw.tugaschaptertiga.databinding.ActivityBmiBinding

class ActivityBmi : AppCompatActivity() {


    private lateinit var binding: ActivityBmiBinding
    lateinit var intentGo : Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intentGo = Intent(this,ActivityOutput::class.java)


        binding.btnHitung.setOnClickListener(){
            validateInput()
        }

        binding.btnReset.setOnClickListener(){
            reset()
        }

    }


    fun validateInput(){
        if(TextUtils.isEmpty(binding.edtUmur.text.toString()) || TextUtils.isEmpty(binding.edtBerat.text.toString()) || TextUtils.isEmpty(binding.edtTinggi.text.toString()) ) {
            Toast.makeText(this, "Harap isi semua field yang ada", Toast.LENGTH_SHORT).show()
        } else {
            passDataSerial()
            regularIntent()
            bundleIntent()
            passDataParcelable()
        }
    }

    fun reset(){
        binding.edtUmur.setText(null)
        binding.edtBerat.setText(null)
        binding.edtTinggi.setText(null)

    }

    fun regularIntent(){
        intentGo.putExtra("umur",binding.edtUmur.text.toString())
        intentGo.putExtra("tinggi",binding.edtTinggi.text.toString())
        intentGo.putExtra("bb",binding.edtBerat.text.toString())
        startActivity(intentGo)
    }

    fun bundleIntent(){
        val bundle = Bundle()
        bundle.putString("umur",binding.edtUmur.text.toString())
        bundle.putString("tinggi",binding.edtTinggi.text.toString())
        bundle.putString("bb",binding.edtBerat.text.toString())
        intentGo.putExtras(bundle)
        startActivity(intentGo)
    }

    fun passDataSerial(){
        var data = DataSerial(binding.edtUmur.text.toString(),binding.edtTinggi.text.toString(),binding.edtBerat.text.toString())
        intentGo.putExtra("dataSerial",data)
        startActivity(intentGo)

    }

    fun passDataParcelable(){
        var dataParcel = DataParcelable(binding.edtUmur.text.toString(),binding.edtTinggi.text.toString(),binding.edtBerat.text.toString())
        intentGo.putExtra("dataParcel",dataParcel)
        startActivity(intentGo)
    }

}