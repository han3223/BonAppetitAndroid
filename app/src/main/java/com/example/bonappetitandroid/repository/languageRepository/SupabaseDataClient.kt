package com.example.linguaflow.repository.languageRepository

import com.example.linguaflow.dto.Message

interface SupabaseDataClient {
    suspend fun getCommonData(): List<Message>
    suspend fun addData()
}