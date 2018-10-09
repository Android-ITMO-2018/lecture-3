package design.sandwwraith.fragmentssample

import android.content.Context
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.item_user.view.*
import java.util.*

@Parcelize
data class User(val firstName: String, val lastName: String, val age: Int) : Parcelable

fun generateUsers(size: Int): List<User> {
    val res = mutableListOf<User>()
    val rand = Random()
    repeat(size) {
        res.add(when(rand.nextInt(4)) {
            0 -> User("John", "Doe", rand.nextInt(20) + 10)
            1 -> User("John", "Cena", rand.nextInt(30) + 5)
            2 -> User("Joseph", "Joestar", rand.nextInt(10) + 50)
            else -> User("Unknown", "Hero", rand.nextInt(100))
        })
    }
    return res
}

fun RecyclerView.setupForUsers(ctx: Context, genSize: Int, onItemClicked: (Int) -> Unit = {}) {
    layoutManager = LinearLayoutManager(ctx)
    adapter = UsersRecycler(generateUsers(genSize), onItemClicked)
    setHasFixedSize(true)
}

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
