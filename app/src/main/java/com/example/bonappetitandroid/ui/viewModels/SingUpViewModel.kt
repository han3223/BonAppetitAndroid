package com.example.bonappetitandroid.ui.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bonappetitandroid.repository.dataClient.SupabaseDataClientProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    suspend fun registration(email: MutableState<TextFieldValue>, password: String) {
        if(singUpState.value.email.equals(SupabaseDataClientProfile.getEmail()) && singUpState.value.password.equals(SupabaseDataClientProfile.getPassword())) {
            SupabaseDataClientProfile.addProfileData()
        }
    }
}