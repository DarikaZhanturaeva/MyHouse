package com.example.myhouse.di

import android.content.Context
import androidx.room.Room
import com.example.myhouse.data.api_service.ApiService
import com.example.myhouse.data.local.dao.Dao
import com.example.myhouse.data.local.database.AppDatabase
import com.example.myhouse.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { provideApiService(get()) }
    single { provideRetrofit(get()) }
    single { provideOkHttpClient(get()) }
    single { provideInterceptor() }
    single { provideDao(get()) }
    single { provideDatabase(get()) }
}

fun provideRetrofit(
    okHttpClient: OkHttpClient
): Retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

fun provideOkHttpClient(
    interceptor: HttpLoggingInterceptor
): OkHttpClient = OkHttpClient.Builder()
    .writeTimeout(15, TimeUnit.SECONDS)
    .readTimeout(15, TimeUnit.SECONDS)
    .connectTimeout(15, TimeUnit.SECONDS)
    .addInterceptor(interceptor)
    .build()

fun provideInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

fun provideDao(database: AppDatabase): Dao {
    return database.cameraDao()
}
fun provideDatabase(
     context: Context
) = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "home_data"
).allowMainThreadQueries().build()