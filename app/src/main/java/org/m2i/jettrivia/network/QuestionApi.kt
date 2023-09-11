package org.m2i.jettrivia.network

import org.m2i.jettrivia.model.Question
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question


}