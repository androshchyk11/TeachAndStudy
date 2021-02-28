package com.example.ts.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ts.databinding.ItemInvitedUserBinding
import com.example.ts.model.entities.TestEntity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class InvitedUserAdapter @Inject constructor(
    @ActivityContext private val context: Context
) : RecyclerView.Adapter<InvitedUserAdapter.InvitedUserViewHolder>() {


    var users: ArrayList<TestEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvitedUserViewHolder {
        val binding = ItemInvitedUserBinding.inflate(LayoutInflater.from(parent.context))
        return InvitedUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InvitedUserViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = users?.size ?: 2
    inner class InvitedUserViewHolder(private val binding: ItemInvitedUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.executePendingBindings()
        }
    }
}