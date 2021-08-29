package com.adempolat.kpsspuanhesapla.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.adempolat.kpsspuanhesapla.ItemMenu
import com.adempolat.kpsspuanhesapla.R
import com.adempolat.kpsspuanhesapla.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private var listMenu : MutableList<ItemMenu>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        listMenu.let {
            it?.add(ItemMenu("KPSS Lisans", R.drawable.university))
            it?.add(ItemMenu("KPSS Ön Lisans", R.drawable.unitwo))
            it?.add(ItemMenu("KPSS Ortaöğretim", R.drawable.school))
            it?.add(ItemMenu("KPSS Din Hizmetleri", R.drawable.mosque))
            it?.add(ItemMenu("İletişim", R.drawable.chat))
            it?.add(ItemMenu("Sınav Tarihleri", R.drawable.schedule))
        }
        rv_item_menu.apply {
            adapter = MyAdapter(listMenu){
                val intent = Intent(this@DashboardActivity,LisansActivity().javaClass)
                startActivity(intent)
                Toast.makeText(applicationContext, it.title+" Clicked",Toast.LENGTH_SHORT).show()
            }
            layoutManager = GridLayoutManager(applicationContext, 2)
            hasFixedSize()
        }
    }
}