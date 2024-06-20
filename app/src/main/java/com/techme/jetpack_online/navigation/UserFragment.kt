package com.techme.jetpack.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.techme.jetpack.plugin.runtime.NavDestination
import com.techme.jetpack_online.R
import com.techme.jetpack_online.databinding.LayoutFragmentUserBinding
import com.techme.jetpack_online.navigation.BaseFragment

@NavDestination(type = NavDestination.NavType.Fragment, route = "user_fragment")
class UserFragment : BaseFragment() {
    lateinit var userBinding: LayoutFragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userBinding = LayoutFragmentUserBinding.inflate(inflater, container, false)
        return userBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userBinding.navigateBack.setOnClickListener {
            findNavController().popBackStack(
                R.id.home_fragment,
                inclusive = false,
                saveState = true
            )
        }
    }
}