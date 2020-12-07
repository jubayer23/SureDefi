package com.example.suredefi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amazonaws.mobile.client.AWSMobileClient
import com.example.suredefi.databinding.ActivityHomeBinding
import com.example.suredefi.ui.activity.ActivityFragment
import com.example.suredefi.ui.cart.CartFragment
import com.example.suredefi.ui.home.HomeFragment
import com.example.suredefi.ui.setting.SettingFragment
import com.example.suredefi.ui.swap.SwapFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)


        binding.navigationView.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)

    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {

                //val songsFragment = HomeFragment.newInstance("1","2")
                openFragment2("home")

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_cart -> {

                //val songsFragment = CartFragment.newInstance("1","2")
                openFragment2("cart")

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_swap -> {

                //val songsFragment = SwapFragment.newInstance("1","2")
                openFragment2("swap")

                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_activity -> {

                //val songsFragment = ActivityFragment.newInstance("1","2")
                openFragment2("activity")

                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_setting -> {

                //val songsFragment = SettingFragment.newInstance("1","2")
                AWSMobileClient.getInstance().signOut()
                startActivity(Intent(this, AuthenticationActivity::class.java))
                finish()
                //openFragment2("setting")

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()



    }

    private fun openFragment2( fragmentTag : String) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction().apply {
            val cachedFragment = manager.findFragmentByTag(fragmentTag)
            val currentFragment = manager.findFragmentById(R.id.container)
            if (null != currentFragment) detach(currentFragment)
            if (null == cachedFragment) {

                if(fragmentTag.equals("home")){

                    val songsFragment = HomeFragment.newInstance("1","2")
                    add(R.id.container, songsFragment, fragmentTag)

                }else if(fragmentTag.equals("cart")){

                    val songsFragment = CartFragment.newInstance("1","2")
                    add(R.id.container, songsFragment, fragmentTag)

                }else if(fragmentTag.equals("swap")){
                    val songsFragment = SwapFragment.newInstance("1","2")
                    add(R.id.container, songsFragment, fragmentTag)

                }else if(fragmentTag.equals("activity")){

                    val songsFragment = ActivityFragment.newInstance("1","2")
                    add(R.id.container, songsFragment, fragmentTag)

                }else if(fragmentTag.equals("setting")){

                    val songsFragment = SettingFragment.newInstance("1","2")
                    add(R.id.container, songsFragment, fragmentTag)

                }


            } else {
                attach(cachedFragment)
            }
        } .commitAllowingStateLoss()





    }
}