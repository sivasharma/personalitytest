package com.personality.main.service

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

object VolleyService {

    fun getRequestQueue(ctx: Context): RequestQueue {
        return Volley.newRequestQueue(ctx)
    }
}