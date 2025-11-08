package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_dashboard.xml
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Menghubungkan ViewPager2 dan TabLayout
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)

        // Membuat instance adapter untuk ViewPager2
        val adapter = DashboardPagerAdapter(requireActivity())
        viewPager.adapter = adapter

        // Menghubungkan TabLayout dan ViewPager2 dengan TabLayoutMediator
        val tabTitles = arrayOf("Berita", "Pengumuman")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        return view
    }
}