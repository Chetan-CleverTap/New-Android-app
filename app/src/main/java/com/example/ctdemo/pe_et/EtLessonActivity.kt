package com.example.ctdemo.pe_et

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ctdemo.MyApplication
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ActivityEtLessonBinding
import java.util.*

class EtLessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEtLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_et_lesson)

        binding.button1.setOnClickListener {
            sendEvent(binding.button1.text.trim())
        }

        binding.button2.setOnClickListener {
            sendEvent(binding.button1.text.trim())
        }

        binding.button3.setOnClickListener {
            sendEvent(binding.button1.text.trim())
        }

        binding.button4.setOnClickListener {
            sendEvent(binding.button1.text.trim())
        }
    }

    private fun sendEvent(trim: CharSequence) {
        val courseProperties =
            HashMap<String, Any>()
        courseProperties["selection"] = trim
//        MyApplication.getCleverTapDefaultInstance().pushEvent("answer_picked", courseProperties)

    }
}
