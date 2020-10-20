package com.cryptocurrency

import android.R.attr.delay
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.cryptocurrency.adapters.RecyclerListAdapter
import com.cryptocurrency.utils.Constants
import com.cryptocurrency.viewModels.CurrencyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.math.absoluteValue
import kotlin.math.log


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ItemListActivity : AppCompatActivity() {

    private val currencyViewModel: CurrencyViewModel by viewModels()
    private var twoPane: Boolean = false
    var handler = Handler()
    var runnable: Runnable? = null
    private var recyclerViewAdapter: RecyclerListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        currencyViewModel.topMarketCurrencies.observe(
            this,
            Observer {
                if (progressBar.visibility == View.VISIBLE)
                    progressBar.visibility = View.GONE
                setupRecyclerView()
            })

        currencyViewModel.getTopMarketCurrencies("EUR", 20)

        if (findViewById<NestedScrollView>(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        pollingServer()
    }

    override fun onPause() {

        if (runnable != null)
            handler.removeCallbacks(runnable!!)
        super.onPause()
    }

    private fun pollingServer() {

        handler.postDelayed(Runnable {
            currencyViewModel.getTopMarketCurrencies("EUR", 20)
            setupRecyclerView()
            pollingServer()
        }.also { runnable = it }, Constants.TWO_MINUTES.absoluteValue.toLong())
    }

    private fun setupRecyclerView() {
        recyclerViewAdapter = currencyViewModel.topMarketCurrencies.value?.currencies?.let {
            RecyclerListAdapter(
                this,
                it, twoPane
            )
        }
        item_list.adapter = recyclerViewAdapter
    }
}