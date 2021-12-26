package com.app.kotlinmvpsample.presentation

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.app.kotlinmvpsample.R
import com.app.kotlinmvpsample.ScreenTransition

/**
 * Created by Gerasimos on 20/11/2021
 */

fun FragmentActivity?.openFragment(
    fragment: Fragment,
    addToStack: Boolean = false,
    isAddTransaction: Boolean = false,
    clearStack: Boolean = false,
    screenTransition: ScreenTransition
) {
    this?.supportFragmentManager?.let { fragmentManager ->

        if (clearStack && fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        val transaction = fragmentManager.beginTransaction()
        transaction.apply {

            when (screenTransition) {
                ScreenTransition.RIGHT -> setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.enter_from_left,
                    R.anim.pop_enter_from_right,
                    R.anim.pop_exit_from_left
                )
                ScreenTransition.LEFT -> setCustomAnimations(
                    R.anim.enter_from_left,
                    R.anim.enter_from_right,
                    R.anim.pop_enter_from_left,
                    R.anim.pop_exit_from_right
                )
                ScreenTransition.BELOW -> setCustomAnimations(
                    R.anim.bottom_up,
                    R.anim.bottom_down,
                    R.anim.slide_in_bottom_up,
                    R.anim.slide_out_bottom_down
                )
            }

            val tag = fragment::class.java.simpleName
            if (isAddTransaction) {
               // add(R.id.frameContainerView, fragment, tag)
            } else {
              //  replace(R.id.frameContainerView, fragment, tag)
            }

            if (addToStack) {
                addToBackStack(tag)
            }

            commitAllowingStateLoss()
        }
    }
}