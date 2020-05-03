package com.akshat.synerzip.utils

import java.io.IOException

/**
 * Created by Akshat on 2019-07-24.
 */
class ApiExceptions(message : String) : IOException(message)
class NoInternetException (message: String) : IOException(message)