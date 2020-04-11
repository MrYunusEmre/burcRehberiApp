package com.example.burcrehberiapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_burc_detay.*

class activity_burcDetay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burc_detay)

        var position = intent.extras?.get("position") as Int
        var tumBurcBilgileri = intent.extras?.get("tumBurcBilgileri") as ArrayList<burc>

        txtBurcOzellikleri.setText(tumBurcBilgileri.get(position).burcGenelOzellklerı)
        header.setImageResource(tumBurcBilgileri.get(position).burcBuyukResim)

        setSupportActionBar(anim_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = tumBurcBilgileri.get(position).burcAdı

        var bitmap = BitmapFactory.decodeResource(resources,tumBurcBilgileri.get(position).burcBuyukResim)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {
                var color = palette?.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color!!)

                window.statusBarColor = color!!
            }

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
