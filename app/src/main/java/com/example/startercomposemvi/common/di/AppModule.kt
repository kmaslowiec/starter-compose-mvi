package com.example.startercomposemvi.common.di
//TODO replace with your Hilt implementation
/*
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    */
/*@Singleton
    @Provides
    fun provideQuestionApi(): CallApi {
        val client = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .header("Authorization", "Bearer ${BuildConfig.CHATGPT_API_KEY}")
                    .header("OpenAI-Organization", BuildConfig.CHATGPT_ORG_ID)
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CallApi::class.java)
    }*//*

}
*/
