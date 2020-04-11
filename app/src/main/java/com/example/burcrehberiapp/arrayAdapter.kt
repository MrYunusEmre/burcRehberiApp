package com.example.burcrehberiapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir_layout.view.*
import java.util.zip.Inflater

class arrayAdapter(
    var gelenContext: Context, resource: Int, textViewResourceId: Int, var burcAdları: Array<String>, var burcTarihleri : Array<String>,
    var burcResimleri : Array<Int>) : ArrayAdapter<String>(gelenContext, resource, textViewResourceId, burcAdları) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tekSatırView = convertView
        var viewHolder :ViewHolder? = null

        if(tekSatırView == null){
            var inflater = LayoutInflater.from(gelenContext)
            tekSatırView = inflater.inflate(R.layout.tek_satir_layout,parent,false)

            viewHolder = ViewHolder(tekSatırView)

            tekSatırView.tag = viewHolder


            Log.e("Yunus","Yapıldı : " + burcAdları[position])
        }else{

            viewHolder = tekSatırView.getTag() as ViewHolder
        }


        viewHolder?.burcResim!!.setImageResource(burcResimleri[position])
        viewHolder?.burcAdı!!.setText(burcAdları[position])
        viewHolder?.burcTarih!!.setText(burcTarihleri[position])


        return tekSatırView!!

    }

    class ViewHolder(tekSatırView : View){
        var burcResim:ImageView
        var burcAdı:TextView
        var burcTarih:TextView

            init{
                this.burcAdı = tekSatırView.txtBurcAdı
                this.burcResim = tekSatırView.imgTekSatır
                this.burcTarih = tekSatırView.txtViewBurcTarihi
            }


    }


}