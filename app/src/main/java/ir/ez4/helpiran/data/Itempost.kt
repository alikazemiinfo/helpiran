package ir.ez4.helpiran.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Itempost (val imgurl:String, val txt_title:String, val txt_subtitle:String, val txt_describtion:String

                     ,
                     val trend:Boolean, val insight:String
):Parcelable