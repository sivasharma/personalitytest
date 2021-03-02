package com.personality.main.category

import android.content.Context
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.personality.BuildConfig
import com.personality.main.logs.Logger
import com.personality.main.model.PersonalityDataWrapper
import com.personality.main.service.GsonRequest
import com.personality.main.service.VolleyService
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class CategoryUseCase @Inject constructor(
    private val context: Context,
    private val volleyService: VolleyService
) {
    private val url =
        BuildConfig.SERVER_URL.plus("/sivasharma/sampledata/main/testdata.json")

    suspend fun loadPersonalityData(): PersonalityDataWrapper {
        return suspendCancellableCoroutine { result ->
            val request: GsonRequest<PersonalityDataWrapper> = GsonRequest(
                url,
                PersonalityDataWrapper::class.java,
                Listener {
                    if (result.isActive) {
                        result.resume(it)
                    }
                },
                Response.ErrorListener {
                    result.resumeWithException(VolleyException(it))
                }
            )

            result.invokeOnCancellation {
                result.cancel()
            }
            volleyService.getRequestQueue(context).add(request)
        }
    }
}