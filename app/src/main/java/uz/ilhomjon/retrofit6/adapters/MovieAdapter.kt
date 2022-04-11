package uz.ilhomjon.retrofit6.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.ilhomjon.retrofit6.databinding.ItemRvBinding
import uz.ilhomjon.retrofit6.models.Movie

class MovieAdapter(var list: List<Movie>) : RecyclerView.Adapter<MovieAdapter.Vh>() {

    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(movie: Movie) {
            Picasso.get().load(movie.imageurl).into(itemRv.itemImage)
            itemRv.itemTv.text = movie.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}