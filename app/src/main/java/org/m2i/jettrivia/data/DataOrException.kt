package org.m2i.jettrivia.data

import org.m2i.jettrivia.model.Question


data class DataOrException<T, Boolean, E:Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)




