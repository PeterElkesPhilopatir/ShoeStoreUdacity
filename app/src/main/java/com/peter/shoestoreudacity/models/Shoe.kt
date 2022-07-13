package com.peter.shoestoreudacity.models

import java.io.Serializable

data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Serializable