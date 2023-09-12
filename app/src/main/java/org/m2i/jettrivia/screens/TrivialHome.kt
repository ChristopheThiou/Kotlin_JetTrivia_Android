package org.m2i.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import org.m2i.jettrivia.component.Question

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()){
    Question(viewModel)
}