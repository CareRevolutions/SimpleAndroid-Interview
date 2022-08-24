package com.carerevolutions.myapplication.feature_country_subdivision.ui_components.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.carerevolutions.myapplication.databinding.ListRowBinding
import com.carerevolutions.myapplication.feature_country_subdivision.CountrySubdivision

/**
 * Pre-built adapter to be used if you prefer using a recycler or list view to complete this take home project.
 */
class CountrySubdivisionAdapter :
    ListAdapter<CountrySubdivision, ListRowViewHolder>(ItemDiffCallback()) {

    class ItemDiffCallback : DiffUtil.ItemCallback<CountrySubdivision>() {
        override fun areItemsTheSame(
            oldItem: CountrySubdivision,
            newItem: CountrySubdivision
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: CountrySubdivision,
            newItem: CountrySubdivision
        ): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRowViewHolder {
        val binding = ListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListRowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListRowViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ListRowViewHolder(private val binding: ListRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var item: CountrySubdivision? = null

    fun bind(facility: CountrySubdivision) {
        item = facility
        binding.label.text = facility.name
    }
}