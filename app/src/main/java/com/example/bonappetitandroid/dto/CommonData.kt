package com.example.linguaflow.dto

import kotlinx.serialization.Serializable

@Serializable
data class Message(val id: Int, val string: String)