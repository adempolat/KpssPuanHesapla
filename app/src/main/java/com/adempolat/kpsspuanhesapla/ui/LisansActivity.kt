package com.adempolat.kpsspuanhesapla.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.adempolat.kpsspuanhesapla.Calculation
import com.adempolat.kpsspuanhesapla.R
import com.adempolat.kpsspuanhesapla.databinding.ActivityMainBinding


class LisansActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    var status = "memur"
    var itemStatus: String = "Türkçe"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val spinners: Array<String> = resources.getStringArray(R.array.ders_list)

        binding.spLisansOabt.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinners)
        binding.cbMemur.setOnClickListener { if (binding.cbMemur.isChecked) checkedMemur() }
        binding.cbOgretmen.setOnClickListener { if (binding.cbOgretmen.isChecked) checkedOgretmen() }
        binding.cbOabt.setOnClickListener { if (binding.cbOabt.isChecked) checkedOABT() }
        binding.btnLisansHesapla.setOnClickListener { hesaplaLisans() }

    }

    private fun checkedMemur(){
        binding.cbOgretmen.isChecked = false
        binding.cbOabt.isChecked = false
        binding.llEgitimBilimleri.visibility = View.GONE
        binding.llOabt.visibility = View.GONE
        status = "memur"
    }

    private fun checkedOgretmen(){
        binding.cbMemur.isChecked = false
        binding.cbOabt.isChecked = false
        binding.llEgitimBilimleri.visibility = View.VISIBLE
        binding.llOabt.visibility = View.GONE
        status = "ogretmen"
    }

    private fun checkedOABT(){
        binding.cbMemur.isChecked = false
        binding.cbOgretmen.isChecked = false
        binding.llEgitimBilimleri.visibility = View.VISIBLE
        binding.llOabt.visibility = View.VISIBLE
        status = "oabt"
    }

    private fun hesaplaLisans(){
        if (binding.etDogruGk.text.isEmpty() || binding.etDogruGy.text.isEmpty()) {
            Toast.makeText(this, "Fill in the required fields", Toast.LENGTH_SHORT).show()
        } else {

            var dogruGK = binding.etDogruGk.text.toString().toInt()
            val yanlisGK = binding.etYanlisGk.text.toString().toInt()
            val dogruGY = binding.etDogruGy.text.toString().toInt()
            val yanlisGY = binding.etYanlisGy.text.toString().toInt()

            // status control
            if (status.equals("memur")) {
                val kpssP1 = Calculation().lisansForMemur(dogruGK, yanlisGK, dogruGY, yanlisGY)
                Toast.makeText(this, "KPSS P1: $kpssP1", Toast.LENGTH_SHORT).show()
            }
            if (status.equals("ogretmen")) {
                if (binding.edtLisansEbTrue.text.isEmpty() || binding.edtLisansEbFalse.text.isEmpty()) {
                    Toast.makeText(this, "Fill in the required fields", Toast.LENGTH_SHORT).show()
                } else {
                    val eb_dogru = binding.edtLisansEbTrue.text.toString().toInt()
                    val eb_yanlis = binding.edtLisansEbFalse.text.toString().toInt()
                    val p10_puan = Calculation().lisansForOgretmen(dogruGK, yanlisGK, dogruGY, yanlisGY, eb_dogru, eb_yanlis)
                    Toast.makeText(this, "P10 PUAN: " + p10_puan, Toast.LENGTH_SHORT).show()
                }
            }
            if (status.equals("oabt")) {
                if (binding.edtLisansEbTrue.text.isEmpty() || binding.edtLisansEbFalse.text.isEmpty() ||
                    binding.edtLisansOabtTrue.text.isEmpty() || binding.edtLisansOabtFalse.text.isEmpty()
                ) {
                    Toast.makeText(this, "Fill in the required fields", Toast.LENGTH_SHORT).show()
                } else {
                    val eb_dogru = binding.edtLisansEbTrue.text.toString().toInt()
                    val eb_yanlis = binding.edtLisansEbFalse.text.toString().toInt()
                    val a_dogru = binding.edtLisansOabtTrue.text.toString().toInt()
                    val a_yanlis = binding.edtLisansOabtFalse.text.toString().toInt()
                    binding.spLisansOabt.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                                itemStatus = spinners.get(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                Toast.makeText(applicationContext,"Please select one item", Toast.LENGTH_SHORT).show()
                            }
                        }
                    val p121_puan = Calculation().lisansForOabt(dogruGK, yanlisGK, dogruGY, yanlisGY, eb_dogru, eb_yanlis, a_dogru, a_yanlis, itemStatus)
                    Toast.makeText(applicationContext,"P121 PUAN: " + p121_puan, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}