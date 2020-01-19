package com.example.ctdemo.nd_ott

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.clevertap.android.sdk.displayunits.DisplayUnitListener
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent
import com.example.ctdemo.MyApplication
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ActivityOtthomeBinding

class OTTHomeActivity : AppCompatActivity(), DisplayUnitListener {

    private lateinit var binding: ActivityOtthomeBinding

    private val images: ArrayList<CleverTapDisplayUnitContent> = ArrayList()

    private lateinit var adapterStory: StoryAdapter

    private lateinit var adapterRecommendation: RecommendationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otthome)

        adapterStory = StoryAdapter(context = this, units = images)

        adapterRecommendation = RecommendationAdapter(context = this, units = images)

        binding.recyclerViewStory.adapter = adapterStory

        adapterStory.onItemClick = { _ ->
            val intent = Intent(this, StoryViewActivity::class.java)
            intent.putExtra("IMAGES", images)
            startActivity(intent)
        }

        binding.recyclerViewRecommendation.adapter = adapterRecommendation

        MyApplication.getCleverTapDefaultInstance().setDisplayUnitListener(this)

        MyApplication.getCleverTapDefaultInstance().pushEvent("Native Display")

    }

    override fun onDisplayUnitsLoaded(units: ArrayList<CleverTapDisplayUnit>?) {
        for (i in 0 until units!!.size) {
            val unit = units[i]
            Log.d("Unit ID", unit.unitID)
            prepareDisplayView(unit)
        }
    }

    private fun prepareDisplayView(unit: CleverTapDisplayUnit) {
        binding.groupRec.visibility = View.VISIBLE
        binding.groupStories.visibility = View.VISIBLE

        images.clear()
        images.addAll(unit.contents)
        adapterStory.notifyDataSetChanged()
        adapterRecommendation.notifyDataSetChanged()

    }
}
