package org.m2i.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.m2i.jettrivia.data.DataOrException
import org.m2i.jettrivia.model.QuestionItem
import org.m2i.jettrivia.repository.QuestionRepository
import javax.inject.Inject

@HiltViewModel // Async
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {

    val data : MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        getAllQuestions()
    }
    private fun getAllQuestions(){
        viewModelScope.launch {// execute in thread
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if(data.value.data.toString().isNotEmpty())
                data.value.loading = false
        }
    }

    fun getTotalQuestionCount() : Int {
        return data.value.data?.toMutableList()?.size!!
    }

}