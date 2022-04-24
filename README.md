# ApiUsageApp

Application to show elements obtained from an API, using retrofit and glide to request and show the information in 2 different RecyclerView

## Dependancies used on this project

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.4.1'
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"

    //Dagger - Hilt
    implementation "com.google.dagger:hilt-android:2.38.1"
    kapt "com.google.dagger:hilt-android-compiler:2.37"
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    kapt "androidx.hilt:hilt-compiler:1.0.0"

    // retrofit2
    implementation 'com.squareup.retrofit2:retrofit:2.7.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.7.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'
    implementation 'com.squareup.okio:okio:2.2.2'
    implementation 'com.google.code.gson:gson:2.8.6'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.13.0'
    kapt 'com.github.bumptech.glide:compiler:4.13.0'

