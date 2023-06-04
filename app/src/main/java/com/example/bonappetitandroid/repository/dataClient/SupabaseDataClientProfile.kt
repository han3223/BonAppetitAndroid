package com.example.bonappetitandroid.repository.dataClient

import com.example.bonappetitandroid.dto.Profile

interface SupabaseDataClientProfile {
    suspend fun getProfileData(): List<Profile>
    suspend fun addProfileData()
    suspend fun deleteProfileData()

    suspend fun getEmail(): List<Profile>
    suspend fun getPassword(): List<Profile>
}