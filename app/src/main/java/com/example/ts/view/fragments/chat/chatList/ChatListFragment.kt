package com.example.ts.view.fragments.chat.chatList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ts.R
import com.example.ts.databinding.FragmentChatBinding
import com.example.ts.interfaces.OnChatItemClickListener
import com.example.ts.interfaces.OnFolderClickListener
import com.example.ts.utils.showToast
import com.example.ts.view.adapters.ChatsListAdapter
import com.example.ts.view.adapters.FoldersAdapter
import com.example.ts.view.fragments.abstraction.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ChatListFragment:BaseFragment() {
    private lateinit var binding: FragmentChatBinding

    @Inject
    lateinit var chatListAdapter: ChatsListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_list, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFoldersRecyclerView()

    }

    private fun setupFoldersRecyclerView() {
        binding.foldersList.adapter = chatListAdapter
        binding.foldersList.layoutManager = LinearLayoutManager(requireContext())

        chatListAdapter.onChatItemClickListener = object: OnChatItemClickListener {
            override fun chatItemClickListener(id: String?) {

            }
        }
    }


    override fun setupClicks() {

    }
}