package com.example.mylingo.ui.ShopList

import android.os.Build
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
import java.util.function.Predicate


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
                binding.NumTextView.text=(binding.NumTextView.text.toString().toInt()+1).toString()
                binding.totalTextView.text=(binding.NumTextView.text.toString().toInt()*binding.costTextView.text.toString().toInt()).toString()
                SaleList.find { Salelist: items -> Salelist.urls.regular==binding.UrlTextView.text.toString() }?.width =binding.NumTextView.text.toString().toInt()
                SaleList.find { Salelist: items -> Salelist.urls.regular==binding.UrlTextView.text.toString() }?.likes =binding.totalTextView.text.toString().toInt()
            }
        binding.decimageButton.setOnClickListener(){
            if (binding.NumTextView.text.toString().toInt()>1) { binding.NumTextView.text=(binding.NumTextView.text.toString().toInt()-1).toString() }
            binding.totalTextView.text=(binding.NumTextView.text.toString().toInt()*binding.costTextView.text.toString().toInt()).toString()
            SaleList.find { Salelist: items -> Salelist.urls.regular==binding.UrlTextView.text.toString() }?.width =binding.NumTextView.text.toString().toInt()
            SaleList.find { Salelist: items -> Salelist.urls.regular==binding.UrlTextView.text.toString() }?.likes =binding.totalTextView.text.toString().toInt()
            }
        binding.delimageButton.setOnClickListener(){
             SaleList.removeAll({ Salelist: items -> Salelist.urls.regular == binding.UrlTextView.text.toString()})
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
        holder.MCost.text=SaleList[position].height.toString()
        holder.MUrl.text=SaleList[position].urls.regular
        holder.MNum.text=SaleList[position].width.toString()
        holder.MTotalCost.text=SaleList[position].likes.toString()
    /* val currentItem = getItem(position)
        currentItem?.let{ holder.bind(it) }*/
    }
    class ListViewHolder(private val binding:ListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val MUrl:TextView=itemView.findViewById(R.id.UrlTextView)
        val Mimage:ImageView=itemView.findViewById(R.id.ImageView)
        val MNum:TextView=itemView.findViewById(R.id.NumTextView)
        val MTotalCost:TextView=itemView.findViewById(R.id.totalTextView)
        val MCost:TextView=itemView.findViewById(R.id.costTextView)

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
