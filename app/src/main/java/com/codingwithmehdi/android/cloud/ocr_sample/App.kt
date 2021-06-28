package com.codingwithmehdi.android.cloud.ocr_sample

import android.app.Application
import com.codingwithmehdi.android.cloud.ocr.TextRecognition

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        TextRecognition.initialize(BuildConfig.OCR_CLOUD_API_KEY)
    }

}