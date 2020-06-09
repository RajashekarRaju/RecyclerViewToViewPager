package com.developersbreach.recyclerviewtoviewpager.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.developersbreach.recyclerviewtoviewpager.databinding.FragmentDetailBinding
import com.developersbreach.recyclerviewtoviewpager.viewModel.DetailViewModel
import com.developersbreach.recyclerviewtoviewpager.viewModel.DetailViewModelFactory


class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sportsArgs = DetailFragmentArgs.fromBundle(requireArguments()).detailFragmentArgs
        val factory = DetailViewModelFactory(requireActivity().application, sportsArgs)
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.detailViewPager.setPageTransformer(ZoomOutPageTransformer())
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}
