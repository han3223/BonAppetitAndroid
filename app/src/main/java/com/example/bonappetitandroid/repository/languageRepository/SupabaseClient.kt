package com.example.linguaflow.repository.languageRepository

import com.example.linguaflow.dto.Message
import io.github.jan.supabase.annotiations.SupabaseExperimental
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.plugins.standaloneSupabaseModule
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import org.koin.core.annotation.Single


@Single
class SupabaseDataClientImpl : SupabaseDataClient {
    private val supabaseUrl = "https://qyqqzftymegxiemintrs.supabase.co/"
    private val supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InF5cXF6ZnR5bWVneGllbWludHJzIiwicm9sZSI6ImFub24iLCJpYXQiOjE2Nzk4MzYyNzgsImV4cCI6MTk5NTQxMjI3OH0.7JPVILpQDuevPVj1HK-uihNh9u322o_Ow-J289mocvM"
    val client = createSupabaseClient(
        supabaseUrl,supabaseKey
    ) {
        install(Postgrest)
    }
//
    private val mypostgr = standaloneSupabaseModule(Postgrest, url = supabaseUrl, apiKey = supabaseKey)


    @OptIn(SupabaseExperimental::class)
    override suspend fun getCommonData() : List<Message> {
        println("1")
        val result = client.postgrest["public", "Test"].select().decodeList<Message>()
        println("2")
        println(result.count())
        return result
    }
    override suspend fun addData()  {
        client.postgrest["public", "Test"].insert(Message(10,"awd"))
    }
}