package ir.ez4.helpiran.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.core.widget.addTextChangedListener
import cn.pedant.SweetAlert.SweetAlertDialog
import ir.dunijet.animation.ext.BaseActivity
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.WelcomepageBinding


class Activityasliaval:BaseActivity() {
    private lateinit var shareprefrence:SharedPreferences
    private lateinit var binding: WelcomepageBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WelcomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //بررسی اطلاعات اولیه با استفاده از shared prefrences
        shareprefrence=getSharedPreferences("dataavalie", Context.MODE_PRIVATE)



        val checkesm = shareprefrence.contains("esmuser")
        val checkemail = shareprefrence.contains("emailuser")
        val checkgendertype = shareprefrence.contains("gendertype")
        val checkshomare=shareprefrence.contains("shomareuser")
        val checkramz=shareprefrence.contains("ramzuser")



        //بررسی لحظه و نمایش لحظه ای





        //عناوین اسمی
        val gensiatkarbar=binding.txtJensiat
        gensiatkarbar.text= "جناب آقای / سرکار خانم"


        binding.rdiogrpJensiat.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId == ir.ez4.helpiran.R.id.radio_male) {
                gensiatkarbar.text= "جناب آقای"
            } else if (checkedId == ir.ez4.helpiran.R.id.radio_female) {
                gensiatkarbar.text= "سرکار خانم"
            }
            else if (checkedId == ir.ez4.helpiran.R.id.radio_none){
                gensiatkarbar.text= "جناب آقای / سرکار خانم"
            }else{

                gensiatkarbar.text= "جناب آقای / سرکار خانم"
            }
        })

        if (binding.radioMale.isChecked) {

            //یعنی کاربر ما مرد است
            gensiatkarbar.text= "جناب آقای"

        } else if (binding.radioFemale.isChecked) {
            //یعنی کاربر ما زن است
            gensiatkarbar.text= "سرکار خانم"

        } else if (binding.radioNone.isChecked) {

            //یعنی کاربر ما نامعلوم است
            gensiatkarbar.text= "جناب آقای / سرکار خانم"
        }


        //اضافه کردن قسمت نام و نام خانوادگی


        binding.enteringNameUser.editText!!.addTextChangedListener {


            if (it!!.isNotEmpty()) {

                binding.enteringNameUser.isErrorEnabled=false
                binding.enteringNameUser.isHelperTextEnabled=true
                binding.enteringNameUser.error = null
                binding.enteringNameUser.helperText = " ${gensiatkarbar.text} : ${binding.txtinputNameandsurename.text} "

            } else {
                binding.enteringNameUser.helperText = " ${gensiatkarbar.text} : ${binding.txtinputNameandsurename.text} "
                binding.enteringNameUser.isErrorEnabled=false
                binding.enteringNameUser.isHelperTextEnabled=false

            }
        }


        //اضافه کردن قسمت ایمیل
        if (binding.txtinputEmail.text!!.isEmpty()){
            binding.enteringEmailUser.isErrorEnabled=false

        }

        binding.txtinputEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.enteringEmailUser.isErrorEnabled=false
                binding.enteringEmailUser.error=null
            }

            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                // check inputted text that it is a valid email address or not
                if (p0.isValidEmail()){
                    binding.enteringEmailUser.isErrorEnabled=false
                    binding.enteringEmailUser.error=null
                    binding.enteringEmailUser.isHelperTextEnabled=true
                    binding.enteringEmailUser.helperText="${binding.txtinputEmail.text.toString()} : ایمیل شما عبارت است از"
                }else if (binding.txtinputEmail.text!!.isEmpty()){
                    binding.enteringEmailUser.isHelperTextEnabled=false
                    binding.enteringEmailUser.isErrorEnabled=false
                    binding.enteringEmailUser.error=null

                }
                else{
                    binding.enteringEmailUser.isErrorEnabled=true
                    binding.enteringEmailUser.isHelperTextEnabled=false
                    binding.enteringEmailUser.error = "شیوه نگارش ایمیل اشتباه یا کامل نمی باشد"
                }
            }

            override fun afterTextChanged(p0: Editable?) { }
        })


        //اضافه کردن قسمت شماره موبایل


        if (binding.txtinputMobile.text!!.isEmpty()){
            binding.enteringPhonenumberUser.isErrorEnabled=false

        }else if (binding.txtinputMobile.text!!.length<9){
            binding.enteringEmailUser.error="لطفا شماره موبایل خود را مجددا بررسی نمایید"
        }


        binding.txtinputMobile.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.enteringPhonenumberUser.isErrorEnabled=false
                binding.enteringPhonenumberUser.error=null
            }

            @SuppressLint("ResourceType")
            override fun onTextChanged(p0: CharSequence?,
                                       p1: Int, p2: Int, p3: Int) {
                // check inputted text that it is a valid email address or not
                if (p0.isValidPhoneNumber()){
                    binding.enteringPhonenumberUser.hint="لطفا شماره موبایل خود را وارد نمایید..."
                    binding.enteringPhonenumberUser.isErrorEnabled=false
                    binding.enteringPhonenumberUser.error=null
                    binding.enteringPhonenumberUser.isHelperTextEnabled=true
                    binding.enteringPhonenumberUser.helperText="${binding.txtinputMobile.text.toString()} : شماره موبایل شما عبارت است از"
                }else if (binding.txtinputMobile.text!!.isEmpty()){
                    binding.enteringPhonenumberUser.isHelperTextEnabled=false
                    binding.enteringPhonenumberUser.hint="لطفا شماره موبایل خود را وارد نمایید(بدون صفر اول و 98+)"


                    binding.enteringPhonenumberUser.isErrorEnabled=false
                    binding.enteringPhonenumberUser.error=null

                }
                else{
                    binding.enteringPhonenumberUser.hint="لطفا شماره موبایل خود را وارد نمایید..."
                    binding.enteringPhonenumberUser.isErrorEnabled=true
                    binding.enteringPhonenumberUser.isHelperTextEnabled=false
                    binding.enteringPhonenumberUser.error = "شماره موبایل شما اشتباه یا کامل نمی باشد"
                }
            }

            override fun afterTextChanged(p0: Editable?) { }
        })


        //اضافه کردن قسمت رمز عبور








        if (checkesm && checkemail && checkgendertype&&checkramz&&checkshomare) {
            val activityasli = Intent(this, MainActivity::class.java)
            finish()
            startActivity(activityasli)

        }

//اعمال اطلاعات
        binding.btnTaid.setOnClickListener {

            val checkerinputesm = binding.txtinputNameandsurename
            val checkerinputemail = binding.txtinputEmail
            val checkrdiogroup = binding.rdiogrpJensiat
            val checkshomaremobile=binding.txtinputMobile
            val checkaddress=binding.txtinputAddress
            val checkramz=binding.txtinputRamz





            if (checkerinputesm.text!!.isEmpty() || checkerinputemail.text!!.isEmpty() || binding.rdiogrpJensiat.isEmpty()||checkshomaremobile.text!!.isEmpty()||checkramz.text!!.isEmpty()||!binding.enteringEmailUser.isHelperTextEnabled||!binding.enteringPhonenumberUser.isHelperTextEnabled){



            if (checkerinputesm.text!!.isEmpty() || checkerinputemail.text!!.isEmpty() || binding.rdiogrpJensiat.isEmpty()||checkshomaremobile.text!!.isEmpty()||checkramz.text!!.isEmpty()||!binding.enteringEmailUser.isHelperTextEnabled||!binding.enteringPhonenumberUser.isHelperTextEnabled) {

                if (checkerinputesm.text!!.isEmpty()) {

                    binding.enteringNameUser.isErrorEnabled = true
                    binding.enteringNameUser.error = "لطفا نام و نام خانوادگی خود را وارد نمایید"


                } else if (checkerinputesm.text!!.isNotEmpty()) {

                    binding.enteringNameUser.isErrorEnabled = false
                }


                if (checkerinputemail.text!!.isEmpty()) {

                    isEmailValid(checkaddress.text.toString())
                    binding.enteringEmailUser.isErrorEnabled = true
                    binding.enteringEmailUser.error = "لطفا ایمیل خود را وارد نمایید"

                } else if (checkerinputemail.text!!.isNotEmpty()) {
                    binding.enteringEmailUser.isErrorEnabled = false


                }


                if (checkshomaremobile.text!!.isEmpty()) {

                    binding.enteringPhonenumberUser.isErrorEnabled = true
                    binding.enteringPhonenumberUser.error = "لطفا شماره موبایل خود را وارد نمایید"

                } else if (checkshomaremobile.text!!.isNotEmpty()) {
                    binding.enteringPhonenumberUser.isErrorEnabled = false


                }




                if (checkramz.text!!.isEmpty()) {

                    binding.enteringRamzUser.isErrorEnabled = true
                    binding.enteringRamzUser.error = "لطفا رمز عبور دلخواه خود را وارد نمایید"

                } else if (checkramz.text!!.isNotEmpty()) {
                    binding.enteringRamzUser.isErrorEnabled = false


                }

                if (binding.enteringEmailUser.isHelperTextEnabled){
                    binding.enteringEmailUser.isErrorEnabled=false

                }else{
                    binding.enteringEmailUser.error="لطفا ایمیل خود را مجددا بررسی نمایید"
                }



                if (binding.txtinputMobile.text!!.length<9){
                    binding.enteringPhonenumberUser.error="لطفا شماره موبایل خود را مجددا بررسی نمایید"
                }else{
                    binding.enteringPhonenumberUser.isErrorEnabled=false
                }




                Toast.makeText(this, "لطفا موارد قرمز رنگ را وارد نمایید", Toast.LENGTH_SHORT)
                    .show()




            }






                if (!binding.radioMale.isChecked&&!binding.radioFemale.isChecked&&!binding.radioNone.isChecked) {

                    binding.txtChoosingradiobtnInformation.error="انتخاب کنید"

                    Toast.makeText(this, "لطفا جنسیت خود را انتخاب نمایید", Toast.LENGTH_SHORT).show()

                }else if (binding.rdiogrpJensiat.checkedRadioButtonId!=0){
                    binding.txtChoosingradiobtnInformation.error=null

                }



                if (checkerinputesm.text!!.isNotEmpty() && checkerinputemail.text!!.isNotEmpty() && checkrdiogroup.isNotEmpty()&&checkshomaremobile.text!!.isNotEmpty()&&checkramz.text!!.isNotEmpty()&&binding.enteringEmailUser.isHelperTextEnabled&&binding.enteringPhonenumberUser.isHelperTextEnabled) {

                    binding.enteringNameUser.isErrorEnabled = false
                    binding.enteringEmailUser.isErrorEnabled = false
                    binding.enteringPhonenumberUser.isErrorEnabled=false
                    binding.enteringRamzUser.isErrorEnabled=false

                    val esmuser = binding.txtinputNameandsurename.text.toString()
                    shareprefrence.edit().putString("esmuser", esmuser).apply()


                    val emailuser = binding.txtinputEmail.text.toString()
                    shareprefrence.edit().putString("emailuser", emailuser).apply()


                    val shomareuser=binding.txtinputMobile.text.toString()
                    shareprefrence.edit().putString("shomareuser",shomareuser).apply()

                    val ramzuser=binding.txtinputRamz.text.toString()
                    shareprefrence.edit().putString("ramzuser",ramzuser).apply()

                    val addressuser=binding.txtinputAddress.text.toString()
                    shareprefrence.edit().putString("addressuser",addressuser).apply()


                    val rdiogr = binding.rdiogrpJensiat.checkedRadioButtonId.toInt()



                    if (binding.radioMale.isChecked) {

                        //یعنی کاربر ما مرد است
                        shareprefrence.edit().putInt("gendertype", 1).apply()
                        gensiatkarbar.text= "جناب آقای"

                    } else if (binding.radioFemale.isChecked) {
                        //یعنی کاربر ما زن است
                        shareprefrence.edit().putInt("gendertype", 2).apply()
                        gensiatkarbar.text= "سرکار خانم"

                    } else if (binding.radioNone.isChecked) {

                        //یعنی کاربر ما نامعلوم است
                        shareprefrence.edit().putInt("gendertype", 3).apply()
                        gensiatkarbar.text= "جناب آقای / سرکار خانم"
                    }


                }


            }


            else {


                if (checkerinputesm.text!!.isEmpty() || checkerinputemail.text!!.isEmpty() || binding.rdiogrpJensiat.isEmpty()||checkshomaremobile.text!!.isEmpty()||checkramz.text!!.isEmpty()||!binding.enteringEmailUser.isHelperTextEnabled||!binding.enteringPhonenumberUser.isHelperTextEnabled) {

                    if (checkerinputesm.text!!.isEmpty()) {

                        binding.enteringNameUser.isErrorEnabled = true
                        binding.enteringNameUser.error =
                            "لطفا نام و نام خانوادگی خود را وارد نمایید"


                    } else if (checkerinputesm.text!!.isNotEmpty()) {

                        binding.enteringNameUser.isErrorEnabled = false
                    }


                    if (checkerinputemail.text!!.isEmpty()) {
                        isEmailValid(checkaddress.text.toString())
                        binding.enteringEmailUser.isErrorEnabled = true
                        binding.enteringEmailUser.error = "لطفا ایمیل خود را وارد نمایید"

                    } else if (checkerinputemail.text!!.isNotEmpty()) {
                        isEmailValid(checkaddress.text.toString())
                        binding.enteringEmailUser.isErrorEnabled = false

                    }


                    if (checkshomaremobile.text!!.isEmpty()) {

                        binding.enteringPhonenumberUser.isErrorEnabled = true
                        binding.enteringPhonenumberUser.error = "لطفا شماره موبایل خود را وارد نمایید"

                    } else if (checkshomaremobile.text!!.isNotEmpty()) {
                        binding.enteringPhonenumberUser.isErrorEnabled = false


                    }




                    if (checkramz.text!!.isEmpty()) {

                        binding.enteringRamzUser.isErrorEnabled = true
                        binding.enteringRamzUser.error = "لطفا رمز عبور دلخواه خود را وارد نمایید"

                    } else if (checkramz.text!!.isEmpty()) {
                        binding.enteringRamzUser.isErrorEnabled = false


                    }

                    if (binding.enteringEmailUser.isHelperTextEnabled){
                        binding.enteringEmailUser.isErrorEnabled=false

                    }else{
                        binding.enteringEmailUser.error="لطفا ایمیل خود را مجددا بررسی نمایید"
                    }

                    if (binding.txtinputMobile.text!!.length<9){
                        binding.enteringPhonenumberUser.error="لطفا شماره موبایل خود را مجددا بررسی نمایید"
                    }else{
                        binding.enteringPhonenumberUser.isErrorEnabled=false
                    }

                    Toast.makeText(this, "لطفا موارد قرمز رنگ را وارد نمایید", Toast.LENGTH_SHORT).show()
                }

                if (binding.rdiogrpJensiat.checkedRadioButtonId==0) {
                    binding.txtChoosingradiobtnInformation.error="انتخاب کنید"
                    Toast.makeText(this, "لطفا جنسیت خود را انتخاب نمایید", Toast.LENGTH_SHORT).show()

                }else if (binding.rdiogrpJensiat.checkedRadioButtonId!=0){
                    binding.txtChoosingradiobtnInformation.error=null

                }


                 if (checkerinputesm.text!!.isNotEmpty() && checkerinputemail.text!!.isNotEmpty() && checkrdiogroup.isNotEmpty()&&checkshomaremobile.text!!.isNotEmpty()&&checkramz.text!!.isNotEmpty()&&binding.enteringEmailUser.isHelperTextEnabled&&binding.enteringPhonenumberUser.isHelperTextEnabled) {

                     binding.enteringNameUser.isErrorEnabled = false
                     binding.enteringEmailUser.isErrorEnabled = false
                     binding.enteringPhonenumberUser.isErrorEnabled=false
                     binding.enteringRamzUser.isErrorEnabled=false

                    val esmuser = binding.txtinputNameandsurename.text.toString()
                    shareprefrence.edit().putString("esmuser", esmuser).apply()


                    val emailuser = binding.txtinputEmail.text.toString()
                    shareprefrence.edit().putString("emailuser", emailuser).apply()


                     val shomareuser=binding.txtinputMobile.text.toString()
                     shareprefrence.edit().putString("shomareuser",shomareuser).apply()

                     val ramzuser=binding.txtinputRamz.text.toString()
                     shareprefrence.edit().putString("ramzuser",ramzuser).apply()

                     val addressuser=binding.txtinputAddress.text.toString()
                     shareprefrence.edit().putString("addressuser",addressuser).apply()


                     if (binding.radioMale.isChecked) {

                        //یعنی کاربر ما مرد است
                        shareprefrence.edit().putInt("gendertype", 1).apply()
                         gensiatkarbar.text= "جناب آقای"

                    } else if (binding.radioFemale.isChecked) {
                        //یعنی کاربر ما زن است
                        shareprefrence.edit().putInt("gendertype", 2).apply()
                         gensiatkarbar.text= "سرکار خانم"

                    } else if (binding.radioNone.isChecked) {

                        //یعنی کاربر ما نامعلوم است
                        shareprefrence.edit().putInt("gendertype", 3).apply()
                         gensiatkarbar.text= "جناب آقای / سرکار خانم"
                    }

                }

            }





            val checkesm2 = shareprefrence.contains("esmuser")
            val checkemail2 = shareprefrence.contains("emailuser")
            val checkgendertype2 = shareprefrence.contains("gendertype")
            if (checkesm2 && checkemail2 && checkgendertype2) {
                Toast.makeText(this, "اطلاعات شما با موفقیت ذخیره گردید", Toast.LENGTH_SHORT).show()
                val activityasli = Intent(this, MainActivity::class.java)
                startActivity(activityasli)

            }


        }

        binding.btnCancel.setOnClickListener {

            val pDialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
            pDialog.progressHelper.barColor = Color.parseColor("#ff001e")
            pDialog.titleText = "بارگزاری مجدد"
            pDialog.setCancelable(true)



            pDialog.titleText="عدم دسترسی به سرویس"
            pDialog.contentText="در حال تلاش برای اتصال مجدد به سرور"
            pDialog.cancelText="تلاش مجدد"
            pDialog.confirmButtonBackgroundColor = R.color.red
            pDialog.show()
            pDialog.setCancelClickListener {

                pDialog.dismissWithAnimation()
                val dialog2=SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                dialog2.titleText="ثبت نام خود را تکمیل کنید"
                dialog2.setCancelable(true)
                dialog2.contentText="متاسفانه در حال حاضر امکان استفاده از سرویس بدون ثبت نام وجود ندارد"
                dialog2.confirmText="متوجه شدم"
                dialog2.show()
            }

        }

        //دریافت اطلاعات
        val esm=shareprefrence.getString("esmuser","")
        val email=shareprefrence.getString("emailuser","")
        val gendertype=shareprefrence.getInt("gendertype",4)
        val shomare=shareprefrence.getString("shomareuser","")
        val ramz=shareprefrence.getString("ramzuser","")
        val address=shareprefrence.getString("addressuser","")



        //اعمال اطلاعات که از قبل داشتیم

        binding.txtinputNameandsurename.setText(esm)
        binding.txtinputEmail.setText(email)
        binding.txtinputMobile.setText(shomare)
        binding.txtinputRamz.setText(ramz)
        binding.txtinputAddress.setText(address)
        if (gendertype==1){

            //یعنی کاربر مرد است
            binding.radioMale.isChecked=true

        }else if (gendertype==2){

            //یعنی کاربر زن است
            binding.radioFemale.isChecked=true
        }else if (gendertype==3){


            //یعنی کاربر مشخص نکرده است
            binding.radioNone.isChecked=true

        }else{
            
        }



    }
//متد اول چک کردن ایمیل
    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    //متد دوم چک کردن  ایمیل

    fun CharSequence?.isValidEmail():Boolean{
        return this!!.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    //متد چک کردن شماره موبایل

     fun CharSequence?.isValidPhoneNumber():Boolean {
        return !isNullOrEmpty() && Patterns.PHONE.matcher(this).matches()&&binding.txtinputMobile.text!!.length==10
    }

}











