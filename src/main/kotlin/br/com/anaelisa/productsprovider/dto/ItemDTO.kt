package br.com.anaelisa.productsprovider.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemDTO(
    val zipCode: String,
    val id: Double,
    val eanGtin: String,
)
