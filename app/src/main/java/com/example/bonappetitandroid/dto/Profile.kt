package com.example.bonappetitandroid.dto

import kotlinx.serialization.Serializable

@Serializable
data class Profile(val id: Int, val FIO: String, val telephoneNumber: String, val email: String, val password: String, val role: String) {
}
