package com.developersbreach.recyclerviewtoviewpager.view.detail

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.model.Sports
import com.developersbreach.recyclerviewtoviewpager.viewModel.DetailViewModel
import com.developersbreach.recyclerviewtoviewpager.viewModel.DetailViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var sportsArgs: Sports
    private lateinit var viewModel: DetailViewModel
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        val application: Application = requireActivity().application
        sportsArgs = DetailFragmentArgs.fromBundle(args).detailFragmentArgs
        val factory = DetailViewModelFactory(application, sportsArgs)
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)
        viewPager2 = view.findViewById(R.id.detail_view_pager)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.sportList.observe(viewLifecycleOwner, Observer { sportsList ->
            val detailViewPagerAdapter = DetailViewPagerAdapter(viewPager2)
            detailViewPagerAdapter.submitList(sportsList)
            viewPager2.adapter = detailViewPagerAdapter
            viewModel.selectedSport.observe(viewLifecycleOwner, Observer { selectedSport ->
                val resetPosition = selectedSport.id
                viewPager2.setCurrentItem(resetPosition, false)
            })
        })
    }

}
