package android.example.ratethecat.list

import android.example.ratethecat.databinding.ListViewItemBinding
import android.example.ratethecat.network.CatProperty
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ItemGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<CatProperty, ItemGridAdapter.CatPropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGridAdapter.CatPropertyViewHolder {
        return CatPropertyViewHolder(ListViewItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: ItemGridAdapter.CatPropertyViewHolder, position: Int) {
        val catProperty = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(catProperty)
        }
        holder.bind(catProperty)
    }


    companion object DiffCallback : DiffUtil.ItemCallback<CatProperty>(){
        override fun areItemsTheSame(oldItem: CatProperty, newItem: CatProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CatProperty, newItem: CatProperty): Boolean {
            return oldItem.id == oldItem.id
        }
    }

    class CatPropertyViewHolder(private var binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(catProperty: CatProperty){
            binding.property = catProperty
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (catProperty:CatProperty) -> Unit) {
        fun onClick(catProperty: CatProperty) = clickListener(catProperty)
    }

}