package com.howard.countriesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.howard.countriesapp.data.model.CountriesModelItemModel
import com.howard.countriesapp.databinding.ListItemCountryBinding

class CountriesAdapter(
    private val countryList: MutableList<CountriesModelItemModel> = mutableListOf()
) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    fun updateCountries(newCountries: List<CountriesModelItemModel>) {
        countryList.clear()
        countryList.addAll(newCountries)
        notifyDataSetChanged()
    }

    inner class CountriesViewHolder(private val binding: ListItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setup(countriesModelItemModel: CountriesModelItemModel) {
            binding.tvCountryNameRegion.text =
                "${countriesModelItemModel.name}, ${countriesModelItemModel.region}"
            binding.tvCountryCode.text = "${countriesModelItemModel.code}"
            binding.tvCountryCapital.text = "${countriesModelItemModel.capital}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountriesViewHolder(

        ListItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = countryList.size

    override fun onBindViewHolder(holder: CountriesAdapter.CountriesViewHolder, position: Int) {
        holder.setup(countryList[position])
    }
}