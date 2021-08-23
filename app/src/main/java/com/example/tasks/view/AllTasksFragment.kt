package com.example.tasks.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasks.R
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.TaskListener
import com.example.tasks.view.adpter.TaskAdapter
import com.example.tasks.viewmodel.AllTasksViewModel

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllTasksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllTasksFragment : Fragment() {
    private lateinit var mViewModel: AllTasksViewModel
    private lateinit var mListener: TaskListener
    private val mAdapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProvider(this).get(AllTasksViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all_tasks, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_tasks)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : TaskListener {
            override fun onListClick(id: Int) {
                val intent = Intent(context, TaskFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(TaskConstants.BUNDLE.TASKID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            override fun onDeleteClick(id: Int) {

            }

            override fun onCompleteClick(id: Int) {}

            override fun onUndoClick(id: Int) {}


        }

        observe()

        return root
    }

    override fun onResume(){
        super.onResume()
        mAdapter.attachListener(mListener)
    }
    private fun observe(){}

}
