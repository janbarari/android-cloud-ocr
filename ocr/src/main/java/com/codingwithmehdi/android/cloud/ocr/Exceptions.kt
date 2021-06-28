package com.codingwithmehdi.android.cloud.ocr

class ApiKeyIsMissingException : Throwable("The ocr.space API Key is missing or you forget to initialize it before make any request call")

class EmptyContentException : Throwable("There isn't any text inside the image")

class HttpException(code: Int) : Throwable("failed! code:$code")

class ParseTextResponseException(msg: String) : Throwable(msg)
