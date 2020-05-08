package com.developersbreach.recyclerviewtoviewpager.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import com.developersbreach.recyclerviewtoviewpager.R
import com.developersbreach.recyclerviewtoviewpager.viewModel.ListViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SportsAdapter

    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)

        viewModel.sports.observe(viewLifecycleOwner, Observer { sportsList ->
            adapter = SportsAdapter(sportsList, sportsItemListener())
            recyclerView.adapter = adapter
        })

        RecyclerViewItemDecoration.setItemSpacing(
            resources,
            recyclerView
        )

        return view
    }

    private fun sportsItemListener(): SportsAdapter.OnClickListener {
        return SportsAdapter.OnClickListener { sports ->

            val direction: NavDirections =
                ListFragmentDirections.actionListFragmentToDetailFragment(
                    sports
                )
            Navigation.findNavController(requireView()).navigate(direction)
        }
    }

}
