package com.techme.jetpack.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.techme.jetpack.plugin.runtime.NavDestination
import com.techme.jetpack_online.R
import com.techme.jetpack_online.databinding.LayoutFragmentHomeBinding
import com.techme.jetpack_online.http.ApiService
import com.techme.jetpack_online.navigation.BaseFragment
import com.techme.jetpack_online.navigation.navigateTo
import kotlinx.coroutines.launch


@NavDestination(type = NavDestination.NavType.Fragment, route = "home_fragment", asStarter = true)
class HomeFragment : BaseFragment() {
    lateinit var homeBinding: LayoutFragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            val apiResult = ApiService.getService().getFeeds()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = LayoutFragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    var flag = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        homeBinding.navigateToCategoryFragment.setOnClickListener {
            // 对于fragment 类型的路由节点，在 navigate 跳转的时候  使用的fragmentTransaction#replace
            if (flag) {
                navController.navigateTo(
                    "category_fragment", null, NavOptions.Builder().setRestoreState(true).build()
                )
                flag = true
            } else {
                navController.navigate(
                    R.id.category_fragment,
                    null,
                    NavOptions.Builder().setRestoreState(true).build()
                )
            }
            // navController.navigate(NavDeepLinkRequest.Builder.fromUri(Uri.parse("https://com.techme.jetpack/user?phone=124444")).build())
        }

        homeBinding.navigateUp.setOnClickListener {
            navController.navigate(
                R.id.category_fragment,
                null,
                NavOptions.Builder().setRestoreState(true).build()
            )
        }
    }

}