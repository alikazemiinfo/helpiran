package ir.ez4.helpiran.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.ez4.helpiran.data.itempost
import ir.ez4.helpiran.databinding.ItemPorbazdidBinding
import java.util.ArrayList

class porbazdidadaptor(private val data:ArrayList<itempost>):RecyclerView.Adapter<porbazdidadaptor.Explorerholder> (){

    lateinit var binding:ItemPorbazdidBinding

    inner class Explorerholder(itemView:View):RecyclerView.ViewHolder(itemView){


        fun bindview(itempost: itempost){

            val glide=Glide.with(itemView.context).load(itempost.imgurl).into(binding.imgExplorerMain)

            binding.txtExplorTitle.text=itempost.txt_title
            binding.txtExplorSubtitle.text=itempost.txt_subtitle
            binding.txtExplorDetail.text=itempost.txt_describtion

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Explorerholder {

        binding= ItemPorbazdidBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Explorerholder(binding.root)
    }

    override fun onBindViewHolder(holder: Explorerholder, position: Int) {

        holder.bindview(data[position])
    }

    override fun getItemCount(): Int {

        return data.size
    }
}