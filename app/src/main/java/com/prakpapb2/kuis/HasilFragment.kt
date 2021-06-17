package com.prakpapb2.kuis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.prakpapb2.intro1.FragmentHome
import com.prakpapb2.intro1.R

class HasilFragment : Fragment() {

    private lateinit var txtNilai:TextView
    private lateinit var txtPesan:TextView
    private lateinit var btnBelajarLagi:Button

    private lateinit var bundle: Bundle

    private var nilai =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle = requireArguments()
        nilai = bundle.getInt("nilai")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hasil, container, false)

        txtNilai = view.findViewById(R.id.txtNilai)
        txtPesan = view.findViewById(R.id.txtPesan)
        btnBelajarLagi = view.findViewById(R.id.btnBelajarLagi)

        nilai = nilai*20
        txtNilai.setText(nilai.toString())

        if (nilai>60) {
            txtPesan.setText("Pertahankan\n" +
                    "dan \n" +
                    "terus belajar"
            )
        } else {
            txtPesan.setText("Tetap semangat\n" +
                    "dan \n" +
                    "terus belajar"
            )
        }

        //kembali ke beranda
        btnBelajarLagi.setOnClickListener {
            replaceFragment(FragmentHome())
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