package ir.ez4.helpiran


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import ir.ez4.helpiran.databinding.ActivityMainBinding
import ir.ez4.helpiran.fragments.*
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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

                }
                R.id.menu_seconditem->{
                }
                R.id.menu_thirditem->{
                }

                R.id.menu_forthitem->{

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



    }

    //در اولین زمان که کاربر برنامه را اجرا کند دستور زیر اجرا می شود
    fun firstruntime(){

        fragreplace(Fragkhane())
        binding.btomNavigationMain.selectedItemId=R.id.menu_khane
    }
}