package com.example.finalapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SeekBar
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [rgb.newInstance] factory method to
 * create an instance of this fragment.
 */
class rgb : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_rgb, container, false)
        val framelayout=v.findViewById<FrameLayout>(R.id.framergbforcolor)
        val seekbarred=v.findViewById<SeekBar>(R.id.seekred)
        val seekbargreen=v.findViewById<SeekBar>(R.id.seekgreen)
        val seekbarblue=v.findViewById<SeekBar>(R.id.seekblue)
        var renktext=v.findViewById<TextView>(R.id.textView7)
        var redtext="00"
        var greentext="bc"
        var bluetext="d4"
        var textcolor:String
        seekbarred.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                framelayout.setBackgroundColor(Color.rgb(p1,greentext.toInt(16),bluetext.toInt(16)))
                redtext=decimalToHex(p1)
                textcolor= "#$redtext$greentext$bluetext"
                renktext.text=textcolor

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        seekbargreen.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                framelayout.setBackgroundColor(Color.rgb(redtext.toInt(16),p1,bluetext.toInt(16)))
                greentext=decimalToHex(p1)
                textcolor= "#$redtext$greentext$bluetext"
                renktext.text=textcolor
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        seekbarblue.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                framelayout.setBackgroundColor(Color.rgb(redtext.toInt(16),greentext.toInt(16),p1))
                bluetext=decimalToHex(p1)
                textcolor= "#$redtext$greentext$bluetext"
                renktext.text=textcolor

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })


        return v
    }

    fun decimalToHex(num: Int): String {
        if (num<16){
            return "0${num.toString(16)}"
        }
        else{
            return num.toString(16)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment rgb.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            rgb().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}