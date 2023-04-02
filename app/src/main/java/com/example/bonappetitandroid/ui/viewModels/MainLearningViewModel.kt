package com.example.bonappetitandroid.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bonappetitandroid.repository.languageRepository.client.dataClient.SupabaseDataClientProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent


data class MainLearningState(
    val text : String = "",
)

@Single
class MainLearningViewModel(
    private val SupabaseDataClientProfile: SupabaseDataClientProfile
): ViewModel(), KoinComponent {
    private val _mainLearningState = MutableStateFlow(MainLearningState())
    val mainLearningState = _mainLearningState.asStateFlow()

    fun getCommonData() {
        viewModelScope.launch {
            println("3")

            _mainLearningState.update {
                it.copy(text = SupabaseDataClientProfile.getProfileData()[0].FIO)
            }
            println(_mainLearningState.value.text)
        }
    }
    fun addData() {
        viewModelScope.launch {
            SupabaseDataClientProfile.addProfileData()
        }
    }
}