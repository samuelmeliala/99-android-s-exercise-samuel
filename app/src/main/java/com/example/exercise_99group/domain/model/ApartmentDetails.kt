package com.example.exercise_99group.domain.model

data class ApartmentDetailsResponse(
    val address: Address,
    val attributes: Attributes,
    val description: String,
    val id: Int,
    val photo: String,
    val project_name: String,
    val property_details: List<PropertyDetail>
)

data class AddressDetails(
    val title: String,
    val subtitle: String,
    val map_coordinates: MapCoordinates
)

data class MapCoordinates(
    val lat: Double,
    val lng: Double
)

data class AttributesDetails(
    val area_size: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)

data class PropertyDetail(
    val label: String,
    val text: String
)
