package com.example.taskappakyl.ui.home.new_task

import android.location.GpsSatellite
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskappakyl.databinding.FragmentNotificationsBinding

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class NewTaskFragment : Fragment() {

    private lateinit var binding: FragmentNewTaskBinding
    private var task: task: TaskModel? = null

            override fun onClickview(
                inflater: LayoutInflater, contanier: ViewGroup?,
                savedInstanceState: Bundle?,
            ) : View {
                binding = FragmentNewTaskBinding.inflater, container, false,
                initListeners()
                return binding.root

            }
             private fun initListeners() {
                 getTask()
                 checkTask()
                 binding.animationView.visibility = View.GONE

            }
    private fun checkTask() {
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.toString().isNotEmpty()) {
                if (task != null) {
                    updateTask()
                } else {
                    binding.etTitle.text.toString().isNotEmpty()) {
                        val handler = Handler()
                        hanler.postDelsyed(Runnable {
                            insertFun()
                                                    },  1750)
                    }
                } else {
                    binding.etTitle.error = "Заполните"
                }
            }
        }
    }
}