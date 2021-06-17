package com.prakpapb2.kuis

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import java.util.*


class Preferences(val context:Context) {
    companion object {
        const val MEETING_PREF = "USER_PREF"
    }

    val sharedPref = context.getSharedPreferences(MEETING_PREF, 0)

    fun setValues(key: String, value: ArrayList<String>) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
//        editor.putString(key, value)
        val set: MutableSet<String> = HashSet()
        editor.putStringSet(key, set)
        editor.apply()
    }

    fun getValues(key: String): Array<String> {
        val list: Array<String> = sharedPref.getStringSet(key,null)!!.toTypedArray()
        return list
    }
}