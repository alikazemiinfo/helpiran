package ir.ez4.helpiran


import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import ir.ez4.helpiran.databinding.ActivityMainBinding
import ir.ez4.helpiran.databinding.FragNewfragOpenerBinding
import ir.ez4.helpiran.fragments.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMainZirmajmoe)

        val actionBarDrawerToggle=ActionBarDrawerToggle(


            this,binding.drawerMain,binding.toolbarMainZirmajmoe,R.string.opendrawer,R.string.closedrawer

        )
        binding.drawerMain.addDrawerListener(actionBarDrawerToggle)

        binding.navigationvieewMain.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.menu_firstitem ->{

                    binding.drawerMain.closeDrawer(GravityCompat.END)

                    val dialogsweet=SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)

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
                R.id.menu_seconditem->{
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
                R.id.menu_thirditem->{
                    val esm=it.title
                    val builder = android.app.AlertDialog.Builder(this,R.style.CustomAlertDialog)
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

                R.id.menu_forthitem->{



                    //loading fragment

                    val jabejayyy=supportFragmentManager.beginTransaction()
                    jabejayyy.replace(R.id.frm_layout_container, Frag_menu_newfragopener())
                    jabejayyy.addToBackStack(null)

                    jabejayyy.commit()



                    binding.navigationvieewMain.menu.findItem(R.id.menu_forthitem).isChecked=true




                        binding.drawerMain.closeDrawer(GravityCompat.END)



                }
            }
            true
        }
        firstruntime()


//        باز کردن منو با کلیک بر ر.ی ایکون منو
        binding.menuOpener.setOnClickListener {
            binding.drawerMain.openDrawer(binding.navigationvieewMain)
        }

//        قسمت باز کردن منو با استفاده از کلیک بر روی اسم برنامه
        binding.toolbarMainZirmajmoe.setOnClickListener {
            binding.drawerMain.openDrawer(binding.navigationvieewMain)
        }

//    actionBarDrawerToggle.syncState()


        //کد نویسی فرگمنت ها برای بخش های پایینی ثابت برنامه

//        binding.btomNavigationMain.selectedItemId(R.id.menu_khane)
        binding.btomNavigationMain.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_myprofile->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragprofileman())

                }
                R.id.menu_porbazdid->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragporbazdid())
                }
                R.id.menu_khane->{
                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragkhane())
                }
                R.id.menu_darbarema->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragdarbarema())
                }
                R.id.menu_tamasbama->{

                    //در اینجا می گیم که تابع صدا زده بشود و فرگمنت ما را لود کند
                    fragreplace(Fragcontactus())
                }

            }

            true

        }


        //برای جلوگیری از لود شدن چندین مرتبه عکس ها و ایتم ها با کلیک کردن بر روی هر قسمت از باتم نویگیشن باید دستور زیر را پیاده سازی کنیم
        binding.btomNavigationMain.setOnItemReselectedListener {



        }


    }



    //این قسمت برایدستور جا به جایی بین صفحات هستش
    fun fragreplace(fragrep:Fragment){
        val transact=supportFragmentManager.beginTransaction()
        transact.replace(R.id.frm_layout_container,fragrep)
        transact.commit()

        binding.navigationvieewMain.menu.findItem(R.id.menu_forthitem).isChecked=false


    }

    //در اولین زمان که کاربر برنامه را اجرا کند دستور زیر اجرا می شود
    fun firstruntime(){

        fragreplace(Fragkhane())
        binding.btomNavigationMain.selectedItemId=R.id.menu_khane
    }



    //تست alertdialog
    fun alertdialogtest(){



        val builder = android.app.AlertDialog.Builder(this,R.style.CustomAlertDialog)
            .create()
        val view = layoutInflater.inflate(R.layout.customview_layoutalertdialog,null)
        val  button = view.findViewById<Button>(R.id.dialogDismiss_button)
        builder.setView(view)
        button.setOnClickListener {
            builder.dismiss()
        }
        builder.setCanceledOnTouchOutside(false)
        builder.show()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.navigationvieewMain.menu.findItem(R.id.menu_forthitem).isChecked=false
    }
}