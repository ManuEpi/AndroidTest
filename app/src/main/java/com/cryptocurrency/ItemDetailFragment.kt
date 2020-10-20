package com.cryptocurrency

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cryptocurrency.models.topMarket.Currency
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_detail.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment(R.layout.item_detail) {

    private var item: Currency? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {

                item = Gson().fromJson(it.getString(ARG_ITEM_ID), Currency::class.java)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        item?.let {

            if (it.coinInfo != null)
                rootView.findViewById<TextView>(R.id.idItem).text = " Id : ${it.coinInfo.id}"

            if (it.raw != null) {
                rootView.findViewById<TextView>(R.id.fromToSymbol).text =
                    "FromToSymbol : ${it.raw.eur.fromSymbol} -> ${it.raw.eur.toSymbol}"
                rootView.findViewById<TextView>(R.id.price).text =
                    "Price : ${it.raw.eur.price.toString()}"
                rootView.findViewById<TextView>(R.id.volumeDayTo).text =
                    "VolumeDayTo : ${it.raw.eur.volumeDayTo.toString()}"
                rootView.findViewById<TextView>(R.id.volume24HourTo).text =
                    "Volume24HourTo : ${it.raw.eur.volume24HourTo.toString()}"
            }
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_value"
    }
}