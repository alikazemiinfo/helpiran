package ir.ez4.helpiran.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import ir.ez4.helpiran.R
import ir.ez4.helpiran.databinding.ActivityActivitychipmanagerBinding
import ir.ez4.helpiran.databinding.FragmentChipmanagerBinding
import ir.ez4.helpiran.databinding.FragmentKhaneBinding
import ir.ez4.helpiran.databinding.FragmentMyprofileBinding

class Fragchipmanager:Fragment() {

    lateinit var binding:FragmentChipmanagerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentChipmanagerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            binding.chipKhane.isCheckable=true
            binding.chipMyprofile.isCheckable=true
            binding.chipDarbarema.isCheckable=true
            binding.chipContactus.isCheckable=true
            binding.chipPorbazdid.isCheckable=true


            binding.chipKhane.setOnClickListener {
                if (binding.chipKhane.isChecked || binding.chipPorbazdid.isChecked || binding.chipMyprofile.isChecked || binding.chipDarbarema.isChecked||binding.chipContactus.isChecked){


                    binding.chipMyprofile.isChecked=false
                    binding.chipDarbarema.isChecked=false
                    binding.chipContactus.isChecked=false
                    binding.chipPorbazdid.isChecked=false
                    binding.chipKhane.isChecked=true
                    binding.chipKhane.iconEndPadding=20F
                    binding.chipKhane.iconStartPadding= 20F
                    Snackbar.make(binding.root,"اندروید", Snackbar.LENGTH_LONG).setAnchorView(R.id.btn_nav).setAction("کلیک"){binding.chipKhane.isChecked=false
                        binding.chipKhane.iconStartPadding=0f
                        binding.chipKhane.iconEndPadding=0f
                    }.show()

                }else{
                    binding.chipKhane.iconStartPadding=0f
                    binding.chipKhane.iconEndPadding=0f
                    binding.chipKhane.isChecked=false
                }



            }
            binding.chipPorbazdid.setOnClickListener {
                if (binding.chipKhane.isChecked || binding.chipPorbazdid.isChecked || binding.chipMyprofile.isChecked || binding.chipDarbarema.isChecked||binding.chipContactus.isChecked){


                    binding.chipMyprofile.isChecked=false
                    binding.chipDarbarema.isChecked=false
                    binding.chipContactus.isChecked=false
                    binding.chipPorbazdid.isChecked=true
                    binding.chipKhane.isChecked=false
                    binding.chipPorbazdid.iconEndPadding=20F
                    binding.chipPorbazdid.iconStartPadding= 20F
                    Snackbar.make(binding.root,"اندروید", Snackbar.LENGTH_LONG).setAnchorView(R.id.btn_nav).setAction("کلیک"){binding.chipPorbazdid.isChecked=false
                        binding.chipPorbazdid.iconStartPadding=0f
                        binding.chipPorbazdid.iconEndPadding=0f
                    }.show()

                }else{
                    binding.chipPorbazdid.iconStartPadding=0f
                    binding.chipPorbazdid.iconEndPadding=0f
                    binding.chipPorbazdid.isChecked=false
                }
            }
            binding.chipContactus.setOnClickListener {
                if (binding.chipKhane.isChecked || binding.chipPorbazdid.isChecked || binding.chipMyprofile.isChecked || binding.chipDarbarema.isChecked||binding.chipContactus.isChecked){


                    binding.chipMyprofile.isChecked=false
                    binding.chipDarbarema.isChecked=false
                    binding.chipContactus.isChecked=true
                    binding.chipPorbazdid.isChecked=false
                    binding.chipKhane.isChecked=false
                    binding.chipContactus.iconEndPadding=20F
                    binding.chipContactus.iconStartPadding= 20F
                    Snackbar.make(binding.root,"اندروید", Snackbar.LENGTH_LONG).setAnchorView(R.id.btn_nav).setAction("کلیک"){binding.chipContactus.isChecked=false
                        binding.chipContactus.iconStartPadding=0f
                        binding.chipContactus.iconEndPadding=0f
                    }.show()

                }else{
                    binding.chipContactus.iconStartPadding=0f
                    binding.chipContactus.iconEndPadding=0f
                    binding.chipContactus.isChecked=false
                }
            }
            binding.chipDarbarema.setOnClickListener {
                if (binding.chipKhane.isChecked || binding.chipPorbazdid.isChecked || binding.chipMyprofile.isChecked || binding.chipDarbarema.isChecked||binding.chipContactus.isChecked){


                    binding.chipMyprofile.isChecked=false
                    binding.chipDarbarema.isChecked=true
                    binding.chipContactus.isChecked=false
                    binding.chipPorbazdid.isChecked=false
                    binding.chipKhane.isChecked=false
                    binding.chipDarbarema.iconEndPadding=20F
                    binding.chipDarbarema.iconStartPadding= 20F
                    Snackbar.make(binding.root,"اندروید", Snackbar.LENGTH_LONG).setAnchorView(R.id.btn_nav).setAction("کلیک"){binding.chipDarbarema.isChecked=false
                        binding.chipDarbarema.iconStartPadding=0f
                        binding.chipDarbarema.iconEndPadding=0f
                    }.show()

                }else{
                    binding.chipDarbarema.iconStartPadding=0f
                    binding.chipDarbarema.iconEndPadding=0f
                    binding.chipDarbarema.isChecked=false
                }
            }
            binding.chipMyprofile.setOnClickListener {
                if (binding.chipKhane.isChecked || binding.chipPorbazdid.isChecked || binding.chipMyprofile.isChecked || binding.chipDarbarema.isChecked||binding.chipContactus.isChecked){


                    binding.chipMyprofile.isChecked=true
                    binding.chipDarbarema.isChecked=false
                    binding.chipContactus.isChecked=false
                    binding.chipPorbazdid.isChecked=false
                    binding.chipKhane.isChecked=false
                    binding.chipMyprofile.iconEndPadding=20F
                    binding.chipMyprofile.iconStartPadding= 20F
                    Snackbar.make(binding.root,"اندروید", Snackbar.LENGTH_LONG).setAnchorView(R.id.btn_nav).setAction("کلیک"){binding.chipMyprofile.isChecked=false
                        binding.chipMyprofile.iconStartPadding=0f
                        binding.chipMyprofile.iconEndPadding=0f
                    }.show()

                }else{
                    binding.chipMyprofile.iconStartPadding=0f
                    binding.chipMyprofile.iconEndPadding=0f
                    binding.chipMyprofile.isChecked=false
                }
            }


            binding.chipgroupMainJaleb.setOnCheckedChangeListener { group, checkedId ->

                when(checkedId){

                    R.id.chip_darbarema->{
                        Toast.makeText(context, "سلام", Toast.LENGTH_SHORT).show()}
                }

            }
        }


    }