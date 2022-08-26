package ir.ez4.helpiran.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.FragNewfragOpenerBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


class Frag_menu_newfragopener:Fragment() {

    lateinit var binding:FragNewfragOpenerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding= FragNewfragOpenerBinding.inflate(layoutInflater,container,false)


        return binding.root


    }


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(R.drawable.mohsenchavoshi).transform(RoundedCornersTransformation(32,8)).into(binding.imgMohsenLoading)

        Log.v("imgload","loadingimagemohsen")

        Snackbar.make(binding.root,"عدم دسترسی به اینترنت", Snackbar.LENGTH_INDEFINITE).setTextColor(context!!.getColor(
            android.R.color.black
        )).setActionTextColor(
            context!!.getColor(android.R.color.holo_blue_dark)).setBackgroundTint(context!!.getColor(android.R.color.white)).setAnchorView(R.id.btom_navigation_main).setAction("تلاش مجدد"){}.show()



    }
}