package com.example.burcrehberiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var tumBurcbilgierli:ArrayList<burc>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.statusBarColor)

        veriKaynagıHazırla()


        var myBaseAdapter = burclarBaseAdapter(this,tumBurcbilgierli)

        listBurclar.adapter = myBaseAdapter


        listBurclar.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,activity_burcDetay::class.java)
            intent.putExtra("position",position)
            intent.putExtra("tumBurcBilgileri",tumBurcbilgierli)
            startActivity(intent)

        }



    }

    private fun veriKaynagıHazırla() {

        tumBurcbilgierli = ArrayList<burc>(12)

        var burclar = resources.getStringArray(R.array.burclar)
        var burcTarihleri = resources.getStringArray(R.array.burcTarihleri)
        var burcSembolleri = arrayOf(R.drawable.koc1,R.drawable.boga2,R.drawable.ikizler3,R.drawable.yengec4,R.drawable.aslan5,
            R.drawable.basak6,R.drawable.terazi7,R.drawable.akrep8,R.drawable.yay9,R.drawable.oglak10,R.drawable.kova11,
            R.drawable.balik12)

        var burcBuyukResimler = arrayOf(R.drawable.koc_buyuk1,R.drawable.boga_buyuk2,R.drawable.ikizler_buyuk3,R.drawable.yengec_buyuk4,
            R.drawable.aslan_buyuk5,R.drawable.basak_buyuk6,R.drawable.terazi_buyuk7,R.drawable.akrep_buyuk8,R.drawable.yay_buyuk9,
            R.drawable.oglak_buyuk10,R.drawable.kova_buyuk11,R.drawable.balik_buyuk12)

        var genelOzellikler = resources.getStringArray(R.array.burcGenelOzellikler)

        for(i in 0..11){
            var gecici:burc = burc(burclar[i],burcTarihleri[i],burcSembolleri[i],burcBuyukResimler[i],genelOzellikler[i])
            tumBurcbilgierli.add(gecici)
        }

    }
}
