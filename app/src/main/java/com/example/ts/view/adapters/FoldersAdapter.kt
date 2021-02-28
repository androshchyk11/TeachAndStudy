package com.example.ts.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ts.databinding.ItemChatFolderBinding
import com.example.ts.databinding.ItemInvitedUserBinding
import com.example.ts.model.entities.TestEntity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class FoldersAdapter @Inject constructor(@ActivityContext private val context: Context) : RecyclerView.Adapter<FoldersAdapter.FoldersViewHolder>() {

    var folders: ArrayList<TestEntity>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoldersViewHolder {
        val binding = ItemChatFolderBinding.inflate(LayoutInflater.from(parent.context))
        return FoldersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoldersViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = folders?.size ?: 20

    inner class FoldersViewHolder(private val binding: ItemChatFolderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.executePendingBindings()
        }

    }
}