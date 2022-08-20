package ir.ez4.helpiran

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.CollapsibleActionView
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import ir.ez4.helpiran.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    private var fabTitle: TextView? = null
    private var appbar: AppBarLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAsli2)


        val extendedFloatingActionButton =findViewById<ExtendedFloatingActionButton>(R.id.extFloatingActionButton)
        val nestedScrollView = findViewById<NestedScrollView>(R.id.nested_changes2)

        nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY -> // the delay of the extension of the FAB is set for 12 items
            if (scrollY > oldScrollY + 12 && extendedFloatingActionButton.isExtended) {
                extendedFloatingActionButton.shrink()
            }

            // the delay of the extension of the FAB is set for 12 items
            if (scrollY < oldScrollY - 12 && !extendedFloatingActionButton.isExtended) {
                extendedFloatingActionButton.extend()
            }

            // if the nestedScrollView is at the first item of the list then the
            // extended floating action should be in extended state
            if (scrollY == 0) {
                extendedFloatingActionButton.extend()
            }
        })




        binding.collapsingToolbarMainactivity2Test.setExpandedTitleColor(
            ContextCompat.getColor(this,android.R.color.transparent)


        )


        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.collapsingToolbarMainactivity2Test.title="تست"







    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId==android.R.id.home){

            onBackPressed()
        }
        return true
    }
}