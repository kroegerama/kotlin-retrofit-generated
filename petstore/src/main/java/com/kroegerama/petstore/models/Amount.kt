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


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * some description 
 * @param value some description 
 * @param currency some description 
 */
@JsonClass(generateAdapter = true)
data class Amount (
    @Json(name = "value") val value: kotlin.Double,

    @Json(name = "currency") val currency: kotlin.String
)

