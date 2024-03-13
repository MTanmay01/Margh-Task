package com.example.margh

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.margh.databinding.ViewpagerItemBinding
import com.example.margh.models.QuoteItem
import com.example.margh.models.dummyQuoteUrls

class QuoteAdapter(
    private val quotesList: List<QuoteItem> = dummyQuoteUrls()
) : RecyclerView.Adapter<QuoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = ViewpagerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(quotesList[position])
    }

    override fun getItemCount(): Int = quotesList.size
}

class QuoteViewHolder(
    private val binding: ViewpagerItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val context = binding.root.context

    val progressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }

    fun bind(item: QuoteItem) {
        Glide.with(context)
            .asBitmap()
            .load(item.imageUrl)
            .error(R.drawable.ic_error)
            .placeholder(progressDrawable)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadStarted(placeholder: Drawable?) {
                    binding.quoteImg.setImageDrawable(progressDrawable)
                }

                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    binding.quoteImg.setImageDrawable(resource.toDrawable(context.resources))

                    Palette.from(resource).generate {
                        binding.root.setBackgroundColor(
                            it?.getDominantColor(
                                context.resources.getColor(R.color.black)
                            )!!
                        )
                    }
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    binding.quoteImg.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            context.resources,
                            R.drawable.ic_error,
                            context.theme
                        )
                    )
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })

    }
}