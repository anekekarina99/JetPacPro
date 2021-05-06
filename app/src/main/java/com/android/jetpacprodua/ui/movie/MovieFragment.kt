package com.android.jetpacprodua.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jetpacprodua.databinding.FragmentMovieBinding
import com.android.jetpacprodua.viewModel.ViewModelFactory
import android.view.View as View1


class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View1 {

        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return  fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View1, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInst(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val mAdapter = MovieAdapter()

            viewModel.getMovieKorea().observe(viewLifecycleOwner, {
                mAdapter.setMovie(it)
                mAdapter.notifyDataSetChanged()
            })

            with(fragmentMovieBinding.recyclerViewMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = mAdapter
            }
        }
    }
}