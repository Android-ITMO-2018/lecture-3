package design.sandwwraith.fragmentssample

import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.item_user.view.*

@Parcelize
data class User(val firstName: String, val lastName: String, val age: Int) : Parcelable

class UserViewHolder(val frame: FrameLayout) : RecyclerView.ViewHolder(frame) {
    val textView = frame.item_text!!
}

class UsersRecycler(private val users: List<User>, private val onItemClicked: (Int) -> Unit) :
    RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            ) as FrameLayout
        ).apply {
            frame.setOnClickListener { onItemClicked(adapterPosition) }
        }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, index: Int) {
        holder.textView.text = users[index].firstName
    }
}
