package com.example.fastcampus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentFirst : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater : XML 을 화면에 사용할 준비를 한다. (XML -> View 로 만들어 준다.)
        // container : Fragment 에서 사용될 XML 의 부모뷰
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        // attachToRoot : 루트뷰에 붙일 지 말지(x)


        (view.findViewById<TextView>(R.id.call_activity)).setOnClickListener {
            (activity as FragmentActivity).printTestLog() // FragmentActivity 를 캐스팅해서 가져온다.
        }
        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: String? = arguments?.getString("key") // 중요
        Log.d("testt", "data is" + data)
    }

    fun printTestLog() {
        Log.d("testt", "print test log from fragment")

    }
}