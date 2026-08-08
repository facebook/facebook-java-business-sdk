package com.facebook.ads.sdk

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ApiNodeListTest {

    @Test
    fun testNextPageWhenNextPageAvailable() {
        val request = mockk<APIRequest<Campaign>>()
        val nextPage = mockk<APINodeList<Campaign>>()
        every { request.setOverrideUrl("https://graph.facebook.api/NEXT") } just Runs
        every { request.execute() } returns(nextPage)
        val list = APINodeList<Campaign>(request, "raw value", "header")
        list.setPaging("https://graph.facebook.api/PREVIOUS", "https://graph.facebook.api/NEXT")
        list.setCursors("BEFORE_CURSOR", "AFTER_CURSOR")

        val result = list.nextPage()

        assertEquals(nextPage, result)
        verify {
            request.setOverrideUrl("https://graph.facebook.api/NEXT")
        }
    }

    @Test
    fun testNextPageWhenAlreadyOnLastPage() {
        val request = mockk<APIRequest<Campaign>>()
        val list = APINodeList<Campaign>(request, "raw value", "header")
        list.setPaging("https://graph.facebook.api/PREVIOUS", null)
        list.setCursors("BEFORE_CURSOR", "AFTER_CURSOR")

        val result = list.nextPage()

        assertNull(result)
    }

}