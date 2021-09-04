package com.example.mylingo.ui.ShopList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.mylingo.data.items
import com.example.mylingo.R
import com.example.mylingo.databinding.ListItemsBinding


class ListAdapter(MyList: MutableList<items>): PagingDataAdapter<items,
        ListAdapter.ListViewHolder>(LIST_COMPARATOR)
{
    val SaleList:MutableList<items> = MyList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder
    {
        val binding= ListItemsBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        binding.setClickListener {
            binding.incimageButton.setOnClickListener(){

            }
        binding.decimageButton.setOnClickListener(){

            }
        binding.delimageButton.setOnClickListener(){

            }
        }
            return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int)
    {
        Glide.with(holder.itemView)
            .load(SaleList[position].urls.regular)
            .centerCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(holder.Mimage)
        holder.Mheight.text=SaleList[position].height.toString()
        holder.MUrl.text=SaleList[position].urls.regular
    /* val currentItem = getItem(position)
        currentItem?.let{ holder.bind(it) }*/
    }
    class ListViewHolder(private val binding:ListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val MUrl:TextView=itemView.findViewById(R.id.UrlTextView)
        val Mimage:ImageView=itemView.findViewById(R.id.ImageView)
        val Mheight:TextView=itemView.findViewById(R.id.itemsTextView)
        }
    override fun getItemCount(): Int {
        return SaleList.size;
    }

    companion object{
      private val LIST_COMPARATOR = object :DiffUtil.ItemCallback<items>(){
         override fun areItemsTheSame(oldItem: items, newItem: items): Boolean
              = oldItem.id == newItem.id
         override fun areContentsTheSame(oldItem: items, newItem: items)
              = oldItem == newItem
        }
    }
}
