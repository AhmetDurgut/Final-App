package com.example.finalapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar=findViewById<SeekBar>(R.id.seekBar2)
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                seekBar.thumb.setTint(Color.parseColor("#0F4511"))
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                when(seekBar.progress){
                    15->{
                        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
                        progressBar.visibility=View.VISIBLE

                        object :CountDownTimer(1500,100){
                            override fun onTick(p0: Long) {
                                seekBar.progress=seekBar.progress-1
                            }

                            override fun onFinish() {
                                seekBar.progress=0
                                val intent= Intent(this@MainActivity,ikinciekran::class.java)
                                startActivity(intent)
                                finish()
                            }

                        }.start()
                    }
                    else->{
                        seekBar.progress=0
                    }
                }
            }

            })
        }
}