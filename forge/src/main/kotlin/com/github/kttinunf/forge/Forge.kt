package com.github.kttinunf.forge

import com.github.kttinunf.forge.core.*
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by Kittinun Vantasin on 8/21/15.
 */

object Forge {

   fun <T: Any, U : Deserializable<T>> modelFromJson(json: String, deserializer: U): Result<T> = deserializer.deserializer(JSON.parse(JSONObject(json)))

   fun <T: Any> modelFromJson(json: String, deserializer: JSON.() -> Result<T>): Result<T> = JSON.parse(JSONObject(json)).deserializer()

   fun <T: Any, U : Deserializable<T>> modelsFromJson(json: String, deserializer: U): List<Result<T>> =
    JSON.parse(JSONArray(json)).toList().map { deserializer.deserializer(it) }

   fun <T: Any> modelsFromJson(json: String, deserializer: JSON.() -> Result<T>): List<Result<T>> =
    JSON.parse(JSONArray(json)).toList().map { it.deserializer() }

}

