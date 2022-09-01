package ir.ez4.helpiran.thread

import android.util.Log

class threadfirst:Thread() {


    override fun run() {
        super.run()


        //اسم فعلی ترد را نمایش می دهد
        Log.v("statusthread", currentThread().name)
    }
}