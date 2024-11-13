package edu.isil.proynovinstagram

data class InstagramResponse(
    val data: List<InstagramMedia>
)

data class InstagramMedia(
    val id: String,
    val caption: String?,
    val media_url: String,
    val permalink: String,
    val timestamp: String
)

