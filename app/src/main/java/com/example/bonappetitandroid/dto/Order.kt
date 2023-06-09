package com.example.bonappetitandroid.dto

import kotlinx.datetime.DateTimeUnit
import kotlinx.serialization.Serializable

@Serializable
data class Order(val id: Int, val orderCategory: String, val foodName: String, val address: Int, val dateOrder: DateTimeUnit, val sum: Double)
