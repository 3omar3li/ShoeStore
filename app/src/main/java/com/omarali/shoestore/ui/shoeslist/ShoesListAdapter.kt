//package com.omarali.shoestore.ui.shoeslist
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.paging.PagedListAdapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.omarali.shoestore.R
//import com.omarali.shoestore.model.ShoeDetails
//
//class ShoesListAdapter : PagedListAdapter<ShoeDetails, RecyclerView.ViewHolder>(DiffUtil) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return ShoeItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
////        holder.bi
//    }
//
//    inner class ShoeItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(shoeDetails: ShoeDetails) {
//            itemView.txt_brand.text = shoeDetails.brand
//            itemView.txtPrice.text = shoeDetails.price
//            binding.txtSizeColor.text = "${shoeDetails.color}, ${shoeDetails.size}"
//        }
//    }
//
//}
//
