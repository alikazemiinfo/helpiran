package ir.ez4.helpiran.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.ez4.helpiran.databinding.FragmentMyprofileBinding

class Fragprofileman:Fragment() {

    lateinit var binding:FragmentMyprofileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentMyprofileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}