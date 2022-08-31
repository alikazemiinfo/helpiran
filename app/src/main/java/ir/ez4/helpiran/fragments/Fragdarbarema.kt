package ir.ez4.helpiran.fragments



import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable
import com.google.android.material.card.MaterialCardView
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.FragmentDarbaremaBinding


class Fragdarbarema:Fragment() {

    lateinit var binding:FragmentDarbaremaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentDarbaremaBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//برای نمایش منو کاتی که سلکت می شود استفاده می گردد
//        -----------------------------------

//        val card=view.findViewById<MaterialCardView>(R.id.card_asli)
//
//
//
//        card.setOnLongClickListener {
//
//            card.isChecked = !card.isChecked
//
//            true
//        }
//   --------------------------------------------------------


        binding.imgAnimationTest.isVisible=false

        binding.lottieAnimTest.playAnimation()
        binding.lottieAnimTest.repeatMode=LottieDrawable.RESTART
        binding.lottieAnimTest.addAnimatorListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }
        })

        binding.imgAnimationTest.setOnClickListener {

//            alphaanimation()

//            scaleanimation()

//            translateanimation()

//            rotateanimation()


//            multipleanimationusage()


            animloadingfromxml()
        }

}



    //دستور اجرایی انیمیشن آلفا
    private fun alphaanimation() {

        val animation=AlphaAnimation(1f,0f)
        animation.duration=5000
        animation.repeatCount=5
        animation.repeatMode=Animation.REVERSE
        animation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }


        })


        binding.imgAnimationTest.startAnimation(animation)


    }

    //دستور اجرایی انیمیشن اسکیل

    private fun scaleanimation():ScaleAnimation {

        val animationscal=ScaleAnimation(1f,2f,1f,2f,Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f)


        animationscal.duration=5000
        animationscal.repeatCount=4
        animationscal.repeatMode=Animation.REVERSE
        animationscal.fillAfter=false


        return animationscal
    }

    //دستور اجرایی ترنسلیت انیمیشن

    private fun translateanimation() {



        val animationtranslate1=TranslateAnimation(0f,-500f,0f,-200f)
        animationtranslate1.duration=4000
        animationtranslate1.fillAfter=true
        animationtranslate1.interpolator=AccelerateInterpolator()


        binding.imgAnimationTest.startAnimation(animationtranslate1)
    }

    //برای rotate animation
    private fun rotateanimation():RotateAnimation {


        val animationrotatesade=RotateAnimation(0f,300f)

        animationrotatesade.duration=3000
        animationrotatesade.fillAfter=true




        val animationrotatepishrafte=RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)


        animationrotatepishrafte.duration=3000
        animationrotatepishrafte.fillAfter=true


        return animationrotatepishrafte



    }


    //برای استفاده همزمان از دو انیمیشین

    private fun multipleanimationusage() {

        val animset=AnimationSet(true)

        animset.addAnimation(rotateanimation())
        animset.addAnimation(scaleanimation())

        binding.imgAnimationTest.startAnimation(animset)

    }


    //برای خواندن انیمیشین از فایل xmk

    fun animloadingfromxml(){


        val animationloading=AnimationUtils.loadAnimation(context,R.anim.animalpha)
        animationloading.fillAfter=true

        binding.imgAnimationTest.startAnimation(animationloading)



    }

}