package com.example.ctdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.clevertap.android.sdk.InAppNotificationButtonListener
import com.example.ctdemo.databinding.ActivityInAppBinding
import java.util.*

class InAppActivity : AppCompatActivity(), InAppNotificationButtonListener {

    private lateinit var binding: ActivityInAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_in_app)
//
//        MyApplication.getCleverTapDefaultInstance().setInAppNotificationButtonListener(this)
//
//        binding.buttonAlert.setOnClickListener {
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("In App Alert")
//        }
//
//        binding.buttonCover.setOnClickListener {
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("In App Cover")
//        }
//
//        binding.buttonCustomHtml.setOnClickListener {
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("In App Custom HTML-1")
//        }
//
//        binding.buttonFooter.setOnClickListener {
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("In App Footer")
//        }
//
//        binding.buttonHalfInterstitial.setOnClickListener {
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("In App Half Interstitial")
//        }
//
//        binding.buttonInterstitial.setOnClickListener {
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("In App Interstitial")
//        }
//
//        binding.buttonHeader.setOnClickListener {
//            MyApplication.getCleverTapDefaultInstance()
//                .pushEvent("In App Header")
//        }
    }

    override fun onInAppButtonClick(payload: HashMap<String, String>?) {

    }
}
