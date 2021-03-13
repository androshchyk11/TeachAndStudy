package com.example.ts.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ts.R
import com.example.ts.databinding.ItemChatFolderBinding
import com.example.ts.databinding.ItemInvitedUserBinding
import com.example.ts.interfaces.OnFolderClickListener
import com.example.ts.model.entities.TestEntity
import com.example.ts.view.adapters.base.BaseAdapter
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FoldersAdapter @Inject constructor(@ApplicationContext context: Context) : BaseAdapter<TestEntity, ItemChatFolderBinding>(context) {
    var onFolderClickListener: OnFolderClickListener? = null
    override val layoutId = R.layout.item_chat_folder
    override fun bind(binding: ItemChatFolderBinding?, entity: TestEntity, position: Int) {
        binding?.clickItem?.setOnClickListener {
            onFolderClickListener?.folderClickListener() // todo add folderId and folderName when back appear
        }
        binding?.executePendingBindings()
    }
}