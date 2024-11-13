package edu.isil.proynovinstagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class InstagramAdapter : RecyclerView.Adapter<InstagramAdapter.InstagramViewHolder>() {

    private var mediaList = listOf<InstagramMedia>()

    fun submitList(list: List<InstagramMedia>) {
        mediaList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstagramViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_instagram_media, parent, false)
        return InstagramViewHolder(view)
    }

    override fun onBindViewHolder(holder: InstagramViewHolder, position: Int) {
        holder.bind(mediaList[position])
    }

    override fun getItemCount() = mediaList.size

    class InstagramViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val captionTextView: TextView = itemView.findViewById(R.id.captionTextView)
        private val mediaImageView: ImageView = itemView.findViewById(R.id.mediaImageView)

        fun bind(media: InstagramMedia) {
            captionTextView.text = media.caption
            Glide.with(itemView.context).load(media.media_url).into(mediaImageView)
        }
    }
}
