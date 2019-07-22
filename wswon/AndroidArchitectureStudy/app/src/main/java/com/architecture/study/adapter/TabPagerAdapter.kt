package com.architecture.study.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.architecture.study.fragment.CoinListFragment
import com.architecture.study.model.MarketResponse

class TabPagerAdapter(
    fm: FragmentManager,
    private val tabList: List<Int>,
    private val context: Context,
    private val marketList: List<MarketResponse>
) : FragmentStatePagerAdapter(fm) {

    /*4개 탭 one fragment로 bundle argument 처리*/
    override fun getItem(position: Int): Fragment? = CoinListFragment.newInstance(
        marketList.filter { it.market.split("-")[0] == context.getString(tabList[position]) }.map { it.market } as ArrayList<String>
    )

    override fun getCount(): Int = tabList.size

    override fun getItemPosition(`object`: Any): Int = POSITION_NONE

}