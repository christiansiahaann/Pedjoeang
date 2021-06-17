package com.prakpapb2.kuis

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.prakpapb2.intro1.R


class UlasanFragment : Fragment() {

    private lateinit var q1:TextView
    private lateinit var q2:TextView
    private lateinit var q3:TextView
    private lateinit var q4:TextView
    private lateinit var q5:TextView
    private lateinit var btnKirim:Button

    private lateinit var preferences: Preferences
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = Preferences(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ulasan, container, false)

        q1 = view.findViewById(R.id.q1)
        q2 = view.findViewById(R.id.q2)
        q3 = view.findViewById(R.id.q3)
        q4 = view.findViewById(R.id.q4)
        q5 = view.findViewById(R.id.q5)
        btnKirim = view.findViewById(R.id.btn_kirim)

        bundle = requireArguments()

        val answerList = bundle.getIntegerArrayList("answer")
        Log.d("gal", answerList.toString())

        if(answerList!![0] != 10){
            q1.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bgf)
        }else{
            q1.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bguf)
        }
        if(answerList!![1] != 10){
            q2.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bgf)
        }else{
            q2.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bguf)
        }
        if(answerList!![2] != 10){
            q3.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bgf)
        }else{
            q3.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bguf)
        }
        if(answerList!![3] != 10){
            q4.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bgf)
        }else{
            q4.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bguf)
        }
        if(answerList!![4] != 10){
            q5.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bgf)
        }else{
            q5.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_bguf)
        }

        q1.setOnClickListener {
            val newBundle = Bundle()
            newBundle.putIntegerArrayList("answer", answerList)
            newBundle.putInt("question", 0)
            val fragment = FragmentKuisKotlin2()
            fragment.arguments = newBundle
            replaceFragment(fragment)
        }
        q2.setOnClickListener {
            val newBundle = Bundle()
            newBundle.putIntegerArrayList("answer", answerList)
            newBundle.putInt("question", 1)
            val fragment = FragmentKuisKotlin2()
            fragment.arguments = newBundle
            replaceFragment(fragment)
        }
        q3.setOnClickListener {
            val newBundle = Bundle()
            newBundle.putIntegerArrayList("answer", answerList)
            newBundle.putInt("question", 2)
            val fragment = FragmentKuisKotlin2()
            fragment.arguments = newBundle
            replaceFragment(fragment)
        }
        q4.setOnClickListener {
            val newBundle = Bundle()
            newBundle.putIntegerArrayList("answer", answerList)
            newBundle.putInt("question", 3)
            val fragment = FragmentKuisKotlin2()
            fragment.arguments = newBundle
            replaceFragment(fragment)
        }
        q5.setOnClickListener {
            val newBundle = Bundle()
            newBundle.putIntegerArrayList("answer", answerList)
            newBundle.putInt("question", 4)
            val fragment = FragmentKuisKotlin2()
            fragment.arguments = newBundle
            replaceFragment(fragment)
        }

        btnKirim.setOnClickListener {
            var nilai = answerList.count { it == 1 }
            var newBundle = Bundle()
            newBundle.putInt("nilai",nilai)
            var fragment = HasilFragment()
            fragment.arguments = newBundle
            replaceFragment(fragment)
        }

        return view
    }

    private fun replaceFragment(newFragment: Fragment) {
        val trasection = requireFragmentManager().beginTransaction()
        if (!newFragment.isAdded) {
            try {
                //FragmentTransaction trasection =
                requireFragmentManager().beginTransaction()
                trasection.replace(R.id.container_fragment, newFragment)
                trasection.addToBackStack(null)
                trasection.commit()
            } catch (e: Exception) {
                // TODO: handle exception
                // AppConstants.printLog(e.getMessage());
            }
        } else {
            trasection.show(newFragment)
        }
    }


}