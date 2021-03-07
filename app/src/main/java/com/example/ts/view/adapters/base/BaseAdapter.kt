package com.example.ts.view.adapters.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.ts.databinding.ItemChatFolderBinding

abstract class BaseAdapter<Items, Binding: ViewDataBinding>(val context: Context) : RecyclerView.Adapter<BaseAdapter<Items,Binding>.BaseViewHolder>() {

    @LayoutRes
    protected open val layoutId: Int = android.R.layout.test_list_item
    protected open val testItemCount = 8


    var items: List<Items>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

//    protected open var binding: Binding? = null
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context),layoutId,null,false))
    }

    override fun getItemCount() = items?.size ?: testItemCount

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        items?.get(position)?.let {
            bind(holder.binding, it, position)
        }

    }

    inner class BaseViewHolder(val binding: Binding?) : RecyclerView.ViewHolder((binding as ViewDataBinding)?.root)

    protected abstract fun bind(binding: Binding?, entity: Items, position: Int)

    protected open fun bind(biding: Binding, position: Int) {}

}
