package com.example.bonappetitandroid.repository.dataClient

import com.example.bonappetitandroid.dto.OrderInfo

interface SupabaseDataClientOrder {
    suspend fun getOrderData(): List<OrderInfo>
    suspend fun addOrderData()
}