package design.sandwwraith.fragmentssample

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val user = intent?.getParcelableExtra<User>("USER") ?: return
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.detail_view_activity_frame, UserDetailsFragment.newInstance(user))
            commit()
        }
    }
}
