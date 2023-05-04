package io.github.giger85.tracedemo.gateway

import com.dynatrace.oneagent.sdk.OneAgentSDKFactory

object OneAgentUtils {
    private val oneAgentSdk = OneAgentSDKFactory.createInstance()

    fun getTraceId(): String {
        return oneAgentSdk.traceContextInfo.traceId
    }
}