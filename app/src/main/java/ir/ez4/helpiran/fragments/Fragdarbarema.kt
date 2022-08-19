package ir.ez4.helpiran.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import ir.ez4.helpiran.R
import ir.ez4.helpiran.adaptors.porbazdidadaptor
import ir.ez4.helpiran.data.itempost
import ir.ez4.helpiran.databinding.FragmentDarbaremaBinding
import ir.ez4.helpiran.databinding.FragmentKhaneBinding
import ir.ez4.helpiran.databinding.FragmentMyprofileBinding

class Fragdarbarema:Fragment() {

    lateinit var binding:FragmentDarbaremaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentDarbaremaBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val card=view.findViewById<MaterialCardView>(R.id.card_asli)



        card.setOnLongClickListener {

            card.isChecked = !card.isChecked

            true
        }

    }
}