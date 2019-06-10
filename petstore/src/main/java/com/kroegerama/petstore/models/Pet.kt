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
package com.kroegerama.petstore.models

import com.kroegerama.petstore.models.Category
import com.kroegerama.petstore.models.Tag

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * A pet for sale in the pet store
 * @param id 
 * @param category 
 * @param name 
 * @param photoUrls 
 * @param tags 
 * @param status pet status in the store
 */
@JsonClass(generateAdapter = true)
data class Pet (
    @Json(name = "name") val name: kotlin.String,

    @Json(name = "photoUrls") val photoUrls: kotlin.Array<kotlin.String>,

    @Json(name = "id") val id: kotlin.Long? = null,

    @Json(name = "category") val category: Category? = null,

    @Json(name = "tags") val tags: kotlin.Array<Tag>? = null,

    @Json(name = "status") val status: Pet.Status? = null
) {

    /**
    * pet status in the store
    * Values: available,pending,sold
    */
    enum class Status(val value: kotlin.String){
    
        @Json(name = "available")
        Available("available"),
    
        @Json(name = "pending")
        Pending("pending"),
    
        @Json(name = "sold")
        Sold("sold");
    
    }

}

