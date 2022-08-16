package ir.ez4.helpiran


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import ir.ez4.helpiran.databinding.ActivityMainBinding
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
//        باز کردن منو با کلیک بر ر.ی ایکون منو
        binding.menuOpener.setOnClickListener {
            binding.drawerMain.openDrawer(binding.navigationvieewMain)
        }

//        قسمت باز کردن منو با استفاده از کلیک بر روی اسم برنامه
        binding.toolbarMainZirmajmoe.setOnClickListener {
            binding.drawerMain.openDrawer(binding.navigationvieewMain)
        }

//    actionBarDrawerToggle.syncState()

    }
}