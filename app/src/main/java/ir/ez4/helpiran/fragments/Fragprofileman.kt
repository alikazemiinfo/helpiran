package ir.ez4.helpiran.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ir.ez4.helpiran.databinding.FragmentMyprofileBinding


class Fragprofileman:Fragment(),Frageditmobile.MainDialogeven2 {

    lateinit var binding:FragmentMyprofileBinding
    private lateinit var shareprefrence: SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentMyprofileBinding.inflate(layoutInflater,container,false)
        shareprefrence= requireContext().getSharedPreferences("dataavalie", Context.MODE_PRIVATE)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val esm=shareprefrence.getString("esmuser","")
        val email=shareprefrence.getString("emailuser","")
        val gendertype=shareprefrence.getInt("gendertype",4)





        binding.txtMyprofileEsm.text="$esm"



        binding.sparkButtonViraieshtelephon.setOnClickListener {

if (binding.sparkButtonEzafeaddress.isChecked||binding.sparkButtonViraieshaddress.isChecked||binding.sparkButtonViraieshemail.isChecked||binding.sparkButtonViraieshramz.isChecked||binding.sparkButtonViraieshsetting.isChecked){
    binding.sparkButtonEzafeaddress.isChecked=false
    binding.sparkButtonViraieshaddress.isChecked=false
    binding.sparkButtonViraieshemail.isChecked=false
    binding.sparkButtonViraieshramz.isChecked=false
    binding.sparkButtonEzafeaddress.isChecked=false
    binding.sparkButtonViraieshtelephon.isChecked=false

    binding.sparkButtonViraieshtelephon.playAnimation()

    binding.sparkButtonViraieshtelephon.setAnimationSpeed(1.4f)
    binding.sparkButtonViraieshtelephon.isChecked=true
}else{
    binding.sparkButtonEzafeaddress.isChecked=false
    binding.sparkButtonViraieshaddress.isChecked=false
    binding.sparkButtonViraieshemail.isChecked=false
    binding.sparkButtonViraieshramz.isChecked=false
    binding.sparkButtonEzafeaddress.isChecked=false
    binding.sparkButtonViraieshtelephon.isChecked=false

    binding.sparkButtonViraieshtelephon.playAnimation()

    binding.sparkButtonViraieshtelephon.setAnimationSpeed(1.4f)

}

            val asli = Frageditmobile(this)
            asli.show(requireActivity().supportFragmentManager, null)


        }


        binding.sparkButtonViraieshaddress.setOnClickListener {
                if (binding.sparkButtonEzafeaddress.isChecked||binding.sparkButtonViraieshaddress.isChecked||binding.sparkButtonViraieshemail.isChecked||binding.sparkButtonViraieshramz.isChecked||binding.sparkButtonViraieshsetting.isChecked){
                    binding.sparkButtonEzafeaddress.isChecked=false
                    binding.sparkButtonViraieshaddress.isChecked=false
                    binding.sparkButtonViraieshemail.isChecked=false
                    binding.sparkButtonViraieshramz.isChecked=false
                    binding.sparkButtonEzafeaddress.isChecked=false
                    binding.sparkButtonViraieshtelephon.isChecked=false

                    binding.sparkButtonViraieshaddress.playAnimation()

                    binding.sparkButtonViraieshaddress.setAnimationSpeed(1.4f)
                    binding.sparkButtonViraieshaddress.isChecked=true
                }else{
                    binding.sparkButtonEzafeaddress.isChecked=false
                    binding.sparkButtonViraieshaddress.isChecked=false
                    binding.sparkButtonViraieshemail.isChecked=false
                    binding.sparkButtonViraieshramz.isChecked=false
                    binding.sparkButtonEzafeaddress.isChecked=false
                    binding.sparkButtonViraieshtelephon.isChecked=false

                    binding.sparkButtonViraieshaddress.playAnimation()

                    binding.sparkButtonViraieshaddress.setAnimationSpeed(1.4f)

                }




            }


        binding.sparkButtonEzafeaddress.setOnClickListener {
            if (binding.sparkButtonEzafeaddress.isChecked||binding.sparkButtonViraieshaddress.isChecked||binding.sparkButtonViraieshemail.isChecked||binding.sparkButtonViraieshramz.isChecked||binding.sparkButtonViraieshsetting.isChecked){
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonEzafeaddress.playAnimation()

                binding.sparkButtonEzafeaddress.setAnimationSpeed(1.4f)
                binding.sparkButtonEzafeaddress.isChecked=true
            }else{
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonEzafeaddress.playAnimation()

                binding.sparkButtonEzafeaddress.setAnimationSpeed(1.4f)

            }




        }

        binding.sparkButtonViraieshsetting.setOnClickListener {
            if (binding.sparkButtonEzafeaddress.isChecked||binding.sparkButtonViraieshaddress.isChecked||binding.sparkButtonViraieshemail.isChecked||binding.sparkButtonViraieshramz.isChecked||binding.sparkButtonViraieshsetting.isChecked){
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonViraieshsetting.playAnimation()

                binding.sparkButtonViraieshsetting.setAnimationSpeed(1.4f)
                binding.sparkButtonViraieshsetting.isChecked=true
            }else{
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonViraieshsetting.playAnimation()

                binding.sparkButtonViraieshsetting.setAnimationSpeed(1.4f)

            }




        }

        binding.sparkButtonViraieshemail.setOnClickListener {
            if (binding.sparkButtonEzafeaddress.isChecked||binding.sparkButtonViraieshaddress.isChecked||binding.sparkButtonViraieshemail.isChecked||binding.sparkButtonViraieshramz.isChecked||binding.sparkButtonViraieshsetting.isChecked){
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonViraieshemail.playAnimation()

                binding.sparkButtonViraieshemail.setAnimationSpeed(1.4f)
                binding.sparkButtonViraieshemail.isChecked=true
            }else{
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonViraieshemail.playAnimation()

                binding.sparkButtonViraieshemail.setAnimationSpeed(1.4f)

            }




        }

        binding.sparkButtonViraieshramz.setOnClickListener {
            if (binding.sparkButtonEzafeaddress.isChecked||binding.sparkButtonViraieshaddress.isChecked||binding.sparkButtonViraieshemail.isChecked||binding.sparkButtonViraieshramz.isChecked||binding.sparkButtonViraieshsetting.isChecked){
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonViraieshramz.playAnimation()

                binding.sparkButtonViraieshramz.setAnimationSpeed(1.4f)
                binding.sparkButtonViraieshramz.isChecked=true
            }else{
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshaddress.isChecked=false
                binding.sparkButtonViraieshemail.isChecked=false
                binding.sparkButtonViraieshramz.isChecked=false
                binding.sparkButtonEzafeaddress.isChecked=false
                binding.sparkButtonViraieshtelephon.isChecked=false

                binding.sparkButtonViraieshramz.playAnimation()

                binding.sparkButtonViraieshramz.setAnimationSpeed(1.4f)

            }




        }







    }

    override fun sent_text_data(data: String) {

        Toast.makeText(context, "شماره شما با موفقیت به $data تغییر کرد", Toast.LENGTH_SHORT).show()
        binding.txtNamayeshShomareuserinprofile.text=data

    }


}