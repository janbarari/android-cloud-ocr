# Android Cloud OCR: A lightweight tool to extract the image text
[![](https://jitpack.io/v/janbarari/android-cloud-ocr.svg)](https://jitpack.io/#janbarari/android-cloud-ocr)
[![License](http://img.shields.io/badge/License-Apache_v2.0-green.svg?style=flat)](https://github.com/janbarari/kevent)


Do you want to get text content of an image using simple and fast approach? This is all your need

Hi Devs,
This library based on https://ocr.space API to get text inside the image, 
The api is not free but they have free plan to cover 25,000 requests/month. But I highly recommend 
to get premium plan. It's really worth.

Benefits
--------
- Fast and accurate
- Easy to use
- Good pricing plan
- No need to download module like Google ML kit

## Example Video
![](sample.gif)

## Installation
First of all you need to get your own API_KEY from https://ocr.space and put it into your project local.properties file like below:
```groovy
ocr.space.apikey=ABCDEFGHIJK
```
And then add the below dependency configurations into your project
```kotlin
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
dependencies {
    implementation 'com.github.janbarari:android-cloud-ocr:v1.0.0-alpha'
}
```
## Jump in code
Put this code inside your Application class or call it before make any process
```kotlin
TextRecognition.initialize(BuildConfig.OCR_CLOUD_API_KEY)
```
Use the below sample to see how it's easy
```kotlin
val imageFile: File = //Your image file
TextRecognition.fromFile(imageFile, object : TextRecognition.Callback {
    override fun success(response: String) {
        //do stuff
    }

    override fun failure(e: Throwable) {
        //do stuff
    }

})
```
Because the API limited the image file size to be less than 1MB for free account and 3MB for premium account I put an easy function to you to compress the file size and gives you the compressed file fast.
```kotlin
val context: Context = //The context
val imageFile: File = //Your image file
TextRecognition.compressFile(context, imageFile) { compressedFile ->
    //do the previous step here
}
```

## Sponsor
  ### If you like and use it, please tap the Star(⭐️) button at the above.  
  This source code is free for all; hence, it's not profitable. You can make me happy by donating me :)
  
  [![](https://img.shields.io/badge/Dogecoin-Click%20to%20see%20the%20address%20or%20scan%20the%20QR%20code-yellow.svg?style=flat)](https://blockchair.com/dogecoin/address/DB87foUxetrQRpAbWkrhexZeVtnzwyqhSL)
  
  [![](https://img.shields.io/badge/Bitcoin-Click%20to%20see%20the%20address%20or%20scan%20the%20QR%20code-orange.svg?style=flat)](https://blockchair.com/bitcoin/address/bc1qj30t3hmw0gat3vmwye972ce4sfrc5r5mz0ctr6)
  
## License

    Copyright 2021 Mehdi Janbarari

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
### I dedicate it to my lovely Negar❤️