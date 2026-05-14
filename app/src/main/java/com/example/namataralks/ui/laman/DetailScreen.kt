package com.example.namataralks.ui.laman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.namataralks.R
import com.example.namataralks.databinding.ActivityDetailBinding

class DetailScreen : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var isBookmarked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent
        val name = intent.getStringExtra("NAME")
        val price = intent.getIntExtra("PRICE", 0)
        val location = intent.getStringExtra("LOCATION")
        val opening = intent.getStringExtra("OPENING")
        val desc = intent.getStringExtra("DESC")
        val rating = intent.getIntExtra("RATING", 0)
        val image = intent.getStringExtra("IMAGE")

        binding.tvTitle.text = name
        binding.tvPrice.text = "Rp $price"
        binding.tvLocation.text = "Lokasi: $location"
        binding.tvOpenHours.text = "Jam Buka: $opening"
        binding.tvDescription.text = desc
        binding.ratingBar.rating = rating.toFloat()

        val imageUrl = "http://10.0.2.2:5000/$image"
        binding.imgTourism.load(imageUrl)

        // Rating bisa diubah user
        binding.ratingBar.setOnRatingBarChangeListener { _, newRating, _ ->
            // bisa simpan ke database / kirim ke API nanti
        }

        // Bookmark toggle
        binding.btnBookmark.setOnClickListener {

            isBookmarked = !isBookmarked

            if (isBookmarked) {
                binding.btnBookmark.setImageResource(R.drawable.baseline_bookmarks_24)
            } else {
                binding.btnBookmark.setImageResource(R.drawable.ic_bookmark_border)
            }
        }
    }
}
