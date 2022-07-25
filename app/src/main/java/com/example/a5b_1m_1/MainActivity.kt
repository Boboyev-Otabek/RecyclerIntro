package com.example.a5b_1m_1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.a5b_1m_1.adapter.PageAdapter
import com.example.a5b_1m_1.model.Page
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        refreshAdapter(recyclerView, getAllPage())

        var snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)


        val indicator: ScrollingPagerIndicator = findViewById(R.id.indicator)
        indicator.attachToRecyclerView(recyclerView)


        val mLayoutManager: LinearLayoutManager
        mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setLayoutManager(mLayoutManager)

        var skip: TextView = findViewById(R.id.skip)
        var started: TextView = findViewById(R.id.started)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var position = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                position = mLayoutManager.findFirstVisibleItemPosition()

                Log.d("@@@", "" + position)

                if (position != 2) {
                    skip.visibility = View.VISIBLE
                    started.visibility = View.GONE
                } else {
                    skip.visibility = View.GONE
                    started.visibility = View.VISIBLE
                }
                skip.setOnClickListener {
                    if (position != 2) {
                        recyclerView.scrollToPosition(position + 1)
                    } else {
                        recyclerView.scrollToPosition(position)
                    }
                }
            }
        })
    }

    fun refreshAdapter(recyclerView: RecyclerView, page: ArrayList<Page>) {

        var adapter = PageAdapter(this, page)
        recyclerView.adapter = adapter
    }

    fun getAllPage(): ArrayList<Page> {
        var pages = ArrayList<Page>()

        pages.add(
            Page(
                "a0.json",
                "  Say Hello to \nGlobal Top-Up",
                "Send mobile  top-up tomore than 500 networks     \n " +
                        "                        in over 140 countries"

            )
        )


        pages.add(
            Page(
                "a1.json",
                "Safe, Trusted & \n   Fully Secure ",
                "Encrypted transactions mean  your  payments & \n                       Privacy and protected"
            )
        )


        pages.add(
            Page(
                "a2.json",
                "Easy to Use",
                "Pick a number , choose an amount, send your \n                             Top-up. Simple"
            )
        )

        return pages
    }
}