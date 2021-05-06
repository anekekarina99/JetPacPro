package com.android.jetpacprodua.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.jetpacprodua.R
import com.android.jetpacprodua.ui.movie.MovieFragment
import com.android.jetpacprodua.ui.tv.TvFragment

class MovieTvAdapter (private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val TAB =
        intArrayOf(R.string.tab_text_1, R.string.tab_text_2)

    override fun getCount(): Int {
        return 2
    }
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvFragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mContext.resources.getString(TAB[position])
    }

}