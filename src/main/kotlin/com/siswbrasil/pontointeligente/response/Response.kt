package com.siswbrasil.pontointeligente.response

class Response<T>(
        val errors: ArrayList<String> = arrayListOf(),
        var data: T? = null
)
