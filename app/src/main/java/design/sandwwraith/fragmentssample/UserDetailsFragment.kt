package design.sandwwraith.fragmentssample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.content_view.view.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "user"

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class UserDetailsFragment : Fragment() {
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.content_view, container, false).apply { ->
        first_name.text = user?.firstName
        last_name.text = user?.lastName
        age.text = (user?.age ?: 0).toString()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment UserDetailsFragment.
         */
        @JvmStatic
        fun newInstance(param1: User) =
            UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }
}
