package com.example.Macro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ArtikelYolaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtikelYolaBinding
    private lateinit var ArtikelFragment: ArtikelFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtikelYolaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when(position){
                    0 -> tab.text = "For You Fragment"
                    1 -> tab.text = "Recomendation Fragment"
                    2 -> tab.text = "Treding Fragment"
                }
            }.attach()
                    }
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}