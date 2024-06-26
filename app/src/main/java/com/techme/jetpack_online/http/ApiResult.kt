package com.techme.jetpack_online.http

class ApiResult<T> {
    internal var status = 0
    val success
        get() = status == 200
    var errMsg: String = ""
    var body: T? = null
}