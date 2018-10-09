package design.sandwwraith.fragmentssample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.users_list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users_list.setupForUsers(this, 20) {
            Toast.makeText(this, "Clicked $it item", Toast.LENGTH_SHORT).show()
        }
    }
}
