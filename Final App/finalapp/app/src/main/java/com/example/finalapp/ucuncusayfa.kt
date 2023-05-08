package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment

class ucuncusayfa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ucuncusayfa)

        var menubtn=findViewById<Button>(R.id.buttun)
        menubtn.setOnClickListener {
            var acilirmenu=PopupMenu(this@ucuncusayfa,menubtn)
            acilirmenu.menuInflater.inflate(R.menu.popupmenu,acilirmenu.menu)
            acilirmenu.setOnMenuItemClickListener {i->
                when(i.itemId){
                    R.id.rgb->{
                        fragmentcagir(rgb())
                        true
                    }
                    R.id.snackbar->{
                        fragmentcagir(snackBar())
                        true
                    }
                    R.id.cikis->{
                        //alert cağır
                        //direk taasarımı burayla birleştiricem
                        val tasarim=layoutInflater.inflate(R.layout.cikis,null)
                        val isim=tasarim.findViewById<EditText>(R.id.isim)
                        val sifre=tasarim.findViewById<EditText>(R.id.sifre)
                        val progressexit=tasarim.findViewById<ProgressBar>(R.id.progressBar3)
                        val ad=AlertDialog.Builder(this@ucuncusayfa)
                        ad.setView(tasarim)
                        val name="Ahmet Durgut"
                        val password="02210201509"
                        var ischeck1=false
                        var ischeck2=false
                        isim.addTextChangedListener {
                            if (isim.text.toString()==name){
                                ischeck1=true
                                if (ischeck2){
                                    progressexit.visibility=View.VISIBLE
                                }

                            }
                        }
                        sifre.addTextChangedListener {
                            if (sifre.text.toString()==password){
                                ischeck2=true
                                if (ischeck1){
                                    progressexit.visibility=View.VISIBLE
                                }
                            }
                        }

                        if(ischeck1 == true && ischeck2 == true){
                            Handler().postDelayed({
                                var gecis = Intent(this,ikinciekran::class.java)
                                startActivity(gecis)
                                finish()
                            },3000)
                        }

                        ad.create().show()
                        true
                    }
                    else->{
                        fragmentcagir(ilk())
                        true
                    }
                }
            }
            acilirmenu.show()
        }
    }

    fun fragmentcagir(fragment: Fragment){
        var gecis=supportFragmentManager.beginTransaction()
        gecis.replace(R.id.fragmentContainerView2,fragment)
        gecis.commit()
    }
}