package com.example.ctdemo.nd_ott

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ItemStoryBinding

class StoryAdapter(
    val context: OTTHomeActivity,
    private val units: ArrayList<CleverTapDisplayUnitContent>
) : RecyclerView.Adapter<StoryAdapter.MyViewHolder>() {

    var onItemClick: ((CleverTapDisplayUnitContent) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemStoryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_story,
            parent,
            false
        )
        return MyViewHolder(binding, onItemClick)
    }

    override fun getItemCount(): Int {
        return units.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(context, position, units[position])
    }

    class MyViewHolder(
        val binding: ItemStoryBinding,
        private val onItemClick: ((CleverTapDisplayUnitContent) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(context: OTTHomeActivity, position: Int, unit: CleverTapDisplayUnitContent) {

            Glide.with(context)
                .load(unit.media)
                .fitCenter()
                .into(binding.imageStory)

            binding.tvName.text = unit.title

            itemView.setOnClickListener {
                onItemClick?.invoke(unit)
            }
        }
    }
}