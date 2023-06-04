package com.example.bonappetitandroid.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bonappetitandroid.repository.dataClient.SupabaseDataClientProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent


data class AuthorizationState(
    val email : String = "",
    val password : String = "",
)

@Single
class AutorizationViewModel(
    private val SupabaseDataClientProfile: SupabaseDataClientProfile
): ViewModel() {
    private val _authState = MutableStateFlow(AuthorizationState())
    val authState = _authState.asStateFlow()
    fun setLogin(value: String) {
        _authState.update {
            it.copy(email = value)
        }
    }
    fun setPassword(value: String) {
        _authState.update {
            it.copy(password = value)
        }
    }



//    fun getProfile(email: String, password: String) {
//        viewModelScope.launch {
//            _authState.update {
//                it.copy(email = SupabaseDataClientProfile.getProfileData()[0].email)
//                it.copy(password = SupabaseDataClientProfile.getProfileData()[1].password)
//            }
//        }
//    }
}