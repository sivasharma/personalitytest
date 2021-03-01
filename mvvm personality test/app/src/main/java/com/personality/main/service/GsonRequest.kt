package com.personality.main.service

import com.android.volley.*
import com.android.volley.toolbox.HttpHeaderParser
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.UnsupportedEncodingException

class GsonRequest<T>(
    url: String?,
    private val clazz: Class<T>,
    private val listener: Response.Listener<T>,
    errorListener: Response.ErrorListener?
) : Request<T>(Method.GET, url, errorListener) {

    private val gson = Gson()

    override fun deliverResponse(response: T) {
        listener.onResponse(response)
    }

    override fun parseNetworkResponse(response: NetworkResponse): Response<T> {
        return try {
            val json = String(
                response.data
            )
            Response.success(
                gson.fromJson(json, clazz),
            null)
        } catch (e: UnsupportedEncodingException) {
            Response.error(ParseError(e))
        } catch (e: JsonSyntaxException) {
            Response.error(ParseError(e))
        }
    }

}