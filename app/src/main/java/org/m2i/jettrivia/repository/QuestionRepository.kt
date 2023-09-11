package org.m2i.jettrivia.repository

import android.util.Log
import org.m2i.jettrivia.data.DataOrException
import org.m2i.jettrivia.model.Question
import org.m2i.jettrivia.model.QuestionItem
import org.m2i.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val listOfQuestions = DataOrException<ArrayList<QuestionItem>,Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>,Boolean, Exception>{
        try {
            listOfQuestions.loading = true
            listOfQuestions.data = api.getAllQuestions()
            if (listOfQuestions.data.toString().isNotEmpty())
                listOfQuestions.loading = false
        }catch (exception: Exception){
            listOfQuestions.e = exception
            Log.d("TAG", "getAllQuestions : ${listOfQuestions.e!!.localizedMessage}")
        }
        return listOfQuestions
    }

}