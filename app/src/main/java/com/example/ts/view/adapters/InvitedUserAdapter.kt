package com.example.ts.view.adapters

import android.content.Context
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ts.R
import com.example.ts.databinding.ItemInvitedUserBinding
import com.example.ts.model.entities.TestEntity
import com.example.ts.view.adapters.base.BaseAdapter
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class InvitedUserAdapter @Inject constructor(
    @ActivityContext context: Context
) : BaseAdapter<TestEntity, ItemInvitedUserBinding>(context) {
    override val layoutId = R.layout.item_invited_user
    override fun bind(binding: ItemInvitedUserBinding?, entity: TestEntity, position: Int) {
        binding?.executePendingBindings()
    }
}