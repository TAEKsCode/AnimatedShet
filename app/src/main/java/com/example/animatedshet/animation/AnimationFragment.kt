package com.example.animatedshet.animation

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.animatedshet.R
import com.example.animatedshet.databinding.AnimationFragmentBinding

class AnimationFragment : Fragment() {

    private val viewModel: AnimationViewModel by viewModels()
    private val args: AnimationFragmentArgs by navArgs()
    private lateinit var binding: AnimationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AnimationFragmentBinding.inflate(inflater)
        setImageAssets()
        return binding.root
    }

    private fun setImageAssets() {
        binding.rightDoor.setImageDrawable(createDrawableFromPath("images/doors.jpg"))

        binding.leftDoor.setImageDrawable(createDrawableFromPath("images/doors_reflected.jpg"))

        binding.downToUpImage.setImageDrawable(createDrawableFromPath("images/${args.model.downToUpImagePath}"))

        binding.animationBackground.setImageDrawable(createDrawableFromPath("background/${args.model.backgroundImagePath}"))
    }

    private fun createDrawableFromPath(path: String): Drawable {
        return Drawable.createFromStream(
            requireContext().assets.open(path),
            null
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showAnimation.setOnClickListener { startAnimation() }
    }


    private fun startAnimation() {
        binding.showAnimation.animate().apply {
            alpha(0.0f)
            duration = 1000L
        }

        binding.leftDoor.animate().apply {
            startDelay = 500L
            scaleX(0.75f)
            translationX(-250.0f)
            duration = 1000L
        }
        binding.rightDoor.animate().apply {
            startDelay = 500L
            scaleX(0.75f)
            translationX(250.0f)
            duration = 1000L
        }

        binding.downToUpImage.animate().apply {
            startDelay = 2000L
            translationY(-1250f)
            duration = 1000L
        }
    }
}