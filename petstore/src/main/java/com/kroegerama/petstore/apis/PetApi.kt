/**
* Swagger Petstore
* This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
*
* The version of the OpenAPI document: 1.0.0
* Contact: apiteam@swagger.io
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package com.kroegerama.petstore.apis

import com.kroegerama.petstore.models.ApiResponse
import com.kroegerama.petstore.models.Pet

import com.kroegerama.petstore.RetrofitHolder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.*
import okhttp3.*
import retrofit2.http.Headers

interface PetApi {
    
    /**
    * Add a new pet to the store
    * 
    * Responses:
    *  - 405: Invalid input
    * 
    * @param body Pet object that needs to be added to the store 
    * @return void
    */
    @POST("pet")
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": petstore_auth")
    suspend fun addPet(
        @Body body: Pet
    ): Response<Unit>

    /**
    * Deletes a pet
    * 
    * Responses:
    *  - 400: Invalid pet value
    * 
    * @param petId Pet id to delete 
    * @param apiKey  (optional)
    * @return void
    */
    @DELETE("pet/{petId}")
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": petstore_auth")
    suspend fun deletePet(
        @Path("petId") petId: kotlin.Long,
        @Header("api_key") apiKey: kotlin.String? = null
    ): Response<Unit>

    /**
    * Finds Pets by status
    * Multiple status values can be provided with comma separated strings
    * Responses:
    *  - 200: successful operation
    *  - 400: Invalid status value
    * 
    * @param status Status values that need to be considered for filter 
    * @return kotlin.Array<Pet>
    */
    @GET("pet/findByStatus")
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": petstore_auth")
    suspend fun findPetsByStatus(
        @Query("status") status: kotlin.Array<kotlin.String>
    ): Response<kotlin.Array<Pet>>

    /**
    * Finds Pets by tags
    * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
    * Responses:
    *  - 200: successful operation
    *  - 400: Invalid tag value
    * 
    * @param tags Tags to filter by 
    * @return kotlin.Array<Pet>
    */
    @GET("pet/findByTags")
    @Deprecated("")
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": petstore_auth")
    suspend fun findPetsByTags(
        @Query("tags") tags: kotlin.Array<kotlin.String>
    ): Response<kotlin.Array<Pet>>

    /**
    * Find pet by ID
    * Returns a single pet
    * Responses:
    *  - 200: successful operation
    *  - 400: Invalid ID supplied
    *  - 404: Pet not found
    * 
    * @param petId ID of pet to return 
    * @return Pet
    */
    @GET("pet/{petId}")
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": api_key")
    suspend fun getPetById(
        @Path("petId") petId: kotlin.Long
    ): Response<Pet>

    /**
    * Update an existing pet
    * 
    * Responses:
    *  - 400: Invalid ID supplied
    *  - 404: Pet not found
    *  - 405: Validation exception
    * 
    * @param body Pet object that needs to be added to the store 
    * @return void
    */
    @PUT("pet")
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": petstore_auth")
    suspend fun updatePet(
        @Body body: Pet
    ): Response<Unit>

    /**
    * Updates a pet in the store with form data
    * 
    * Responses:
    *  - 405: Invalid input
    * 
    * @param petId ID of pet that needs to be updated 
    * @param name Updated name of the pet (optional)
    * @param status Updated status of the pet (optional)
    * @return void
    */
    @POST("pet/{petId}")
    @FormUrlEncoded
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": petstore_auth")
    suspend fun updatePetWithForm(
        @Path("petId") petId: kotlin.Long,
        @Field("name") name: kotlin.String? = null,
        @Field("status") status: kotlin.String? = null
    ): Response<Unit>

    /**
    * uploads an image
    * 
    * Responses:
    *  - 200: successful operation
    * 
    * @param petId ID of pet to update 
    * @param additionalMetadata Additional data to pass to server (optional)
    * @param file file to upload (optional)
    * @return ApiResponse
    */
    @POST("pet/{petId}/uploadImage")
    @FormUrlEncoded
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": petstore_auth")
    suspend fun uploadFile(
        @Path("petId") petId: kotlin.Long,
        @Field("additionalMetadata") additionalMetadata: kotlin.String? = null,
        @Field("file") file: MultipartBody.Part? = null
    ): Response<ApiResponse>


    companion object {
        fun create(retrofit: Retrofit = RetrofitHolder.retrofit): PetApi = retrofit.create()
    }
}
