package design.sandwwraith.fragmentssample

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity(), FragmentWithText.FragmentWithTextListener {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                navigateHome()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                navigateOther(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                navigateOther(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onTextClicked() {
        supportFragmentManager.popBackStack()
    }

    private fun navigateOther(index: Int) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.detail_view_activity_frame, FragmentWithText.newInstance("I'm a fragment $index"))
            popHomeIfPresent()
            addToBackStack(null)
            commit()
        }
    }

    private fun popHomeIfPresent() {
        val stackCount = supportFragmentManager.backStackEntryCount
        if (stackCount == 0) {
            return
        }
        if (supportFragmentManager.getBackStackEntryAt(stackCount - 1).name != "TAG_HOME") supportFragmentManager.popBackStack()
    }

    private fun navigateHome() {
        popHomeIfPresent()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val user = intent?.getParcelableExtra<User>("USER") ?: return
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.detail_view_activity_frame, UserDetailsFragment.newInstance(user), "TAG_HOME")
            commit()
        }
    }
}
