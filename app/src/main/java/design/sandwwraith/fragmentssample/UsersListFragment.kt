package design.sandwwraith.fragmentssample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
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
        inflatedView.users_list.setupForUsers(context!!, 20) { user ->
            if (activity?.findViewById<View>(R.id.fragment_content) != null) {
                val transaction = activity!!.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_content, UserDetailsFragment.newInstance(user))
                transaction.commit()
            } else {
                startActivity(context!!.createUserIntent(user))
            }
        }
    }
}
