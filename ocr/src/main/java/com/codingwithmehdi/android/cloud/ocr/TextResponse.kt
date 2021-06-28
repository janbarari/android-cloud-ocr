package com.codingwithmehdi.android.cloud.ocr

import com.google.gson.annotations.SerializedName

data class TextResponse(
    @SerializedName("ErrorMessage")
    val errorMessage: List<String>,
    @SerializedName("IsErroredOnProcessing")
    val isErroredOnProcessing: Boolean,
    @SerializedName("ParsedResults")
    val parsedResults: List<ParsedResult>
) {
    data class ParsedResult(
        @SerializedName("ParsedText")
        val parsedText: String
    )
}