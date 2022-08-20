package ir.ez4.helpiran.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.ez4.helpiran.data.Itempost
import ir.ez4.helpiran.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import java.util.ArrayList

class trendadaptor(private val data:ArrayList<Itempost>, private val itemevent: Itemevent):RecyclerView.Adapter<trendadaptor.TrendViewHolder> (){

    lateinit var binding:ItemTrendBinding

    inner class TrendViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){


        fun bindview(itempost: Itempost){

            Glide.with(binding.root.context).load(itempost.imgurl)
                .transform(RoundedCornersTransformation(24,8))
                .into(binding.imgCardTrend)


            binding.txtTitleTrend.text=itempost.txt_title
            binding.txtSubTrend.text=itempost.txt_subtitle
            binding.txtEmtiazTrend.text=itempost.insight
            binding.txtNumTrend.text=(adapterPosition+1).toString()


            itemView.setOnClickListener {

                itemevent.onitemclicked(itempost)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {

        binding= ItemTrendBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {

        holder.bindview(data[position])
    }

    override fun getItemCount(): Int {

        return data.size
    }
}