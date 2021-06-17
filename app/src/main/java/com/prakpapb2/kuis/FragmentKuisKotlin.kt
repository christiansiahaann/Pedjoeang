package com.prakpapb2.kuis

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.prakpapb2.intro1.R


class FragmentKuisKotlin : Fragment() {

    private val mQuestionLibrary: Soal = Soal()

    private lateinit var mQuestionView: TextView
    private lateinit var mQuestionTitle: TextView
    private lateinit var mButtonChoice1: Button
    private lateinit var mButtonChoice2: Button
    private lateinit var mButtonChoice3: Button
    private lateinit var mButtonNext: Button

    private lateinit var choice1:String
    private lateinit var choice2:String
    private lateinit var choice3:String

    private lateinit var mAnswer:String
    private var mUserAnswer = ""
    private var mScore = 0
    private var mQuestionNumber = 0

    private var answerList = arrayListOf<Int>(10,10,10,10,10)

    private lateinit var bundle: Bundle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bundle = Bundle()

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_kuis_kotlin, container, false)

        mQuestionView = view.findViewById(R.id.question) as TextView
        mQuestionTitle = view.findViewById(R.id.question_title) as TextView
        mButtonChoice1 = view.findViewById(R.id.choice1) as Button
        mButtonChoice2 = view.findViewById(R.id.choice2) as Button
        mButtonChoice3 = view.findViewById(R.id.choice3) as Button
        mButtonNext = view.findViewById(R.id.btn_next) as Button

        updateQuestion()

        mButtonChoice1.setOnClickListener {
            mUserAnswer = choice1
            mButtonChoice1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.brown))

            mButtonChoice2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
            mButtonChoice3.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        }

        mButtonChoice2.setOnClickListener {
            mUserAnswer = choice2
            mButtonChoice2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.brown))

            mButtonChoice1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
            mButtonChoice3.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        }

        mButtonChoice3.setOnClickListener {
            mUserAnswer = choice3
            mButtonChoice3.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.brown))

            mButtonChoice1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
            mButtonChoice2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        }

        mButtonNext.setOnClickListener {
            if(mUserAnswer != ""){
                if(mQuestionNumber < Soal.mQuestions.size){
                    if(mUserAnswer === mAnswer){
                        mScore += 1
                        answerList[mQuestionNumber-1] = 1
                    } else{
                        answerList[mQuestionNumber-1] = 0
                    }
                    updateQuestion()
                } else{
                    if(mUserAnswer === mAnswer){
                        mScore += 1
                        answerList[mQuestionNumber-1] = 1
                    }else{
                        answerList[mQuestionNumber-1] = 0
                    }

//                    val intent = Intent(applicationContext, UlasanActivity::class.java)
//                    intent.putIntegerArrayListExtra("answer", answerList)
//                    startActivity(intent)

                    bundle.putIntegerArrayList("answer", answerList)
                    val fragment = UlasanFragment()
                    fragment.arguments = bundle
                    replaceFragment(fragment)
                }
            } else{
                if(mQuestionNumber < Soal.mQuestions.size){
                    updateQuestion()
                } else {
//                    val intent = Intent(applicationContext, UlasanActivity::class.java)
//                    intent.putIntegerArrayListExtra("answer", answerList)
//                    startActivity(intent)
                    bundle.putIntegerArrayList("answer", answerList)
                    val fragment = UlasanFragment()
                    fragment.arguments = bundle
                    replaceFragment(fragment)
                }
            }
        }

        return view
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun updateQuestion() {
        mUserAnswer = ""
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber))
        mQuestionTitle.setText("Pertanyaan ${mQuestionNumber+1}")
        mButtonChoice1.setText("A. " + mQuestionLibrary.getChoice1(mQuestionNumber))
        mButtonChoice2.setText("B. " + mQuestionLibrary.getChoice2(mQuestionNumber))
        mButtonChoice3.setText("C. " + mQuestionLibrary.getChoice3(mQuestionNumber))

        choice1 = mQuestionLibrary.getChoice1(mQuestionNumber)
        choice2 = mQuestionLibrary.getChoice2(mQuestionNumber)
        choice3 = mQuestionLibrary.getChoice3(mQuestionNumber)

        mButtonChoice1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        mButtonChoice2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
        mButtonChoice3.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber)

        if (mQuestionNumber < Soal.mQuestions.size) {
            mQuestionNumber++
        } else {
            Toast.makeText(requireContext(), "Kuis selesai", Toast.LENGTH_SHORT).show()
        }
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