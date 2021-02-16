package paytalab.clone.passorder.domain.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import paytalab.clone.passorder.data.server.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

// NetworkService Interface 제공

@Module
@InstallIn(SingletonComponent::class)
object NetworkServiceModule {
    private val BASE_URL = "https://development.passorder.me:9999/"

    private fun getHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val loggingInterceptor  = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(getHttpLoggingInterceptor())
        .build()

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideLoginServiceApi() : LoginService = builder.create(LoginService::class.java)
}