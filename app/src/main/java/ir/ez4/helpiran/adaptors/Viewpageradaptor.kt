package ir.ez4.helpiran.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import ir.ez4.helpiran.R
import ir.ez4.helpiran.activities.MainActivity
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


//private val imageList: ArrayList<Int>, private val viewPager2: ViewPager2
    class Viewpageradaptor(urlaksha: ArrayList<String>) :
    SliderViewAdapter<Viewpageradaptor.SliderViewHolder>() {
    private var context: Context? = null

    var activity: MainActivity? = null

    var sliderList: ArrayList<String> = urlaksha

    override fun getCount(): Int {
        // in this method we are returning
        // the size of our slider list.
        return sliderList.size
    }

    // on below line we are calling on create view holder method.
    override fun onCreateViewHolder(parent: ViewGroup?): Viewpageradaptor.SliderViewHolder {
            // create a new view
        // set the view's size, margins, paddings and layout parameters

        // set the Context here

        // inside this method we are inflating our layout file for our slider view.
        val inflate: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_pagekhanloaderaks, null)
        context = parent.context
        // on below line we are simply passing
        // the view to our slider view holder.
        return SliderViewHolder(inflate)
    }

    // on below line we are calling on bind view holder method to set the data to our image view.
    override fun onBindViewHolder(viewHolder: Viewpageradaptor.SliderViewHolder?, position: Int) {


        // on below line we are checking if the view holder is null or not.
        if (viewHolder != null) {
            // if view holder is not null we are simply
            // loading the image inside our image view using glide library
            Glide.with(viewHolder.itemView).load(sliderList.get(position)).transform(
                RoundedCornersTransformation(40,12)
            ).fitCenter()
                .into(viewHolder.imageView)
        }

        viewHolder!!.itemView.setOnClickListener {
            Toast.makeText(
                context,
                "شما بر روی آیتم شماره $position کلیک کردید",
                Toast.LENGTH_SHORT
            ).show()
        }
    }



    // on below line we are creating a class for slider view holder.
    class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {

        // on below line we are creating a variable for our
        // image view and initializing it with image id.
        var imageView: ImageView = itemView!!.findViewById(R.id.myimage)



    }

        class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            val imageView: ImageView = itemView.findViewById(R.id.imageView22);


        }



    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }



//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
////            val view =
////                LayoutInflater.from(parent.context).inflate(R.layout.item_pagekhanloaderaks, parent, false)
////            return ImageViewHolder(view)
//        }


    }









//override fun onBindViewHolder(holder: Viewpageradaptor.ImageViewHolder, position: Int) {
//    holder.imageView.setImageResource(imageList[position])
//    if (position == imageList.size-1){
//        viewPager2.post(runnable)
//    }
//}
//
//override fun getItemCount(): Int {
//    return imageList.size
//}
//
//private val runnable = Runnable {
//    imageList.addAll(imageList)
//    notifyDataSetChanged()
//}