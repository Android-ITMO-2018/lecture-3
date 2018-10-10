package design.sandwwraith.fragmentssample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user_detail.view.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val USER_PARAM = "user"

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class UserDetailFragment : Fragment() {
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getParcelable(USER_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false)?.apply {
            first_name.text = user?.firstName
            last_name.text = user?.lastName
            age.text = (user?.age ?: 0).toString()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(user: User) =
            UserDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER_PARAM, user)
                }
            }
    }
}
