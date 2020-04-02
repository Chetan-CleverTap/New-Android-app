package com.example.ctdemo.nd_ott

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bolaware.viewstimerstory.Momentz
import com.bolaware.viewstimerstory.MomentzCallback
import com.bolaware.viewstimerstory.MomentzView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent
import com.example.ctdemo.R
import com.example.ctdemo.databinding.ActivityStoryViewBinding
import com.example.ctdemo.databinding.StoryBgBinding

class StoryViewActivity : AppCompatActivity(), MomentzCallback {

    private lateinit var binding: ActivityStoryViewBinding
    private val images: ArrayList<CleverTapDisplayUnitContent> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_story_view)

        images.addAll(intent.getSerializableExtra("IMAGES") as ArrayList<CleverTapDisplayUnitContent>)

        val listOfViews = ArrayList<MomentzView>()

        for (image in images) {
            val imageView = ImageView(this)

            listOfViews.add(MomentzView(imageView, 3))
        }


        val storyBinding: StoryBgBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(this),
                R.layout.story_bg,
                binding.root as ViewGroup,
                true
            )

        Momentz(this, listOfViews, storyBinding.root as ViewGroup, this).start()
    }

    override fun done() {
        finish()
    }

    override fun onNextCalled(view: View, momentz: Momentz, index: Int) {

        momentz.pause(true)
        if (!isDestroyed)
            Glide.with(this)
                .load(images[index].media)
                .fitCenter()
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {

                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {

                        momentz.resume()
                        return false
                    }
                })
                .into(view as ImageView)
    }
}
