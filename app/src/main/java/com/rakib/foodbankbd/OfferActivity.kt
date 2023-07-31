package com.rakib.foodbankbd

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rakib.foodbankbd.databinding.ActivityOfferBinding
import com.rakib.foodbankbd.entities.OfferObject

class OfferActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var gson: Gson
    private lateinit var binding: ActivityOfferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfferBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val gsonBuilder = GsonBuilder()
        gson = gsonBuilder.create()

        val offerInStringFormat = intent.extras?.getString("OFFER_CODE")
        val singleOffer = gson.fromJson(offerInStringFormat, OfferObject::class.java)

        if (singleOffer != null) {
            binding.imageViewOfferImage.setImageResource(singleOffer.offerImage)
            binding.textViewOfferName.append(singleOffer.offerName)
            binding.textViewOfferLocation.append(singleOffer.offerLocation)
            binding.textViewOfferPrice.append(singleOffer.offerPrice.toString())
            binding.textViewOfferDuration.append(singleOffer.offerDuration)
            binding.textViewOfferItem.append(singleOffer.offerItem)
            binding.textViewOfferDescription.append(singleOffer.offerDescription)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.textViewOfferLocation -> Toast.makeText(
                this@OfferActivity,
                "This feature is coming soon!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}