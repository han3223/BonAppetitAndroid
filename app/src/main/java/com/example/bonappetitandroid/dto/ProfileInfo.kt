package com.example.bonappetitandroid.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProfileInfo(val id: Int, val FIO: String, val telephoneNumber: String, val email: String, val password: String, val role: String) {
}
