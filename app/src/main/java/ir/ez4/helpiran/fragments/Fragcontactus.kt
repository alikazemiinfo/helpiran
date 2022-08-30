package ir.ez4.helpiran.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.FragmentContactusBinding
import ir.ez4.helpiran.databinding.FragmentDarbaremaBinding
import ir.ez4.helpiran.databinding.FragmentKhaneBinding
import ir.ez4.helpiran.databinding.FragmentMyprofileBinding

class Fragcontactus:Fragment() {

    lateinit var binding:FragmentContactusBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentContactusBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fancyAboutPage = binding.fancyaboutpage
        //fancyAboutPage.setCoverTintColor(Color.BLUE); //Optional
        fancyAboutPage.setCover(R.drawable.ic_iran)
        fancyAboutPage.setName("ساخت علی کاظمی")
        fancyAboutPage.setDescription("این نرم افزار توسط علی کاظمی ساخته و تهیه گردیده است")
        fancyAboutPage.setAppIcon(R.drawable.ic_alert)
        fancyAboutPage.setAppName("HelpIran(Testproject)")
        fancyAboutPage.setVersionNameAsAppSubTitle("1.2.3")
        fancyAboutPage.setAppDescription(
            """  هلپ ایران پروژه ای جدید برای نمایش قابلیت ها و ویژگی های قابل تست می باشد و هیچگونه استفاده  تجاری یا پرداختی توسط این نرم افزار صورت نمی گیرد و صرفا این نرم افزار جهت نمایش به عنوان نمونه کار استفاده می گردد""".trimIndent()
        )
        fancyAboutPage.addEmailLink("alidownload2@yahoo.com")
        fancyAboutPage.addLinkedinLink("https://www.linkedin.com/in/ali-kazemi-0a9176187/")
        fancyAboutPage.addGitHubLink("https://github.com/alikazemiinfo")

    }
    }
