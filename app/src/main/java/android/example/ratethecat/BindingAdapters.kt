package android.example.ratethecat

import android.example.ratethecat.list.CatApiStatus
import android.example.ratethecat.list.ItemGridAdapter
import android.example.ratethecat.network.CatProperty
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CatProperty>?) {
    val adapter = recyclerView.adapter as ItemGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String? ){
    imgUrl?.let {
        var imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("catApiStatus")
fun bindStatus(statusImgView: ImageView, status: CatApiStatus?) {
    when(status){
        CatApiStatus.LOADING -> {
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.loading_animation)
        }
        CatApiStatus.DONE -> {
            statusImgView.visibility = View.GONE
        }
        CatApiStatus.ERROR -> {
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("likeImage")
fun tintLikeButton(imgView: ImageView, voteValue: String?){
    voteValue?.let {
        if (voteValue.toInt() == 1) {
            imgView.setColorFilter(Color.argb(100, 76, 175, 80))
        }
    }
}

@BindingAdapter("dislikeImage")
fun tintDislikeButton(imgView: ImageView, voteValue: String?){
    voteValue?.let {
        if (voteValue.toInt() == 0) {
            imgView.setColorFilter(Color.argb(100, 244, 67, 54))
        }
    }
}

