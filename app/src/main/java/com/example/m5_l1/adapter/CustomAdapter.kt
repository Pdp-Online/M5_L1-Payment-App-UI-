package com.example.m5_l1.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

import com.example.m5_l1.R
import com.example.m5_l1.model.Fragment

class CustomAdapter(val context: Context, val fragment:List<Fragment>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_SIMPLE = 0
    private val TYPE_Button = 1


    override fun getItemViewType(position: Int): Int {
        return if (position == 2) TYPE_Button else TYPE_SIMPLE
    }





    override fun getItemCount(): Int {
        return fragment.size
    }


    inner class CustomViewHolderSimple(view: View) :RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tv_title_simple)
        val tvDescription = view.findViewById<TextView>(R.id.tv_description_simple)

        val lottieSimple = view.findViewById<LottieAnimationView>(R.id.lottie_simple)


    }

    inner class CustomViewHolderButton(view: View) :RecyclerView.ViewHolder(view) {
        val tvTitleBtn = view.findViewById<TextView>(R.id.tv_title_btn)
        val tvDescriptionBtn = view.findViewById<TextView>(R.id.tv_description_btn)

        val lottieSimpleBtn = view.findViewById<LottieAnimationView>(R.id.lottie_btn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_SIMPLE) {
            return CustomViewHolderSimple(LayoutInflater.from(parent.context).inflate(R.layout.item_intro_page, parent, false))
        }

        return CustomViewHolderButton(LayoutInflater.from(parent.context).inflate(R.layout.item_intro_button_page, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
         val fragment = fragment[position]

        if (holder is CustomViewHolderSimple) {
            holder.apply {

                tvTitle.text = fragment.title
                tvDescription.text = fragment.description

                lottieSimple.setAnimation(fragment.lottie)
            }
        }

        if (holder is CustomViewHolderButton) {
            holder.apply {

                tvTitleBtn.text = fragment.title
                tvDescriptionBtn.text = fragment.description

                lottieSimpleBtn.setAnimation(fragment.lottie)
            }
        }
    }


}