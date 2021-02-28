package com.example.ts.view.fragments.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ts.R
import com.example.ts.databinding.FragmentCreatePasswordBinding
import com.example.ts.databinding.FragmentInviteMembersBinding
import com.example.ts.utils.onThrottleClick
import com.example.ts.view.activities.AuthActivity
import com.example.ts.view.activities.MainActivity
import com.example.ts.view.adapters.InvitedUserAdapter
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.verification.VerificationViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject


@AndroidEntryPoint
class InviteMembersFragment : BaseFragment() {

    private lateinit var binding: FragmentInviteMembersBinding

    @Inject
    lateinit var studentsAdapter: InvitedUserAdapter

    @Inject
    lateinit var teachersAdapter: InvitedUserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_invite_members, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupStudentsRecyclerView()
        setupTeachersRecyclerView()


    }

    private fun setupStudentsRecyclerView() {
        binding.listOfStudents.adapter = studentsAdapter
        binding.listOfStudents.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupTeachersRecyclerView() {
        binding.listOfTeachers.adapter = teachersAdapter
        binding.listOfTeachers.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun setupClicks() {
        binding.saveButton.onThrottleClick {
            (activity as AuthActivity).finish()
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }

}