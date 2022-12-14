package ir.ez4.helpiran.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.JobIntentService
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import ir.ez4.ghazasaracenter.NetworkChecker
import ir.ez4.helpiran.R
import ir.ez4.helpiran.activities.Activityasliaval
import ir.ez4.helpiran.activities.Activitychipmanager
import ir.ez4.helpiran.activities.MainActivity
import ir.ez4.helpiran.adaptors.Viewpageradaptor
import ir.ez4.helpiran.databinding.FragmentKhaneBinding

const val FIRST_START = "FirstStart"
const val NIGHT_MODE = "NightMode"
const val PREF = "AppSettingsPrefs"

class Fragkhane:Fragment() {
    private lateinit var shareprefrence: SharedPreferences
    lateinit var urlaksha: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: Viewpageradaptor

    lateinit var binding:FragmentKhaneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentKhaneBinding.inflate(layoutInflater,container,false)

        shareprefrence= requireContext().getSharedPreferences("dataavalie", Context.MODE_PRIVATE)

        return binding.root







    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chipHazfetelat.text = "?????? ?????????????? ????????????"
        sliderView = binding.slider
        urlaksha = ArrayList()
        urlaksha =
            (urlaksha + "https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg") as ArrayList<String>
        urlaksha =
            (urlaksha + "https://s6.uupload.ir/files/t1_1637657384512_oy4o.jpg") as ArrayList<String>
        urlaksha =
            (urlaksha + "https://dawnbreeze.ir/wp-content/uploads/2021/03/Nasim-logo-main-page-for-google.jpg") as ArrayList<String>
        urlaksha =
            (urlaksha + "https://exo.ir/image/cache/catalog/Template/Sliders/Exo-Asus-Monitor-slider-v1-1920x500.jpg") as ArrayList<String>

        sliderAdapter = Viewpageradaptor(urlaksha)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP)
        sliderView.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)


        // on below line we are setting adapter for our slider.
        sliderView.setSliderAdapter(sliderAdapter)

        // on below line we are setting scroll time
        // in seconds for our slider view.
        sliderView.scrollTimeInSec = 3

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        sliderView.isAutoCycle = true



        // on below line we are calling start
        // auto cycle to start our cycle.
        sliderView.startAutoCycle()


        val imageSlider = binding.imageSlider
        val imageList = ArrayList<SlideModel>()



        imageList.add(SlideModel("https://s6.uupload.ir/files/mohsenchavoshi_xhhm.jpg","???????? ??????????"))
        imageList.add(SlideModel("https://s6.uupload.ir/files/t1_1637657384512_oy4o.jpg","???????? ??????????"))
        imageList.add(SlideModel("https://dawnbreeze.ir/wp-content/uploads/2021/03/Nasim-logo-main-page-for-google.jpg","???????? ?????? ????????"))
        imageList.add(SlideModel("https://exo.ir/image/cache/catalog/Template/Sliders/Exo-Asus-Monitor-slider-v1-1920x500.jpg","????????"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)


        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {


                when(position){

                    0-> Toast.makeText(context, "??????????0", Toast.LENGTH_SHORT).show()
                    1-> Toast.makeText(context, "??????????1", Toast.LENGTH_SHORT).show()
                    2-> Toast.makeText(context, "??????????2", Toast.LENGTH_SHORT).show()
                    3-> Toast.makeText(context, "??????????3", Toast.LENGTH_SHORT).show()

                }


            }
        })



        binding.chipBaresishbake.setOnClickListener {

            if ( NetworkChecker(requireContext()).isInternetConnected ) {


            }
                else{
                Toast.makeText(context, "?????? ???? ?????????????? ???????? ?????? ?????????? ???????? ?????????? ?????????? ?????? ???? ?????????? ????????????", Toast.LENGTH_SHORT).show()

            }
        }


        binding.chipPageviewrna.setOnClickListener {

            if (binding.imageSlider.isVisible){
                binding.imageSlider.isVisible=false
                binding.chipPageviewrna.text=" ?????????? pageviewr"
            }else{

                binding.imageSlider.isVisible=true
                binding.chipPageviewrna.text="?????? ?????????? pageviewr"
            }

        }

        binding.chipMenueghashang.setOnClickListener {
            val activitybaadi2= Intent(context, Activitychipmanager::class.java)


            startActivity(activitybaadi2)
                activity?.finish()



    }


        binding.chipTemedark.setOnClickListener {

            val appSettingsPrefs: SharedPreferences = requireContext().getSharedPreferences(PREF, 0)
            val isNightModeOn: Boolean = appSettingsPrefs.getBoolean(NIGHT_MODE, true)
            val isFirstStart: Boolean = appSettingsPrefs.getBoolean(FIRST_START,false)
            val editor: SharedPreferences.Editor = appSettingsPrefs.edit()

            if (isNightModeOn){
                binding.chipTemedark.text = "???????? ???????? ???????? ??????"
            }else if (!isNightModeOn){
                binding.chipTemedark.text = "???????? ???????? ???????? ????"

            }

            if (isNightModeOn) {
                binding.chipTemedark.text = "???????? ???????? ???????? ?????? "
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean(FIRST_START, false)
                editor.putBoolean(NIGHT_MODE, false)
                editor.apply()
                //recreate activity to make changes visible
                activity?.recreate()
            } else {
                binding.chipTemedark.text = "???????? ???????? ???????? ????"
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean(FIRST_START, false)
                editor.putBoolean(NIGHT_MODE, true)
                editor.apply()
                activity?.recreate()

            }
        }


        binding.chipHazfetelat.setOnClickListener {

            val checkesm2 = shareprefrence.contains("esmuser")
            val checkemail2 = shareprefrence.contains("emailuser")
            val checkgendertype2 = shareprefrence.contains("gendertype")

            if (checkesm2 && checkemail2 && checkgendertype2){
                shareprefrence.edit().clear().apply()

                val pDialog = SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)

                pDialog.setCancelable(true)
                pDialog.titleText = "???????????? ????????"
                pDialog.contentText="?????????? ?????????????? ?????? ???? ???????????? ???? ???????? ?????? ?????????? ?? ???????????? ???? ???????? ???????? ???????? ???? ???????? ???????? ???? ?????????? ??????"
                pDialog.confirmText="?????????? ?????? ??????????"
                pDialog.confirmButtonBackgroundColor = R.color.red
                pDialog.show()


                binding.chipHazfetelat.text = "???????????? ?????????????? ????????????"


        }else if (!checkesm2 || !checkemail2 || !checkgendertype2){

                binding.chipHazfetelat.text = "?????? ?????????????? ????????????"

                val activitybaadi= Intent(context, Activityasliaval::class.java)


                startActivity(activitybaadi)
                activity?.finish()

            }


    }

        }

    override fun onStart() {
        super.onStart()
        binding.chipMenueghashang.text="?????????? ?????? ???????? ????"
    }

    override fun onDestroy() {
        super.onDestroy()

        binding.chipMenueghashang.text="???????????? ???? ???????? ?????? ??????"}


    override fun onResume(){
        super.onResume()
        val appSettingsPrefs: SharedPreferences = requireContext().getSharedPreferences(PREF, 0)
        val isNightModeOn: Boolean = appSettingsPrefs.getBoolean(NIGHT_MODE, true)
        if (isNightModeOn){
            binding.chipTemedark.text = "???????? ???????? ???????? ??????"
        }else if (!isNightModeOn){
            binding.chipTemedark.text = "???????? ???????? ???????? ????"

        }
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop")
        super.onStop()
    }

    companion object {
        private const val TAG = "MainActivity"
    }






}





