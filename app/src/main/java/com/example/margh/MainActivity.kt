package com.example.margh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.margh.databinding.ActivityMainBinding
import com.example.margh.ui.home.HomeFragment
import com.example.margh.ui.profile.ProfileFragment
import com.example.margh.ui.saved.SavedFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(HOME_FRAGMENT)
                R.id.saved -> setCurrentFragment(SAVED_FRAGMENT)
                R.id.profile -> setCurrentFragment(PROFILE_FRAGMENT)
                else -> {}
            }
            true
        }
        setCurrentFragment(HOME_FRAGMENT)
    }

    private fun setCurrentFragment(tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                when(tag) {
                    HOME_FRAGMENT -> HomeFragment()
                    SAVED_FRAGMENT -> SavedFragment()
                    PROFILE_FRAGMENT -> ProfileFragment()
                    else -> HomeFragment()
                }
            )
            .commit()
    }

    private val HOME_FRAGMENT: String = "home_fragment"
    private val SAVED_FRAGMENT: String = "saved_fragment"
    private val PROFILE_FRAGMENT: String = "profile_fragment"
}