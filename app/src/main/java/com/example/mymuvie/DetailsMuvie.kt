package com.example.mymuvie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.mymuvie.databinding.FragmentDetailsMuvieBinding


class DetailsMuvie : BottomSheetDialogFragment() {

    private var binding: FragmentDetailsMuvieBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailsMuvieBinding.inflate(layoutInflater)

        binding?.nameCardMovie?.text = arguments?.getString("nameMovie").toString()
        binding?.longCardMovie?.text = arguments?.getString("longMovie").toString()
        binding?.actorsCardMovie?.text = arguments?.getString("actorsMovie").toString()
        binding?.ratingCardMovie?.text = arguments?.getString("ratingMovie").toString()

        return binding?.root
    }


    }