package com.example.a5b_1m_1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.a5b_1m_1.R
import com.example.a5b_1m_1.model.Page

class PageAdapter(var context: Context, var item: ArrayList<Page>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        return item.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return Pageholder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var pages: Page = item[position]

        if (holder is Pageholder) {
            var lottie: LottieAnimationView = holder.lottie
            var title: TextView = holder.title
            var abaut: TextView = holder.abaut



            lottie.setAnimation(pages.itemlottie)
            title.text = pages.itemtitle
            abaut.text = pages.itemabaut


        }
    }

    class Pageholder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var lottie: LottieAnimationView
        var title: TextView
        var abaut: TextView

        init {
            lottie = itemview.findViewById(R.id.lotti)
            title = itemview.findViewById(R.id.text_title)
            abaut = itemview.findViewById(R.id.txt_abaut)
        }
    }
}