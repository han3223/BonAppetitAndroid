package com.example.bonappetitandroid.repository.languageRepository.client.dataClient

import com.example.bonappetitandroid.dto.ProfileInfo

interface SupabaseDataClientProfile {
    suspend fun getProfileData(): List<ProfileInfo>
    suspend fun addProfileData()
    suspend fun deleteProfileData()
}