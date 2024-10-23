package com.example.exercise_99group.domain.model

data class ApartmentResponse(
    val address: Address,
    val attributes: Attributes,
    val category: String,
    val completed_at: String,
    val id: Int,
    val photo: String,
    val project_name: String,
    val tenure: Int
)

data class Address(
    val district: String,
    val street_name: String
)

data class Attributes(
    val area_size: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)