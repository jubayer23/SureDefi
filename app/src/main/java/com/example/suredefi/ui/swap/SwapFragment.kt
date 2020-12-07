package com.example.suredefi.ui.swap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.suredefi.R
import com.example.suredefi.databinding.FragmentSwapBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SwapFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SwapFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSwapBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_swap, container, false)

       /* binding.btnSignup.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_signupFragment_to_homeActivity)
        )*/
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SwapFragment()
    }
}