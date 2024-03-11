package com.mateus.yaperecipes.data

sealed class Resource<T>(val data:T?=null, val message:String?=null){
    class Success<T>(data: T):Resource<T>(data = data)
    class Error<T>(error: String):Resource<T>(message = error)
    class Loading<T>:Resource<T>()
}