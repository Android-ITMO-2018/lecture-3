package design.sandwwraith.fragmentssample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.users_list.view.*


class UsersListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // here we can user [arguments] Bundle
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.users_list, container, false).also { inflatedView ->
        inflatedView.users_list.setupForUsers(context!!, 20) {
            Toast.makeText(context, "Clicked $it item", Toast.LENGTH_SHORT).show()
        }
    }
}
