package com.example.ctdemo.nd_ott

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.clevertap.android.sdk.displayunits.DisplayUnitListener
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit
import com.example.ctdemo.MyApplication
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ActivityOtthomeBinding

class OTTHomeActivity : AppCompatActivity(), DisplayUnitListener {

    private lateinit var binding: ActivityOtthomeBinding

//    private val imagesComedy: ArrayList<CleverTapDisplayUnitContent> = ArrayList()
//
//    private val imagesHorror: ArrayList<CleverTapDisplayUnitContent> = ArrayList()
//
//    private lateinit var adapterStory: StoryAdapter

    private var images: ArrayList<String> = ArrayList()

    private lateinit var moviesAdapter: MoviesAdapter

    private lateinit var adapterRecommendation: RecommendationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otthome)

//        adapterStory = StoryAdapter(context = this, units = imagesComedy)

        val movies = listOf(
            "https://m.media-amazon.com/images/M/MV5BMTg0NTM3MTI1MF5BMl5BanBnXkFtZTgwMTAzNTAzNzE@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BZGFmZjQ0ZTYtNjNkOC00OTAxLTlmMWMtNThmMWRkMTcyODY0XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BMmUxNGVkZDgtMjE4Zi00NGZhLWI5ZjYtYzk5OTlkMjI5ZDQ5XkEyXkFqcGdeQXVyNTgxODY5ODI@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BMzkzMDc0Nzg5OF5BMl5BanBnXkFtZTcwMDU0MzAyOA@@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BNTE5MDA0NTk4MV5BMl5BanBnXkFtZTgwNTY1MDUyNTE@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BNjQ5MmJmYzYtODdjMi00N2RmLWFmYTItZjlhZDYyZjliYWVhXkEyXkFqcGdeQXRyYW5zY29kZS13b3JrZmxvdw@@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BMjE2N2U0NjUtZTViYy00NWJmLWIwNzYtNTYxMWQ5ZTZjNjZiXkEyXkFqcGdeQXVyMjUxMTY3ODM@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BODJmZmFiNzQtMDJiYS00ZTgzLTljZGMtNjEzNzM4NmEyYjNiXkEyXkFqcGdeQXVyNjE5MjUyOTM@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BNjYxMjI3MzY3NF5BMl5BanBnXkFtZTgwMTgyNzg3MDE@._V1_.jpg",
            "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@.jpg"
        )

        moviesAdapter = MoviesAdapter(this, movies)

//        binding.recyclerViewStory.adapter = adapterStory


        adapterRecommendation =
            RecommendationAdapter(context = this, units = images)

        binding.recyclerViewRecommendation.adapter = adapterRecommendation


//
//        adapterStory.onItemClick = { _ ->
//            //            MyApplication.getCleverTapDefaultInstance().pushDisplayUnitClickedEventForID(adUnit.getUnitID())
//
//            val intent = Intent(this, StoryViewActivity::class.java)
//            intent.putExtra("IMAGES", imagesComedy)
//            startActivity(intent)
//        }


        binding.recyclerViewMovies.adapter = moviesAdapter

//        MyApplication.getCleverTapDefaultInstance().setDisplayUnitListener(this)

//        MyApplication.getCleverTapDefaultInstance().pushEvent("OTT Native Display-Comedy")
//        MyApplication.getCleverTapDefaultInstance().pushEvent("OTT Native Display-Horror")

        loadRec()

    }

    override fun onDisplayUnitsLoaded(units: ArrayList<CleverTapDisplayUnit>?) {
//        for (i in 0 until units!!.size) {
//            val unit = units[i]
//            Log.d("Unit ID", unit.unitID)
//            if (unit.unitID.contains("1579678631")) {
//                loadStory(unit)
//            } else if (unit.unitID.contains("1579678855")) {
//                loadRecommendation(unit)
//            }
//        }
    }

//    private fun loadStory(unit: CleverTapDisplayUnit) {
//        binding.groupStories.visibility = View.VISIBLE
//        imagesComedy.clear()
//        imagesComedy.addAll(unit.contents)
//        adapterStory.notifyDataSetChanged()
//        MyApplication.getCleverTapDefaultInstance().pushDisplayUnitViewedEventForID(unit.unitID)
//    }

    fun loadRec() {

        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {

                assets.list("hindi")?.let { images.addAll(it) }


                binding.groupRec.visibility = View.VISIBLE

                adapterRecommendation.notifyDataSetChanged()

            }
        }
        timer.start()

//        MyApplication.getCleverTapDefaultInstance().pushDisplayUnitViewedEventForID(unit.unitID)
    }

//    private fun loadRecommendation(unit: CleverTapDisplayUnit) {
//        binding.groupRec.visibility = View.VISIBLE
//        imagesHorror.clear()
//        imagesHorror.addAll(unit.contents)
//        adapterRecommendation.notifyDataSetChanged()
//        MyApplication.getCleverTapDefaultInstance().pushDisplayUnitViewedEventForID(unit.unitID)
//    }
}
