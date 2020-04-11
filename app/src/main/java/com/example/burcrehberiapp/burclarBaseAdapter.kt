package com.example.burcrehberiapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir_layout.view.*

class burclarBaseAdapter(context: Context,tumBurcBilgileri:ArrayList<burc>) : BaseAdapter() {

    var tumBurclar:ArrayList<burc>
    var context:Context

    init{
        tumBurclar = tumBurcBilgileri
        this.context = context

    }

    //her eleman olusturulrken tetiklenen method
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var tekSatırView = convertView
        var viewHolder : ViewHolder2

        if(tekSatırView == null){ // ilk defa olusturuluyorsa
            var inflater = LayoutInflater.from(context)
            tekSatırView = inflater.inflate(R.layout.tek_satir_layout,parent,false)


            viewHolder = ViewHolder2(tekSatırView)

        }else{

            viewHolder = ViewHolder2(tekSatırView)
        }


        viewHolder.burcResim!!.imgTekSatır.setImageResource(tumBurclar.get(position).burcIcon)
        viewHolder.burcAdı!!.txtBurcAdı.setText(tumBurclar.get(position).burcAdı)
        viewHolder.burcTarih!!.txtViewBurcTarihi.setText(tumBurclar.get(position).burcTarih)


        return tekSatırView!!
    }

    override fun getItem(position: Int): Any {
        return tumBurclar.get(position)
    }

    override fun getItemId(position: Int): Long {

        return 0
    }

    override fun getCount(): Int {

        return tumBurclar.size
    }
}


class ViewHolder2(tekSatırLayout:View){
    var burcResim:ImageView
    var burcAdı:TextView
    var burcTarih:TextView



    init{
        burcResim = tekSatırLayout.imgTekSatır
        burcAdı = tekSatırLayout.txtBurcAdı
        burcTarih = tekSatırLayout.txtViewBurcTarihi
    }
}