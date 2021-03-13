package com.example.ts.view.adapters

import android.content.Context
import com.example.ts.R
import com.example.ts.databinding.ItemChatFolderBinding
import com.example.ts.databinding.ItemChatListBinding
import com.example.ts.interfaces.OnChatItemClickListener
import com.example.ts.interfaces.OnFolderClickListener
import com.example.ts.model.entities.TestEntity
import com.example.ts.utils.showToast
import com.example.ts.view.adapters.base.BaseAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ChatsListAdapter @Inject constructor(@ApplicationContext context: Context) : BaseAdapter<TestEntity, ItemChatListBinding>(context)  {

    var onChatItemClickListener: OnChatItemClickListener? = null
    override val layoutId = R.layout.item_chat_list
    override fun bind(binding: ItemChatListBinding?, entity: TestEntity, position: Int) {
        context.showToast("In Development")
        binding?.executePendingBindings()
    }

}