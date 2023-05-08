package com.example.finalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [snackBar.newInstance] factory method to
 * create an instance of this fragment.
 */
class snackBar : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_snack_bar, container, false)
        val edittextmesaj=v.findViewById<EditText>(R.id.editTextMesaj)
        val edittextaction=v.findViewById<EditText>(R.id.editTextAction)
        val spinner=v.findViewById<Spinner>(R.id.spinner)
        val sureler= arrayOf("Süre Seçiniz","2 sn","2.5 sn","3 sn","3.5 sn","4 sn")
        val adapter=ArrayAdapter(requireActivity(),android.R.layout.simple_dropdown_item_1line,sureler)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter=adapter

        edittextmesaj.addTextChangedListener {
            if ( edittextmesaj.text.toString()!="" &&edittextaction.text.toString()!=""){
                spinner.onItemSelectedListener=object:
                    AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?,p1: View?, p2: Int, p3: Long) {
                        when(p0?.getItemAtPosition(p2)){
                            "2 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),2000).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "2.5 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),2500).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "3 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),3000).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "3.5 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),3500).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "4 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),4000).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                        }
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }

                }
            }
        }
        edittextaction.addTextChangedListener {
            if ( edittextmesaj.text.toString()!="" &&edittextaction.text.toString()!=""){
                spinner.onItemSelectedListener=object:
                    AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?,p1: View?, p2: Int, p3: Long) {
                        when(p0?.getItemAtPosition(p2)){
                            "2 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),2000).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "2.5 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),2500).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "3 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),3000).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "3.5 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),3500).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                            "4 sn"->{
                                Snackbar.make(view!!,edittextmesaj.text.toString(),4000).setAction(edittextaction.text.toString()){
                                    Toast.makeText(context,edittextaction.text.toString(),Toast.LENGTH_SHORT).show()
                                }.show()
                            }
                        }
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }

                }
            }

        }


        return v
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment snackBar.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            snackBar().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}