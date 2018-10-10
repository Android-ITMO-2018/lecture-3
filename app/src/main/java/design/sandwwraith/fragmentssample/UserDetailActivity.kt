package design.sandwwraith.fragmentssample

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_detail2.*

class UserDetailActivity : AppCompatActivity(), StupidFragment.OnFragmentClick {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                popBackStack()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                navigateTo(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                navigateTo(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun navigateTo(index: Int) {
        popBackStack()
        val tx = supportFragmentManager.beginTransaction()
        tx.replace(R.id.slot_for_details, StupidFragment.newInstance(index.toString()))
        tx.addToBackStack(null)
        tx.setTransition(1000)
        tx.commit()
    }

    private fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    override fun onFragmentInteraction() {
        popBackStack()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail2)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val user = intent?.getParcelableExtra<User>("USER") ?: return
        if (supportFragmentManager.backStackEntryCount > 0) return
        val transaction = supportFragmentManager?.beginTransaction() ?: return
        transaction.replace(R.id.slot_for_details, UserDetailFragment.newInstance(user), "TAG_HOME")
        transaction.commit()
    }
}
