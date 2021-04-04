package com.example.animatedshet.animation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.example.animatedshet.R
import com.example.animatedshet.databinding.AnimationFragmentBinding

class AnimationFragment : Fragment() {

    private val viewModel: AnimationViewModel by viewModels()
    private lateinit var binding: AnimationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AnimationFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showAnimation.setOnClickListener { startAnimation() }
    }


    private fun startAnimation() {
        val leftDoor = binding.leftDoor
        val rightDoor = binding.rightDoor

        leftDoor.animate().apply {
            startDelay = 500L
            scaleX(0.75f)
            translationX(-250.0f)
            duration = 1000L
        }
        rightDoor.animate().apply {
            startDelay = 500L
            scaleX(0.75f)
            translationX(250.0f)
            duration = 1000L
        }

        val cloud = binding.cloud
        cloud.animate().apply {
            startDelay = 2000L
            translationY(-1250f)
            duration = 1000L
        }
    }
}