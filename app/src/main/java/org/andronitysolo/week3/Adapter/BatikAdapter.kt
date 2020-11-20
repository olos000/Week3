package org.andronitysolo.week3.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_batik_detail.view.*
import kotlinx.android.synthetic.main.cardviewbatik.view.*
import kotlinx.android.synthetic.main.cardviewbatik.view.img_photo
import kotlinx.android.synthetic.main.cardviewbatik.view.txt_deskripsi
import kotlinx.android.synthetic.main.cardviewbatik.view.txt_name
import org.andronitysolo.week3.Activity.BatikDetailActivity
import org.andronitysolo.week3.Model.Batik.HasilItem
import org.andronitysolo.week3.R


class BatikAdapter(val activity: Activity?) :
        RecyclerView.Adapter<BatikAdapter.BatikViewHolder>() {
    private var data: List<HasilItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikViewHolder {
        val viem = LayoutInflater.from(parent.context).inflate(R.layout.cardviewbatik , parent, false)
        return BatikViewHolder(viem)
    }

    override fun onBindViewHolder(holder: BatikViewHolder, position: Int) {
       holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun swapData(data: List<HasilItem>) {
        this.data = data
        notifyDataSetChanged()
    }


    inner class BatikViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(batik : HasilItem){
            with(itemView){
                Glide.with(itemView.context)
                        .load(batik.linkBatik)
                        .apply(RequestOptions().override(350, 550))
                        .dontAnimate()
                        .into(img_photo)

                txt_name.text = batik.namaBatik
                txt_deskripsi.text = batik.maknaBatik
                txt_hargard.text = batik.hargaRendah.toString()
                txt_hargaMahl.text = batik.hargaTinggi.toString()
                card_view.setOnClickListener {
                    val movActivty = Intent(activity, BatikDetailActivity::class.java)
                    activity?.startActivity(movActivty)
                }




            }
        }
    }


}