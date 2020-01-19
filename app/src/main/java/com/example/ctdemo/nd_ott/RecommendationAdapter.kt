package com.example.ctdemo.nd_ott

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ItemRecommendationBinding

class RecommendationAdapter(
    val context: OTTHomeActivity,
    private val units: ArrayList<CleverTapDisplayUnitContent>
) : RecyclerView.Adapter<RecommendationAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemRecommendationBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_recommendation,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return units.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(context, position, units[position])
    }

    class MyViewHolder(var binding: ItemRecommendationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: OTTHomeActivity, position: Int, unit: CleverTapDisplayUnitContent) {

            Glide.with(context)
                .load(unit.media)
                .centerCrop()
                .into(binding.imageRec)

            binding.textRec.text = unit.title
        }
    }
}