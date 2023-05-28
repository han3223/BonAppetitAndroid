package com.example.bonappetitandroid.ui.viewModels

import com.example.bonappetitandroid.repository.dataClient.SupabaseDataClientProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import org.koin.core.annotation.Single

data class RegistrationState(
    val login: String = "",
    val password: String = "",
    val name: String = "",
    val email: String = ""
)

@Single
class SingUpViewModel(
    private val SupabaseDataClientProfile: SupabaseDataClientProfile
) {
    private val _singUpState = MutableStateFlow(RegistrationState())
    val singUpState = _singUpState.asStateFlow()

    fun setLogin(value: String) {
        _singUpState.update {
            it.copy(login = value)

        }
    }
    fun setPassword(value: String) {
        _singUpState.update {
            it.copy(password = value)
        }
    }
    fun setName(value: String) {
        _singUpState.update {
            it.copy(name = value)
        }
    }

    fun setEmail(value: String) {
        _singUpState.update {
            it.copy(email = value)
        }
    }

    suspend fun addProfile() {
        SupabaseDataClientProfile.addProfileData()
    }
}