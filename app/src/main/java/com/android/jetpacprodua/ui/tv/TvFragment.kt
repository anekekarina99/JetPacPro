package com.android.jetpacprodua.ui.tv


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jetpacprodua.databinding.FragmentTvBinding
import com.android.jetpacprodua.viewModel.ViewModelFactory



class TvFragment : Fragment() {

    private lateinit var fragmentTvBinding: FragmentTvBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return  fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInst()
            val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]

            val tAdapter = TvAdapter()

            viewModel.getTvKorea().observe(viewLifecycleOwner, { courses ->
                tAdapter.setTv(courses)
                tAdapter.notifyDataSetChanged()
            })

            with(fragmentTvBinding.recyclerViewTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tAdapter
            }
        }
    }
}