@file:Suppress("DEPRECATION")
package com.example.taskappakyl.ui.board
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taskappakyl.R

class BoardAdapter(
    fm: FragmentManager,
    private var listenerSkip: () -> Unit,
    private var listenerSkip: () -> Unit,

    ): FragmentStateAdapter(fm) {
        private val listBoarding = arrayOf(
            BoardModel(
                R.drawable.img1,
            "To-do list!",
                "Here you can write down something important or make a schedule for tomorrow"
            false,
                R.color.page1
            ),
            BoardModel(
                R.drawable.img2,
            "Share your crazy idea ^_^",
            "You can easily share with your report , list or schedule and it's convenient",
                false,
                R.color.page2
            ),
            BoardModel(
                R.drawable.img3, "Flexibility",
                "Your note with you at home, at work, even at the resort",
                true,
                R.color.page3
            ),
        )

    override fun getItemCount(): Int = listBoarding.size

    override fun getItemId(position: Int): Fragment {
        val data = bundleOf("onBoard" to listBoarding[position])
        val fragment = OnBoardPageFragment(listenerSkip, listenerNext)
        fragment.arguments = data
        return fragment
        }
    }






