package com.cogitator.resiabletablayout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 04/05/2018 (MM/DD/YYYY)
 */
class DemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_demo, container, false)
        return view
    }
}