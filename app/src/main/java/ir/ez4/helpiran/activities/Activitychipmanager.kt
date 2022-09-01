package ir.ez4.helpiran.activities

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isNotEmpty
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import ir.dunijet.animation.ext.BaseActivity
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.ActivityActivitychipmanagerBinding
import ir.ez4.helpiran.databinding.FragmentKhaneBinding
import ir.ez4.helpiran.fragments.*


class Activitychipmanager : BaseActivity() {



    lateinit var binding:ActivityActivitychipmanagerBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityActivitychipmanagerBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


//bottom nav curved









        binding.navigationvieewMain.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.menu_firstitem ->{

                    binding.drawerMain.closeDrawer(GravityCompat.END)

                    val dialogsweet= SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)

                    val esm=it.title


                    dialogsweet.titleText="به روز رسانی سرویس"
                    dialogsweet.contentText="با عرض پوزش درحال حاضرامکان دسترسی به قسمت $esm وجود ندارد "
                    dialogsweet.confirmText="متوجه شدم"

                    dialogsweet.confirmButtonTextColor = R.color.sabz








                    dialogsweet.setConfirmClickListener {

                        dialogsweet.dismiss()
                    }
                    dialogsweet.show()
                }
                R.id.menu_seconditem ->{
                    val esm=it.title
                    val dialogBuilder = AlertDialog.Builder(this)

                    // set message of alert dialog
                    dialogBuilder.setMessage("آیا واقعا می خواهید از نرم افزار خارج شوید؟")
                        // if the dialog is cancelable
                        .setCancelable(false)
                        // positive button text and action
                        .setPositiveButton("بله", DialogInterface.OnClickListener {
                                dialog, id -> finish()
                        })
                        // negative button text and action
                        .setNegativeButton("نه دستم خورد!", DialogInterface.OnClickListener {
                                dialog, id -> dialog.cancel()
                        })

                    // create dialog box
                    val alert = dialogBuilder.create()
                    // set title for alert dialog box
                    alert.setTitle("خروج از نرم افزار از قسمت $esm")
                    // show alert dialog
                    alert.show()




                    binding.drawerMain.closeDrawer(GravityCompat.END)
                }
                R.id.menu_thirditem ->{
                    val esm=it.title
                    val builder = android.app.AlertDialog.Builder(this, R.style.CustomAlertDialog)
                        .create()
                    val view = layoutInflater.inflate(R.layout.customview_layoutalertdialog,null)
                    val  button = view.findViewById<Button>(R.id.dialogDismiss_button)
                    val taghirmatntitle=view.findViewById<TextView>(R.id.title_dialog_title)
                    val taghirmatsubtitle=view.findViewById<TextView>(R.id.subtitle_dialog_subtitle)

                    builder.setView(view)
                    button.setOnClickListener {
                        builder.dismiss()
                    }
                    taghirmatntitle.text="خروج از$esm"
                    taghirmatsubtitle.text="آیا واقعا می خواهید از $esm خارج شوید؟"

                    builder.setCanceledOnTouchOutside(false)
                    builder.show()
                    binding.drawerMain.closeDrawer(GravityCompat.END)
                }

                R.id.menu_forthitem ->{



                    //loading fragment


                    val esm= binding.navigationvieewMain.menu.findItem(R.id.menu_forthitem).title




                    val toast2=Toast.makeText(this, "شما بر روی $esm کلیک کردید", Toast.LENGTH_SHORT).show()



                    binding.drawerMain.closeDrawer(GravityCompat.END)
                    binding.navigationvieewMain.menu.findItem(R.id.menu_forthitem).isChecked=false



                }

                R.id.menu_ghesmatdovom_openactivity->{


                    val activitybaadi= Intent(this,Activityopenermenujadid::class.java)

                    startActivity(activitybaadi)

                    binding.drawerMain.closeDrawer(GravityCompat.END)
                }

                R.id.menu_actiity_ghashang->{


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        Snackbar.make(binding.root,"شما در صفحه جدید قرار دارید", Snackbar.LENGTH_LONG).setAction("تلاش مجدد"){
                            val dialogsweetforsnackbaritemsetting=SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)

                            if (!dialogsweetforsnackbaritemsetting.isShowing){
                                dialogsweetforsnackbaritemsetting.titleText="حضور در صفحه جدید"
                                dialogsweetforsnackbaritemsetting.contentText="شما در صفحه زیبا و جدید قرار دارید "
                                dialogsweetforsnackbaritemsetting.confirmText="متوجه شدم"

                                dialogsweetforsnackbaritemsetting.confirmButtonTextColor = R.color.sabz

                                dialogsweetforsnackbaritemsetting.show()
                            }else if (dialogsweetforsnackbaritemsetting.isShowing){

                                dialogsweetforsnackbaritemsetting.dismiss()


                            }


                        }.setTextColor(getColor(
                            R.color.white
                        )).setActionTextColor(getColor(
                            R.color.abie_link
                        )).setBackgroundTint(getColor(R.color.blacklight))
                            .setAnchorView(binding.btnNav)

                            .show()
                    }

                    binding.drawerMain.closeDrawer(GravityCompat.END)
                }
            }
            true
        }





        val bottomNavigation =findViewById<MeowBottomNavigation>(R.id.btn_nav)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.selector_myprofile))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.selector_porbazdid))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.selector_khane))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.selector_darbarema))
        bottomNavigation.add(MeowBottomNavigation.Model(5, R.drawable.selector_contactus))



        bottomNavigation.setOnShowListener {
            fragreplace(Fragkhane())



        }
        bottomNavigation.setOnReselectListener {
            if (Fragkhane().isVisible){
                fragreplace(Fragkhane())
            }
        }

        //set the initial fragment to show
        bottomNavigation.show(3, true)

        //set menu item on click listener
        bottomNavigation.setOnClickMenuListener {
            fragreplace(Fragkhane())
            val item=when(it.id){
                1->"پروفایل کاربری"
                2->"پربازدید"
                3->"خانه"
                4->"درباره ما"
                5->"تماس با ما"
                else ->"نامعلوم"
            }
                //display a toast
                Toast.makeText(applicationContext," شما داخل قسمت $item هستید ", Toast.LENGTH_SHORT).show()


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




                Toast.makeText(applicationContext,"شما مجددا قسمت $item را انتخاب کردید ", Toast.LENGTH_SHORT).show()
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
            binding.drawerMain.openDrawer(binding.navigationvieewMain)
            }

        binding.toolbarMainZirmajmoe.setOnClickListener {
            binding.drawerMain.openDrawer(binding.navigationvieewMain)
        }



    }
    fun fragreplace(fragrep: Fragment){
        val transact=supportFragmentManager.beginTransaction()
        transact.replace(R.id.frm_layout_container_animated,fragrep)
        transact.commit()

        binding.navigationvieewMain.menu.findItem(R.id.menu_forthitem).isChecked=false


    }



}

























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


