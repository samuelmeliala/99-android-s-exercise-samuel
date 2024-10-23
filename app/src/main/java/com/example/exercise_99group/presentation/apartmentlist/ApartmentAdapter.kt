package com.example.exercise_99group.presentation.apartmentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exercise_99group.R
import com.example.exercise_99group.domain.model.ApartmentResponse

class ApartmentAdapter(private val apartments: List<ApartmentResponse>) :
    RecyclerView.Adapter<ApartmentAdapter.ApartmentViewHolder>() {

    class ApartmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val apartmentImage: ImageView = itemView.findViewById(R.id.apartmentImage)
        val apartmentTitle: TextView = itemView.findViewById(R.id.apartmentTitle)
        val apartmentAddress: TextView = itemView.findViewById(R.id.apartmentAddress)
        val apartmentDetails: TextView = itemView.findViewById(R.id.apartmentDetails)
        val apartmentPrice: TextView = itemView.findViewById(R.id.apartmentPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_apartment, parent, false)
        return ApartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApartmentViewHolder, position: Int) {
        val apartment = apartments[position]

        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(apartment.photo)
            .into(holder.apartmentImage)

        holder.apartmentTitle.text = apartment.project_name
        holder.apartmentAddress.text = "${apartment.address.street_name} - ${apartment.address.district}"
        holder.apartmentDetails.text = "${apartment.attributes.bedrooms} Beds · ${apartment.attributes.bathrooms} Baths · ${apartment.attributes.area_size} sqft"
        holder.apartmentPrice.text = "$${apartment.attributes.price}/mo"
    }

    override fun getItemCount() = apartments.size
}