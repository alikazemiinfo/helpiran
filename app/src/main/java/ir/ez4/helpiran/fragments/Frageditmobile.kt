package ir.ez4.helpiran.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.ez4.helpiran.activities.MainActivity2
import ir.ez4.helpiran.adaptors.Itemevent
import ir.ez4.helpiran.adaptors.trendadaptor
import ir.ez4.helpiran.data.Itempost
import ir.ez4.helpiran.databinding.*

class Frageditmobile(private val mainDialogeven2: MainDialogeven2) : BottomSheetDialogFragment() {

    lateinit var binding: FragmentEditmobileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditmobileBinding.inflate(layoutInflater, container, false)

        binding.btnTaidFragdialog.setOnClickListener {
            val shomareghadim = binding.shomareNamayeshi.text.toString()
            val shomarejadid = binding.edtVorodiShomarejadidInfrag1.text.toString()
            val shomarejadidnamayeshi=binding.shomarejadidNamayeshi
            if (shomarejadid.isNotEmpty()) {

                if (shomarejadid.isEmpty()){

                    shomarejadidnamayeshi.isErrorEnabled=true
                    shomarejadidnamayeshi.error="لطفا شماره جدید خود را وارد نمایید"

                }

                mainDialogeven2.sent_text_data(shomarejadid)

                dismiss()


            } else {

                if (shomarejadid.isEmpty()){

                    shomarejadidnamayeshi.isErrorEnabled=true
                    shomarejadidnamayeshi.error="لطفا شماره جدید خود را وارد نمایید"

                    }
                Toast.makeText(
                    context,
                    "لطفا شماره جدید خود را وارد نمایید",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }


        binding.btnCancelFragdialog.setOnClickListener {

            dismiss()

        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)








    }




interface MainDialogeven2 {

    fun sent_text_data(data:String)



}}