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

import com.kroegerama.petstore.models.Order

import com.kroegerama.petstore.RetrofitHolder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.*
import okhttp3.*
import retrofit2.http.Headers

interface StoreApi {
    
    /**
    * Delete purchase order by ID
    * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
    * Responses:
    *  - 400: Invalid ID supplied
    *  - 404: Order not found
    * 
    * @param orderId ID of the order that needs to be deleted 
    * @return void
    */
    @DELETE("store/order/{orderId}")
    
    suspend fun deleteOrder(
        @Path("orderId") orderId: kotlin.String
    ): Response<Unit>

    /**
    * Returns pet inventories by status
    * Returns a map of status codes to quantities
    * Responses:
    *  - 200: successful operation
    * 
    * @return kotlin.collections.Map<kotlin.String, kotlin.Int>
    */
    @GET("store/inventory")
    @Headers(RetrofitHolder.AUTH_NAME_HEADER + ": api_key")
    suspend fun getInventory(
        
    ): Response<kotlin.collections.Map<kotlin.String, kotlin.Int>>

    /**
    * Find purchase order by ID
    * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generated exceptions
    * Responses:
    *  - 200: successful operation
    *  - 400: Invalid ID supplied
    *  - 404: Order not found
    * 
    * @param orderId ID of pet that needs to be fetched 
    * @return Order
    */
    @GET("store/order/{orderId}")
    
    suspend fun getOrderById(
        @Path("orderId") orderId: kotlin.Long
    ): Response<Order>

    /**
    * Place an order for a pet
    * 
    * Responses:
    *  - 200: successful operation
    *  - 400: Invalid Order
    * 
    * @param body order placed for purchasing the pet 
    * @return Order
    */
    @POST("store/order")
    
    suspend fun placeOrder(
        @Body body: Order
    ): Response<Order>


    companion object {
        fun create(retrofit: Retrofit = RetrofitHolder.retrofit): StoreApi = retrofit.create()
    }
}
