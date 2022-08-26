package ir.ez4.helpiran.activities

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.CollapsibleActionView
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import ir.ez4.helpiran.data.Itempost
import ir.ez4.helpiran.databinding.ActivityMain2Binding
import ir.ez4.helpiran.fragments.SENDING_DATA_WITH_INTENTTOMAINACTIVITY_INORDERTOSHOWOURCONTENT

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    private var fabTitle: TextView? = null
    private var appbar: AppBarLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAsli)




//        val extendedFloatingActionButton =findViewById<ExtendedFloatingActionButton>(R.id.extFloatingActionButton)
//        val nestedScrollView = findViewById<NestedScrollView>(R.id.nested_changes2)
//
//        nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY -> // the delay of the extension of the FAB is set for 12 items
//            if (scrollY > oldScrollY + 12 && extendedFloatingActionButton.isExtended) {
//                extendedFloatingActionButton.shrink()
//            }
//
//            // the delay of the extension of the FAB is set for 12 items
//            if (scrollY < oldScrollY - 12 && !extendedFloatingActionButton.isExtended) {
//                extendedFloatingActionButton.extend()
//            }
//
//            // if the nestedScrollView is at the first item of the list then the
//            // extended floating action should be in extended state
//            if (scrollY == 0) {
//                extendedFloatingActionButton.extend()
//            }
//        })


        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(this,android.R.color.transparent)


        )


        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)





        val daryaftdataparcelable=intent.getParcelableExtra<Itempost>(
            SENDING_DATA_WITH_INTENTTOMAINACTIVITY_INORDERTOSHOWOURCONTENT)

        if (daryaftdataparcelable !=null){

            Showmydata(daryaftdataparcelable)
        }




    }

    private fun Showmydata(itempost: Itempost) {
        Log.v("dataomad",itempost.toString())


        val glide=Glide.with(this).load(itempost.imgurl).into(binding.imgDetail)

        binding.txtDetailTitle.text=itempost.txt_title
        binding.txtDetailSubtitle.text=itempost.txt_subtitle
        binding.txtDetailText.text=itempost.txt_describtion

        binding.collapsingMain.title=itempost.txt_title



        binding.fabDetailOpenMan.setOnClickListener {

            val url="https://www.digikala.com/"

            val inent=Intent(Intent.ACTION_VIEW, Uri.parse(itempost.imgurl))
            startActivity(inent)


        }




    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId==android.R.id.home){

            onBackPressed()
        }
        return true
    }
}