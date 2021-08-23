package com.example.tasks.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tasks.R
import com.example.tasks.viewmodel.ExpiredTasksViewModel


class ExpiredTasksFragment : Fragment() {

    private lateinit var mViewModel: ExpiredTasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProvider(this).get(ExpiredTasksViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expired_tasks, container, false)
    }


}
