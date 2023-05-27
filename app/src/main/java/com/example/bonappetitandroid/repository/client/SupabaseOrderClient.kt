package com.example.bonappetitandroid.repository.client

import com.example.bonappetitandroid.dto.OrderInfo
import com.example.bonappetitandroid.repository.dataClient.SupabaseDataClientOrder
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.plugins.standaloneSupabaseModule
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest

class SupabaseOrderClient : SupabaseDataClientOrder {
    private val supabaseUrl = "https://qyqqzftymegxiemintrs.supabase.co/"
    private val supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InF5cXF6ZnR5bWVneGllbWludHJzIiwicm9sZSI6ImFub24iLCJpYXQiOjE2Nzk4MzYyNzgsImV4cCI6MTk5NTQxMjI3OH0.7JPVILpQDuevPVj1HK-uihNh9u322o_Ow-J289mocvM"
    val client = createSupabaseClient(
        supabaseUrl,supabaseKey
    ) {
        install(Postgrest)
    }

    private val mypostgr = standaloneSupabaseModule(Postgrest, url = supabaseUrl, apiKey = supabaseKey)

    override suspend fun getOrderData(): List<OrderInfo> {
        val result = client.postgrest["public", "Order"].select().decodeList<OrderInfo>()
        return result
    }

    override suspend fun addOrderData() {
        val insert = client.postgrest["public", "Order"].insert(OrderInfo)
    }
}