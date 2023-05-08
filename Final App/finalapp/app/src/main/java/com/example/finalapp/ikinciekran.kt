package com.example.finalapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.Toast
import androidx.core.os.postDelayed
import androidx.core.widget.addTextChangedListener

val dosyayolu="com.abdulkadirkara.finalapp"
var anahtarisim = "isim"
var anahtarsifre = "sifre"
var anahtarunutma="unutma"


class ikinciekran : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ikinciekran)

        val edittextisim=findViewById<EditText>(R.id.editTextisim)
        val edittextsifre=findViewById<EditText>(R.id.editTextsifre)
        val switchbtn=findViewById<Switch>(R.id.switch1)
        val progress = findViewById<ProgressBar>(R.id.progressBar2)

        val preferences = getSharedPreferences(dosyayolu, Context.MODE_PRIVATE)
        val editor = preferences.edit()

        val name = "Ahmet Durgut"
        val sifre = "02210201509"
        var ischeckname = false
        var ischecksifre=false
        Toast.makeText(applicationContext,
            "Kaydedilmiş \n " +
                    "isim : ${preferences.getString(anahtarisim, "Değer Yok")} \n " +
                    "sifre : ${preferences.getString(anahtarsifre,"Değer Yok")}\n " +
                    "Unutma : ${preferences.getBoolean(anahtarunutma,false)}", Toast.LENGTH_SHORT).show()

        switchbtn.setOnCheckedChangeListener { _, b ->
            Toast.makeText(applicationContext,"isim switch'inde",Toast.LENGTH_SHORT).show()
            if (b){
                editor.putString(anahtarisim,edittextisim.text.toString())
                editor.putString(anahtarsifre,edittextsifre.text.toString())
                editor.putBoolean(anahtarunutma,true)
                editor.apply()
                Toast.makeText(applicationContext,"isim kaydoldu",Toast.LENGTH_SHORT).show()
            }
            Handler().postDelayed({
                val intent=Intent(this@ikinciekran,ucuncusayfa::class.java)
                startActivity(intent)
                finish()
            },500)
        }



        edittextisim.addTextChangedListener {
            if (edittextisim.text.toString() == name) {
                ischeckname = true
                if (ischecksifre) {
                    progress.visibility = View.VISIBLE
                    switchbtn.setOnCheckedChangeListener { _, b ->
                        if (b){
                            editor.putString(anahtarisim,edittextisim.text.toString())
                            editor.putString(anahtarsifre,edittextsifre.text.toString())
                            editor.putBoolean(anahtarunutma,true)
                            editor.apply()
                            Toast.makeText(applicationContext,"isim kaydoldu",Toast.LENGTH_SHORT).show()
                        }
                        Handler().postDelayed({
                            val intent=Intent(this@ikinciekran,ucuncusayfa::class.java)
                            startActivity(intent)
                            finish()
                        },500)
                    }

                }
            }
        }
        edittextsifre.addTextChangedListener {
            if (edittextsifre.text.toString() == sifre) {
                ischecksifre = true
                if (ischeckname) {
                    progress.visibility = View.VISIBLE
                    switchbtn.setOnCheckedChangeListener { compoundButton, b ->
                        if (b){
                            editor.putString(anahtarisim,edittextisim.text.toString())
                            editor.putString(anahtarsifre,edittextsifre.text.toString())
                            editor.putBoolean(anahtarunutma,true)
                            editor.apply()
                            Toast.makeText(applicationContext,"sifre kaydoldu",Toast.LENGTH_SHORT).show()
                        }
                        Handler().postDelayed({
                            val intent=Intent(this@ikinciekran,ucuncusayfa::class.java)
                            startActivity(intent)
                            finish()
                        },500)
                    }


                }
            }
        }
    }
}