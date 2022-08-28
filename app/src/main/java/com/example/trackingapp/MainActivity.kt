package com.example.trackingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.trackingapp.Adapters.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var frag1: Fragment
    private lateinit var frag2: Fragment
    private lateinit var frag3: Fragment
    private lateinit var fragments: ArrayList<Fragment>
    private lateinit var fragStateAdapter: FragmentStateAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabConfigurationStrategy: TabLayoutMediator.TabConfigurationStrategy
    private lateinit var tabLayoutMediator: TabLayoutMediator
    private val tabItems = arrayOf("Start", "History", "Settings")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById<ViewPager2>(R.id.viewPager)
        frag1 = StartFragment()
        frag2 = HistoryFragment()
        frag3 = SettingsFragment()

        //ArrayList of fragments
        fragments.add(frag1)
        fragments.add(frag2)
        fragments.add(frag3)

        //fragment adapter
        fragStateAdapter = FragmentAdapter(this, fragments)
        viewPager.adapter = fragStateAdapter

        //setup tab configuration
        tabConfigurationStrategy = TabLayoutMediator.TabConfigurationStrategy() {
                tab: TabLayout.Tab, position: Int->
            tab.text = tabItems[position]
        }
        
        //attaching viewpager, tabLayout and configurationStrategy using tabLayoutMediator
        tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager, tabConfigurationStrategy)
        tabLayoutMediator.attach()
    }
}