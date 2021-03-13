package com.example.ts.view.fragments.chat.chatFolders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ts.R
import com.example.ts.databinding.FragmentChatBinding
import com.example.ts.interfaces.OnFolderClickListener
import com.example.ts.view.adapters.FoldersAdapter
import com.example.ts.view.fragments.abstraction.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatFragment : BaseFragment() {

    private lateinit var binding: FragmentChatBinding

    @Inject
    lateinit var foldersAdapter: FoldersAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFoldersRecyclerView()

    }

    private fun setupFoldersRecyclerView() {
        binding.foldersList.adapter = foldersAdapter
        binding.foldersList.layoutManager = LinearLayoutManager(requireContext())

        foldersAdapter.onFolderClickListener = object:OnFolderClickListener{
            override fun folderClickListener(id: String?, folderName: String?) {
                findNavController().navigate(R.id.action_chatFragment_to_chatListFragment)
            }
        }
    }


    override fun setupClicks() {

    }
}