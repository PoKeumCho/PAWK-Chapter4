package com.gamecodeschool.firstthread

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    private val myButton: Button?
        get() = view?.findViewById(R.id.myButton)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myButton?.setOnClickListener {
            Thread {
                val status = doTimeConsumingThing()
                //view.findViewById<TextView>(R.id.textview_second).setText(status)
                // Now setText() is called from the UI Thread
                view.post {
                    view.findViewById<TextView>(R.id.textview_second).setText(status)
                }
            }
                .start()
        }
    }

    private fun doTimeConsumingThing(): String {
        return "doTimeConsumingThing()"
    }
}