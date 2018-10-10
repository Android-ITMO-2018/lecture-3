package design.sandwwraith.fragmentssample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import kotlinx.android.synthetic.main.users_list.view.*


class UsersList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.users_list, container, false)
        view.users_list.setupForUsers(context!!, 20) { user ->
            if (activity?.findViewById<View>(R.id.slot_for_details) != null) {
                val transaction = activity?.supportFragmentManager?.beginTransaction() ?: return@setupForUsers
                transaction.replace(R.id.slot_for_details, UserDetailFragment.newInstance(user))
                transaction.commit()
            } else {
                startActivity(context!!.createUserIntent(user))
            }
        }
        return view
    }
}
