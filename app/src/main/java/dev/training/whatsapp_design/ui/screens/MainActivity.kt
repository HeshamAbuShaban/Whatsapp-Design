package dev.training.whatsapp_design.ui.screens

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dev.training.whatsapp_design.R
import dev.training.whatsapp_design.adapters.ViewPagerAdapter
import dev.training.whatsapp_design.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewPagerAdapter: ViewPagerAdapter

    //    private late-init var navC: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

//        navC = findNavController(R.id.nav_host_fragment_container)
        /*setBNWithNavC()*/
        init()
    }

    /*private fun setBNWithNavC() {
        with(binding) {
            bNav.setupWithNavController(navC)
        }
    }*/

    private fun init() {
        setupViewPager()
        setupTabLayout()
    }

    private fun setupViewPager() {
        with(binding.vpFragChanger) {
            adapter = viewPagerAdapter
            setCurrentItem(1, false)
        }
    }

    private fun setupTabLayout() {
        TabLayoutMediator(
            binding.tabLFragSelector, binding.vpFragChanger
        ) { tab, position ->

            when (position) {
                0 -> tab.icon = AppCompatResources.getDrawable(baseContext, R.drawable.ic_group)
                1 -> tab.text = getString(R.string.chats)
                2 -> tab.text = getString(R.string.status)
                3 -> tab.text = getString(R.string.calls)
            }

        }.attach()
        wrapFirstTab(binding.tabLFragSelector)
        onTabDestinationChanged()
    }

    private fun wrapFirstTab(tabLayout: TabLayout) {
        val tabStrip = tabLayout.getChildAt(0)
        if (tabStrip is ViewGroup) {
            // 0th position tab i.e 1st tab
            val tabView = tabStrip.getChildAt(0)
            tabView.minimumWidth = 0
            tabView.setPadding(30, tabView.paddingTop, 30, tabView.paddingBottom)
            tabView.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
            tabLayout.requestLayout()
        }
    }

    private fun onTabDestinationChanged() {
        with(binding) {
            tabLFragSelector.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val fabVisibility = when (tab?.text) {
                        getString(R.string.chats) -> {
                            fabMainActions.setImageResource(R.drawable.ic_new_chat)
                            View.VISIBLE
                        }

                        getString(R.string.status) -> {
                            fabMainActions.setImageResource(R.drawable.ic_camera)
                            View.VISIBLE
                        }

                        getString(R.string.calls) -> {
                            fabMainActions.setImageResource(R.drawable.ic_add_call)
                            View.VISIBLE
                        }

                        else -> View.INVISIBLE
                    }
                    fabMainActions.visibility = fabVisibility
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
                override fun onTabReselected(tab: TabLayout.Tab?) = Unit
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

}