package com.techme.jetpack_online.list

import androidx.fragment.app.Fragment
import com.techme.jetpack_online.R
import com.techme.jetpack_online.databinding.LayoutAbsListFragmentBinding
import com.techme.jetpack_online.ext.invokeViewBinding

class AbsListFragment: Fragment(R.layout.layout_abs_list_fragment) {
    private val viewBinding: LayoutAbsListFragmentBinding by invokeViewBinding()
}