package ir.ez4.helpiran.activities

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.ActivityActivitychipmanagerBinding
import ir.ez4.helpiran.fragments.*


class Activitychipmanager : AppCompatActivity() {


    lateinit var binding:ActivityActivitychipmanagerBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityActivitychipmanagerBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


//bottom nav curved








        val bottomNavigation =findViewById<MeowBottomNavigation>(R.id.btn_nav)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.selector_myprofile))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.selector_porbazdid))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.selector_khane))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.selector_darbarema))
        bottomNavigation.add(MeowBottomNavigation.Model(5, R.drawable.selector_contactus))



        bottomNavigation.setOnShowListener {



        }

        //set the initial fragment to show
        bottomNavigation.show(3, true);

        //set menu item on click listener
        bottomNavigation.setOnClickMenuListener {

            val item=when(it.id){
                1->"پروفایل کاربری"
                2->"پربازدید"
                3->"خانه"
                4->"درباره ما"
                5->"تماس با ما"
                else ->"نامعلوم"
            }
                //display a toast
                Toast.makeText(getApplicationContext()," شما داخل قسمت $item هستید ", Toast.LENGTH_SHORT).show();


            when(it.id){

                1 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragprofileman())

                }
                2 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragporbazdid())
                }
               3 ->{
                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragkhane())
                }
                4 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragdarbarema())
                }
               5 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragcontactus())
                }
                else -> {
                    fragreplace(Fragkhane())}

            }


        //set on reselect listener
        bottomNavigation.setOnReselectListener {
            val item=when(it.id){
                1->"پروفایل کاربری"
                2->"پربازدید"
                3->"خانه"
                4->"درباره ما"
                5->"تماس با ما"
                else ->"نامعلوم"
            }


                Toast.makeText(getApplicationContext(),"شما مجددا قسمت $item را انتخاب کردید ", Toast.LENGTH_SHORT).show();
        if (binding.frmLayoutContainerAnimated.isNotEmpty()){
            when(it.id){

                1 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragprofileman())

                }
                2 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragporbazdid())
                }
                3 ->{
                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragkhane())
                }
                4 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragdarbarema())
                }
                5 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragcontactus())
                }
                else -> {
                    fragreplace(Fragkhane())}

            }

        }else{
            when(it.id){

                1 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragprofileman())

                }
                2 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragporbazdid())
                }
                3 ->{
                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragkhane())
                }
                4 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragdarbarema())
                }
                5 ->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragcontactus())
                }
                else -> {
                    fragreplace(Fragkhane())}

            }


        }

        }









        }



        binding.menuOpener2.setOnClickListener {
            fragreplace(Fragchipmanager())
            }

    }
    fun fragreplace(fragrep: Fragment){
        val transact=supportFragmentManager.beginTransaction()
        transact.replace(R.id.frm_layout_container_animated,fragrep)
        transact.commit()

        binding.navigationvieewMain.menu.findItem(R.id.menu_forthitem).isChecked=false


    }}

























//        binding.chipKhane.setOnCheckedChangeListener { compoundButton, b ->
//
//            if(b||compoundButton.isChecked){
//                binding.chipKhane.setRippleColorResource(R.color.white)
//                binding.chipKhane.setTextColor(R.color.sabz)
//                binding.chipKhane.setChipBackgroundColorResource(R.color.red)
//            }else{
//
//            }
//
//        }


