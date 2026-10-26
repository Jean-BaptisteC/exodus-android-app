package org.eu.exodus_privacy.exodusprivacy.utils

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import org.eu.exodus_privacy.exodusprivacy.R

val animatedNavOptionsBuilder = NavOptions.Builder()
    .setEnterAnim(R.anim.fragment_enter)
    .setExitAnim(R.anim.fragment_exit)
    .setPopEnterAnim(R.anim.fragment_pop_enter)
    .setPopExitAnim(R.anim.fragment_pop_exit)

val animatedNavOptions = animatedNavOptionsBuilder.build()

fun NavController.safeNavigate(
    direction: NavDirections,
    navOptions: NavOptions = animatedNavOptions,
) {
    try {
        if (currentDestination != null) {
            navigate(direction, navOptions)
        }
    } catch (e: IllegalArgumentException) {
        Log.w("SafeNavigate", "Navigation ignorée (clic multiple) : ${e.message}")
    } catch (e: IllegalStateException) {
        Log.w("SafeNavigate", "NavController détaché : ${e.message}")
    }
}
