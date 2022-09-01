package ir.ez4.helpiran.activities

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ir.dunijet.animation.ext.BaseActivity
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.ActivityActivityopenermenujadidBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class Activityopenermenujadid : BaseActivity() {
    lateinit var binding:ActivityActivityopenermenujadidBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityActivityopenermenujadidBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val opensite=Intent(Intent.ACTION_VIEW, Uri.parse("https://exo.ir/"))
        Glide.with(this).load(R.drawable.ic_iran).transform(RoundedCornersTransformation(32,8)).into(binding.imgTransmissionNewactivityopener)

        binding.btnOpensiteActivity.setOnClickListener {
            Snackbar.make(binding.root,"حشمت برو تو سایت",Snackbar.LENGTH_LONG).setAction("برو تو سایت"){startActivity(opensite)}.setTextColor(getColor(
                R.color.white
            )).setActionTextColor(getColor(
                R.color.abie_link
            )).setBackgroundTint(getColor(R.color.blacklight)).show()

        }
    }
}

