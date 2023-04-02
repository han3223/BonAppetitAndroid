package com.example.bonappetitandroid.repository.languageRepository.client.dataClient

import com.example.bonappetitandroid.dto.OrderInfo

interface SupabaseDataClientOrder {
    suspend fun getOrderData(): List<OrderInfo>
    suspend fun addOrderData()
}