package com.uniq.lostmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container_view_tag, MarketFragment())
            .commit()

        btn_market.setOnClickListener {
            if (supportFragmentManager.findFragmentById(R.id.fragment_container_view_tag) !is MarketFragment) {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container_view_tag, MarketFragment())
                    .commit()
            }
        }

        btn_auction.setOnClickListener {
            if (supportFragmentManager.findFragmentById(R.id.fragment_container_view_tag) !is AuctionFragment) {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container_view_tag, AuctionFragment())
                    .commit()
            }
        }
    }
}