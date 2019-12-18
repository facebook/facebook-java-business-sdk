/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */
package com.facebook.ads;

import com.facebook.ads.sdk.APIContext
import com.facebook.ads.sdk.APIRequest
import com.facebook.ads.sdk.APIRequest.DefaultRequestExecutor
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.coroutines.Continuation
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.mockkStatic
import io.mockk.mockkConstructor

class APIContextTest {
    private val accessToken = "access_token"
    private val appSecret = "app_secret"

    // using constructor :
    // APIContext(String accessToken, String appSecret, String appID, boolean logCrash)
    private val apiContext: APIContext = APIContext(accessToken, appSecret, null, false)

    @Test
    fun testSha256() {
        mockkStatic(APIContext::class)

        // get the expected result from https://www.freeformatter.com/hmac-generator.html
        val expectedResult = "d52ddf968d622d8af8677906b7fbae09ac1f89f7cd5c1584b27544624cc23e5a"
        val result = APIContext.sha256(appSecret, accessToken)
        verify { APIContext.toHex(any()) }
        assertEquals(expectedResult, result)
    }

    @Test
    fun testSha256EmptyAccessToken() {
        mockkStatic(APIContext::class)
        val result = APIContext.sha256(appSecret, "")
        verify { APIContext.toHex(any()) }
        assertNotNull(result);
    }

    @Test(expected = IllegalArgumentException::class)
    fun testSha256EmptyAppSecret() {
        APIContext.sha256("", accessToken)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testSha256NullAppSecret() {
        APIContext.sha256(null, accessToken)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testSha256NullAccessToken() {
        APIContext.sha256(appSecret, null)
    }

    @Test
    fun testGetAppID() {
        val appId = "app_id"
        val mockResponseBody = "{\"data\":{\"app_id\":\"$appId\"}}"
        initMockDefaultRequestExecutor(mockResponseBody)
        assertEquals(appId, apiContext.appID)
    }

    @Test
    fun testGetAppIDFieldNotExist() {
        val mockResponseBody = "{\"data\":{\"appName\":\"app_name\"}}"
        initMockDefaultRequestExecutor(mockResponseBody)
        assertNull(apiContext.appID)
    }

    @Test
    fun testGetAppIDResponseBodyMalFormed() {
        val mockResponseBody = "{"
        initMockDefaultRequestExecutor(mockResponseBody)
        assertNull(apiContext.appID)
    }

    @Test
    fun testGetAppIDEmptyResponseBody() {
        val mockResponseBody = ""
        initMockDefaultRequestExecutor(mockResponseBody)
        assertNull(apiContext.appID)
    }

    @Test
    fun testGetAppIDNullResponseBody() {
        val mockResponseBody = null
        initMockDefaultRequestExecutor(mockResponseBody)
        assertNull(apiContext.appID)
    }

    fun initMockDefaultRequestExecutor(mockBody : String?) {
        mockkConstructor(APIRequest.DefaultRequestExecutor::class)
        every {
            anyConstructed<APIRequest.DefaultRequestExecutor>().
            sendGet(any(), any(), apiContext)
        } returns APIRequest.ResponseWrapper(mockBody, "header")
    }
}
