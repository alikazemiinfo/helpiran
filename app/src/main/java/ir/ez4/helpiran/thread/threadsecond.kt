package ir.ez4.helpiran.thread

import android.util.Log

class threadsecond:Runnable {



    override fun run() {

        Log.v("statusthread", Thread.currentThread().name)


    }


}