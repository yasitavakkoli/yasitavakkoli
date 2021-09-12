package com.example.mylingo.ui.Shopping

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.mylingo.data.items
import com.example.mylingo.R
import com.example.mylingo.databinding.ItemItemsBinding
import com.google.android.material.snackbar.Snackbar


val SaleList:MutableList<items> = mutableListOf()

class itemsAdapter: PagingDataAdapter<items,
        itemsAdapter.itemsViewHolder>(ITEMS_COMPARATOR)
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemsViewHolder
    {
        val binding=ItemItemsBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        binding.setClickListener1 {
            val find:items? = SaleList.find{ Salelist: items -> Salelist.urls.regular==binding.UrlTextView.text.toString() }
            if (find!=null){
                if (binding.checkBox.isChecked == true){
                    SaleList.remove(find)
                    binding.checkBox.isChecked = false
                }
                else{
                    Snackbar.make(binding.root, "this Item already added.", Snackbar.LENGTH_LONG).show()
                    binding.checkBox.isChecked = true
                }
            }
            else{
                SaleList.add(
                    items(
                          "",
                          1,
                           binding.itemsTextView.text.toString().toInt(),
                           binding.itemsTextView.text.toString().toInt(),
                          "",
                           items.itemsUser("", ""),
                           items.itemsUrls("", "", binding.UrlTextView.text.toString(), "", "")
                           )
                        )
                        binding.checkBox.isChecked = true
                    }
      }
            return itemsViewHolder((binding))
    }

    override fun onBindViewHolder(holder: itemsViewHolder, position: Int)
    {
        val currentItem = getItem(position)
        currentItem?.let{ holder.bind(it) }
    }
    class itemsViewHolder(private val binding:ItemItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Items: items) {
            binding.apply {
                Glide.with(itemView)
                    .load(Items.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_baseline_error_outline_24)
                    .into(ImageView)
                itemsTextView.text= Items.height.toString()
                UrlTextView.text=Items.urls.regular
            }
            }
        }

    companion object{
      private val ITEMS_COMPARATOR = object :DiffUtil.ItemCallback<items>(){
         override fun areItemsTheSame(oldItem: items, newItem: items): Boolean
              = oldItem.id == newItem.id
         override fun areContentsTheSame(oldItem: items, newItem: items)
              = oldItem == newItem
        }
    }
}
