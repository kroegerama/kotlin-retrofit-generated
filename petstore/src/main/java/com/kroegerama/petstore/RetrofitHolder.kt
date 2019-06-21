package com.kroegerama.petstore

import com.squareup.moshi.Moshi
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitHolder {

    const val BASE_URL = "http://petstore.swagger.io/v2/"

    val clientBuilder: OkHttpClient.Builder by lazy {
        OkHttpClient().newBuilder()
            .addNetworkInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .removeHeader(AUTH_NAME_HEADER)
                    .build()
                chain.proceed(newRequest)
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.HEADERS
            })
            .addInterceptor(HeaderParamInterceptor("api_key", "api_key", this::apiKeyGenerator))
            
    }

    val retrofitBuilder: Retrofit.Builder by lazy {
        val moshi = Moshi.Builder()
            //.add(OffsetDateTimeAdapter())
            .build()

        Retrofit.Builder()
            .client(clientBuilder.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    val retrofit: Retrofit by lazy { retrofitBuilder.build() }


    private val securityDefinitions = HashMap<String, String>()

    fun setApiKey(authMethod: AuthMethod, apiKey: String) {
        securityDefinitions[authMethod.authName] = apiKey
    }

    fun setBasicAuth(authMethod: AuthMethod, username: String, password: String) {
        securityDefinitions[authMethod.authName] = Credentials.basic(username, password)
    }

    fun setBearerAuth(authMethod: AuthMethod, bearer: String) {
        securityDefinitions[authMethod.authName] = "Bearer $bearer"
    }

    private fun apiKeyGenerator(authName: String, request: Request): String? =
        if (requestHasAuth(request, authName))
            securityDefinitions[authName]
        else
            null


    private fun requestHasAuth(request: Request, authName: String): Boolean {
        val headers = request.headers(AUTH_NAME_HEADER) ?: return false
        return headers.contains(authName)
    }

    const val AUTH_NAME_HEADER = "X-Auth-Name"

}

enum class AuthMethod(internal val authName: String) { 
    ("api_key"),

    ("petstore_auth")
}
