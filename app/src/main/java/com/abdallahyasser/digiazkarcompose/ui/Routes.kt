package com.abdallahyasser.digiazkarcompose.ui

import kotlinx.serialization.Serializable


@Serializable
object HomeRoute

@Serializable
object SplashRoute



@Serializable
data class DetailsRoute(
    val startDestination: String,
    val endDestination: String
)