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

import com.kroegerama.petstore.models.User

import com.kroegerama.petstore.RetrofitHolder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.*
import okhttp3.*
import retrofit2.http.Headers

interface UserApi {
    
    /**
    * Create user
    * This can only be done by the logged in user.
    * Responses:
    *  - 0: successful operation
    * 
    * @param body Created user object 
    * @return void
    */
    @POST("user")
    
    suspend fun createUser(
        @Body body: User
    ): Response<Unit>

    /**
    * Creates list of users with given input array
    * 
    * Responses:
    *  - 0: successful operation
    * 
    * @param body List of user object 
    * @return void
    */
    @POST("user/createWithArray")
    
    suspend fun createUsersWithArrayInput(
        @Body body: kotlin.Array<User>
    ): Response<Unit>

    /**
    * Creates list of users with given input array
    * 
    * Responses:
    *  - 0: successful operation
    * 
    * @param body List of user object 
    * @return void
    */
    @POST("user/createWithList")
    
    suspend fun createUsersWithListInput(
        @Body body: kotlin.Array<User>
    ): Response<Unit>

    /**
    * Delete user
    * This can only be done by the logged in user.
    * Responses:
    *  - 400: Invalid username supplied
    *  - 404: User not found
    * 
    * @param username The name that needs to be deleted 
    * @return void
    */
    @DELETE("user/{username}")
    
    suspend fun deleteUser(
        @Path("username") username: kotlin.String
    ): Response<Unit>

    /**
    * Get user by user name
    * 
    * Responses:
    *  - 200: successful operation
    *  - 400: Invalid username supplied
    *  - 404: User not found
    * 
    * @param username The name that needs to be fetched. Use user1 for testing. 
    * @return User
    */
    @GET("user/{username}")
    
    suspend fun getUserByName(
        @Path("username") username: kotlin.String
    ): Response<User>

    /**
    * Logs user into the system
    * 
    * Responses:
    *  - 200: successful operation
    *  - 400: Invalid username/password supplied
    * 
    * @param username The user name for login 
    * @param password The password for login in clear text 
    * @return kotlin.String
    */
    @GET("user/login")
    
    suspend fun loginUser(
        @Query("username") username: kotlin.String,
        @Query("password") password: kotlin.String
    ): Response<kotlin.String>

    /**
    * Logs out current logged in user session
    * 
    * Responses:
    *  - 0: successful operation
    * 
    * @return void
    */
    @GET("user/logout")
    
    suspend fun logoutUser(
        
    ): Response<Unit>

    /**
    * Updated user
    * This can only be done by the logged in user.
    * Responses:
    *  - 400: Invalid user supplied
    *  - 404: User not found
    * 
    * @param username name that need to be deleted 
    * @param body Updated user object 
    * @return void
    */
    @PUT("user/{username}")
    
    suspend fun updateUser(
        @Path("username") username: kotlin.String,
        @Body body: User
    ): Response<Unit>


    companion object {
        fun create(retrofit: Retrofit = RetrofitHolder.retrofit): UserApi = retrofit.create()
    }
}
