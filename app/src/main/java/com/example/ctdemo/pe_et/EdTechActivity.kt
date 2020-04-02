package com.example.ctdemo.pe_et

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.clevertap.android.sdk.CTExperimentsListener
import com.example.ctdemo.MyApplication
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ActivityEdTechBinding
import java.util.*

class EdTechActivity : AppCompatActivity(), CTExperimentsListener {
    private lateinit var binding: ActivityEdTechBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ed_tech)

        MyApplication.getCleverTapDefaultInstance().ctExperimentsListener = this

        binding.img1.setOnClickListener {
            startLesson(1)
        }

        binding.img2.setOnClickListener {
            startLesson(2)
        }

        binding.img3.setOnClickListener {
            startLesson(3)
        }

        binding.img4.setOnClickListener {
            startLesson(4)
        }

        binding.img5.setOnClickListener {
            startLesson(5)
        }

        binding.img6.setOnClickListener {
            startLesson(6)
        }

        binding.ctaContinue.setOnClickListener {

            val courseProperties =
                HashMap<String, Any>()
            courseProperties["cta"] = true
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("lesson_selection", courseProperties)
            val intent = Intent(this, EtLessonActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson(day: Int) {

        val courseProperties =
            HashMap<String, Any>()
        courseProperties["day_selection"] = true
        courseProperties["lesson_no"] = day
//        MyApplication.getCleverTapDefaultInstance().pushEvent("lesson_selection", courseProperties)

        val intent = Intent(this, EtLessonActivity::class.java)
        startActivity(intent)
    }

    override fun CTExperimentsUpdated() {

    }
}
