package com.example.custum_sell_prodect

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class adapter_rec(private var ar: ArrayList<String>, private val carphoto: ArrayList<Int>): RecyclerView.Adapter<adapter_rec.listViewHolder>(), Filterable {
    var  newar = ar
    class listViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tit4: TextView = v.findViewById(R.id.textView4)
        val tit3: TextView = v.findViewById(R.id.textView3)
        val tit2: TextView = v.findViewById(R.id.textView2)
        val titl: TextView = v.findViewById(R.id.textView)
        val likebtn: ImageButton = v.findViewById(R.id.imageButton3)
        val img: ImageView = v.findViewById(R.id.imageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.list_disgn, null, false)
        val vh = listViewHolder(inflatedView)
        return vh
    }
    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        holder.tit3.setText(ar.get(position))
        holder.tit2.setText("$position")
        holder.titl.setText("${position + 1}")
        holder.tit4.setText("LoRa is a low-power wide-area network protocol developed by Semtech. " +
                " spectrum technology. It was developed by Cycleo of Grenoble,")

        var newindex = ar.indexOf(newar.get(position))
        holder.img.setImageResource(carphoto[newindex])

        holder.tit3.text = newar[position]

        holder.likebtn.setOnClickListener {
            holder.likebtn.setImageResource(R.drawable.ic_baseline_thumb_up_24)
        }

        holder.tit2.setCompoundDrawablesWithIntrinsicBounds(
                0, 0, R.drawable.ic_baseline_photo_library_24, 0)
        holder.titl.setCompoundDrawablesWithIntrinsicBounds(
                0, 0, R.drawable.ic_baseline_comment_24, 0)
    }
    override fun getItemCount(): Int {
        return newar.size
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    newar = ar
                } else {
                    val resultList = ArrayList<String>()
                    for (row in ar) {
                        if (row.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    newar = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = newar
                return filterResults
            }
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                newar = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }
        }
    }
}
