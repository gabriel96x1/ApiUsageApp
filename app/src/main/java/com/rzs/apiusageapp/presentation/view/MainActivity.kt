package com.rzs.apiusageapp.presentation.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rzs.apiusageapp.R
import com.rzs.apiusageapp.databinding.ActivityMainBinding
import com.rzs.apiusageapp.presentation.fragments.ProductsFragment
import com.rzs.apiusageapp.presentation.fragments.StoresFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        bottomNavigation = binding.bottomNavigationView

        val storeFragment = StoresFragment()
        val productFragment = ProductsFragment()

        bottomNavigation.selectedItemId = R.id.stores

        makeCurrentFragmentHideAppBar(storeFragment)

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.stores -> makeCurrentFragmentHideAppBar(storeFragment)
                R.id.home -> makeCurrentFragment(productFragment)

            }
            true
        }

        val PERMISSION_ALL = 1
        val PERMISSIONS = arrayOf(
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (!hasPermissions(this, *PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL)
        }

    }

    private fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
        if (context != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission!!
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportActionBar?.show()
        supportFragmentManager.beginTransaction().replace(R.id.main_menu_fragment_wrapper, fragment)
            .commit()
    }

    private fun makeCurrentFragmentHideAppBar(fragment: Fragment) {
        supportActionBar?.hide()
        supportFragmentManager.beginTransaction().replace(R.id.main_menu_fragment_wrapper, fragment)
            .commit()
    }

}
