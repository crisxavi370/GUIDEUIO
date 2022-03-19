package com.example.adoptame.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.adoptame.R
import com.example.adoptame.model.OnBoarding


class Adapter_OnBoarding(private var context:Context, private var onBoardingList: List<OnBoarding>): PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as View
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_design, null)
        val imageView: ImageView
        val title: TextView
        val desc: TextView

        imageView = view.findViewById(R.id.imageView)
        title = view.findViewById(R.id.title)
        desc = view.findViewById(R.id.desc)

        imageView.setImageResource(onBoardingList[position].imageUrl)
        title.text = onBoardingList[position].title
        desc.text = onBoardingList[position].desc

        container.addView(view)
        return view
    }

}