package ir.ez4.helpiran.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.ez4.helpiran.databinding.FragmentContactusBinding
import ir.ez4.helpiran.databinding.FragmentDarbaremaBinding
import ir.ez4.helpiran.databinding.FragmentKhaneBinding
import ir.ez4.helpiran.databinding.FragmentMyprofileBinding

class Fragcontactus:Fragment() {

    lateinit var binding:FragmentContactusBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentContactusBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}