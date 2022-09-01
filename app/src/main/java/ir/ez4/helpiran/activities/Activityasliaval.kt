package ir.ez4.helpiran.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
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
        if (checkesm && checkemail && checkgendertype) {
            val activityasli = Intent(this, MainActivity::class.java)
            startActivity(activityasli)

        }

//اعمال اطلاعات
        binding.btnTaid.setOnClickListener {

            val checkerinputesm = binding.txtinputNameandsurename
            val checkerinputemail = binding.txtinputEmail
            val checkrdiogroup = binding.rdiogrpJensiat


            if (checkerinputesm.text!!.isEmpty() || checkerinputemail.text!!.isEmpty() || binding.rdiogrpJensiat.isEmpty()){



            if (checkerinputesm.text!!.isEmpty() || checkerinputemail.text!!.isEmpty() || binding.rdiogrpJensiat.isEmpty()) {

                if (checkerinputesm.text!!.isEmpty()) {

                    binding.enteringNameUser.isErrorEnabled = true
                    binding.enteringNameUser.error = "لطفا نام و نام خانوادگی خود را وارد نمایید"


                } else if (checkerinputesm.text!!.isNotEmpty()) {

                    binding.enteringNameUser.isErrorEnabled = false
                }


                if (checkerinputemail.text!!.isEmpty()) {

                    binding.enteringEmailUser.isErrorEnabled = true
                    binding.enteringEmailUser.error = "لطفا ایمیل خود را وارد نمایید"

                } else if (checkerinputemail.text!!.isNotEmpty()) {
                    binding.enteringEmailUser.isErrorEnabled = false

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



                if (checkerinputesm.text!!.isNotEmpty() && checkerinputemail.text!!.isNotEmpty() && checkrdiogroup.isNotEmpty()) {

                    binding.enteringNameUser.isErrorEnabled = false
                    binding.enteringEmailUser.isErrorEnabled = false


                    val esmuser = binding.txtinputNameandsurename.text.toString()
                    shareprefrence.edit().putString("esmuser", esmuser).apply()


                    val emailuser = binding.txtinputEmail.text.toString()
                    shareprefrence.edit().putString("emailuser", emailuser).apply()


                    val rdiogr = binding.rdiogrpJensiat.checkedRadioButtonId.toInt()

                    if (binding.radioMale.isChecked) {

                        //یعنی کاربر ما مرد است
                        shareprefrence.edit().putInt("gendertype", 1).apply()

                    } else if (binding.radioFemale.isChecked) {
                        //یعنی کاربر ما زن است
                        shareprefrence.edit().putInt("gendertype", 2).apply()

                    } else if (binding.radioNone.isChecked) {

                        //یعنی کاربر ما نامعلوم است
                        shareprefrence.edit().putInt("gendertype", 3).apply()
                    }


                }


            }


            else {


                if (checkerinputesm.text!!.isEmpty() || checkerinputemail.text!!.isEmpty() || binding.rdiogrpJensiat.isEmpty()) {

                    if (checkerinputesm.text!!.isEmpty()) {

                        binding.enteringNameUser.isErrorEnabled = true
                        binding.enteringNameUser.error =
                            "لطفا نام و نام خانوادگی خود را وارد نمایید"


                    } else if (checkerinputesm.text!!.isNotEmpty()) {

                        binding.enteringNameUser.isErrorEnabled = false
                    }


                    if (checkerinputemail.text!!.isEmpty()) {

                        binding.enteringEmailUser.isErrorEnabled = true
                        binding.enteringEmailUser.error = "لطفا ایمیل خود را وارد نمایید"

                    } else if (checkerinputemail.text!!.isNotEmpty()) {
                        binding.enteringEmailUser.isErrorEnabled = false

                    }
                    Toast.makeText(this, "لطفا موارد قرمز رنگ را وارد نمایید", Toast.LENGTH_SHORT).show()
                }

                if (binding.rdiogrpJensiat.checkedRadioButtonId==0) {
                    binding.txtChoosingradiobtnInformation.error="انتخاب کنید"
                    Toast.makeText(this, "لطفا جنسیت خود را انتخاب نمایید", Toast.LENGTH_SHORT).show()

                }else if (binding.rdiogrpJensiat.checkedRadioButtonId!=0){
                    binding.txtChoosingradiobtnInformation.error=null

                }


                 if (checkerinputesm.text!!.isNotEmpty() && checkerinputemail.text!!.isNotEmpty() && checkrdiogroup.isNotEmpty()) {

                    binding.enteringNameUser.isErrorEnabled = false
                    binding.enteringEmailUser.isErrorEnabled = false


                    val esmuser = binding.txtinputNameandsurename.text.toString()
                    shareprefrence.edit().putString("esmuser", esmuser).apply()


                    val emailuser = binding.txtinputEmail.text.toString()
                    shareprefrence.edit().putString("emailuser", emailuser).apply()


                    if (binding.radioMale.isChecked) {

                        //یعنی کاربر ما مرد است
                        shareprefrence.edit().putInt("gendertype", 1).apply()

                    } else if (binding.radioFemale.isChecked) {
                        //یعنی کاربر ما زن است
                        shareprefrence.edit().putInt("gendertype", 2).apply()

                    } else if (binding.radioNone.isChecked) {

                        //یعنی کاربر ما نامعلوم است
                        shareprefrence.edit().putInt("gendertype", 3).apply()
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
        


        //اعمال اطلاعات که از قبل داشتیم

        binding.txtinputNameandsurename.setText(esm)
        binding.txtinputEmail.setText(email)
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



    }}











