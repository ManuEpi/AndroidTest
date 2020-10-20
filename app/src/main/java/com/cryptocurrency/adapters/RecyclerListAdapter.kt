package com.cryptocurrency.adapters

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cryptocurrency.ItemDetailActivity
import com.cryptocurrency.ItemDetailFragment
import com.cryptocurrency.ItemListActivity
import com.cryptocurrency.R
import com.cryptocurrency.models.topMarket.Currency
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class RecyclerListAdapter @ExperimentalCoroutinesApi constructor(
    private val parentActivity: ItemListActivity,
    private val values: Array<Currency>,
    private val twoPane: Boolean
) :
    RecyclerView.Adapter<RecyclerListAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->

            if (twoPane) {
                val fragment = ItemDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(
                            ItemDetailFragment.ARG_ITEM_ID, Gson().toJson(
                                v.tag as Currency
                            )
                        )
                    }
                }
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit()
            } else {
                val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                    putExtra(
                        ItemDetailFragment.ARG_ITEM_ID, Gson().toJson(
                            v.tag as Currency
                        )
                    )
                }
                v.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = position.toString()

        item.coinInfo?.let {
            holder.contentView.text = "${it.fullName}"
        }

        item.raw?.let {
            holder.contentView.text =
                holder.contentView.text as String + " // From:${it.eur.fromSymbol} ->" +
                        " To:${it.eur.toSymbol} // ${it.eur.price} €"
        }

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.id_text)
        val contentView: TextView = view.findViewById(R.id.content)
    }

}