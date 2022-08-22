package ir.ez4.helpiran.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.FragNewfragOpenerBinding
import ir.ez4.helpiran.databinding.FragmentMyprofileBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class Frag_menu_newfragopener:Fragment() {

    lateinit var binding:FragNewfragOpenerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding= FragNewfragOpenerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    Glide.with(requireContext()).load(R.drawable.mohsenchavoshi).transform(RoundedCornersTransformation(32,8)).into(binding.imgPhotographer)
    }
}