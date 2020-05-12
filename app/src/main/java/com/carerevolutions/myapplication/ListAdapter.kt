package com.carerevolutions.myapplication

import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(var items: List<CountrySubdivision>, val context: Context): BaseAdapter() {

    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = items[position]
        val view: View
        val holder: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.list_row, parent, false)
            holder = ItemHolder()
            holder.label = view.findViewById(R.id.label)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ItemHolder
        }
        holder.label.text = item.toString()
        return view
    }

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private class ItemHolder {
        lateinit var label: TextView
    }
}
