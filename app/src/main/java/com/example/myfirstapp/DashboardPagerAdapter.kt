package com.example.myfirstapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DashboardPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Daftar fragment yang akan ditampilkan dalam ViewPager2
    private val fragments = listOf(
        BeritaFragment(),       // Fragment pertama
        PengumumanFragment()    // Fragment kedua
    )

    // Menentukan jumlah fragment yang ada
    override fun getItemCount(): Int = fragments.size

    // Membuat fragment berdasarkan posisi
    override fun createFragment(position: Int): Fragment = fragments[position]
}
