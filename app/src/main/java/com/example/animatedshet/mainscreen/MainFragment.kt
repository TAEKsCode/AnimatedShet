package com.example.animatedshet.mainscreen

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.animatedshet.R
import com.example.animatedshet.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainBackgroundImage.setOnClickListener { changeBackground() }
        binding.mainDownToUpImage.setOnClickListener { changeDownToUpImage() }
        binding.mainSave.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToAnimationFragment(
                    viewModel.model
                )
            )
        }
        changeBackground()
        changeDownToUpImage()
    }

    private fun changeBackground() {
        val drawable = Drawable.createFromStream(
            requireContext().assets.open("background/${viewModel.model.getNextBackground()}"),
            null
        )
        binding.mainBackgroundImage.setImageDrawable(drawable)
    }

    private fun changeDownToUpImage() {
        val drawable = Drawable.createFromStream(
            requireContext().assets.open("images/${viewModel.model.getNextImage()}"),
            null
        )
        binding.mainDownToUpImage.setImageDrawable(drawable)
    }

}