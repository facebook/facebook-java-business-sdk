/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * <p>You are hereby granted a non-exclusive, worldwide, royalty-free license to use, copy, modify,
 * and distribute this software in source code or binary form for use in connection with the web
 * services and APIs provided by Facebook.
 *
 * <p>As with any software that integrates with the Facebook platform, your use of this software is
 * subject to the Facebook Developer Principles and Policies [http://developers.facebook.com/policy/].
 * This copyright notice shall be included in all copies or substantial portions of the software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.facebook.ads.sdk.serverside;

import com.facebook.capi.sdk.ParamBuilder;
import org.junit.Test;
import org.mockito.MockedConstruction;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

/**
 * Tests for Event.setRequestContext, Event.applyParamBuilderDefaults, and
 * the deferred auto-population of UserData.fbc / fbp from the CAPI ParamBuilder.
 *
 * <p>The "mocked ParamBuilder" block uses Mockito {@link MockedConstruction} to
 * intercept {@code new ParamBuilder()} calls inside Event.setRequestContext,
 * so tests can control the returned getFbc / getFbp values without needing a
 * framework-shaped request object.
 *
 * <p>The "real ParamBuilder" block does NOT mock — it constructs the actual
 * upstream ParamBuilder. Those tests fail loudly if the upstream package ever
 * renames or drops the methods the SDK depends on, the same drift-protection
 * pattern used in the Python (D105503306) and Ruby (D105519231) test diffs.
 */
public class EventRequestContextTest {

    // ----------------------------------------------------------------
    // set_request_context contract (mocked ParamBuilder)
    // ----------------------------------------------------------------

    @Test
    public void testStoresContextAndPreference() {
        Object ctx = new Object();
        Preference pref = new Preference(false, true, true, false, true);

        try (MockedConstruction<ParamBuilder> mocked = mockConstruction(ParamBuilder.class)) {
            Event event = new Event()
                .eventName("Lead")
                .eventTime(1700000001L)
                .setRequestContext(ctx, pref);

            assertSame(ctx, event.getRequestContext());
            assertSame(pref, event.getPreference());
        }
    }

    @Test
    public void testDefaultsToAllowAllPreferenceWhenNull() {
        try (MockedConstruction<ParamBuilder> mocked = mockConstruction(ParamBuilder.class)) {
            Event event = new Event()
                .eventName("PageView")
                .eventTime(1700000002L)
                .setRequestContext(new Object(), null);

            Preference pref = event.getPreference();
            assertNotNull(pref);
            assertTrue(pref.isFbcAllowed());
            assertTrue(pref.isFbpAllowed());
            assertTrue(pref.isClientIpAddressAllowed());
            assertTrue(pref.isReferrerUrlAllowed());
            assertTrue(pref.isEventSourceUrlAllowed());
        }
    }

    @Test
    public void testSingleArgOverloadUsesAllowAllPreference() {
        try (MockedConstruction<ParamBuilder> mocked = mockConstruction(ParamBuilder.class)) {
            Event event = new Event()
                .eventName("PageView")
                .eventTime(1700000003L)
                .setRequestContext(new Object());

            assertTrue(event.getPreference().isFbcAllowed());
            assertTrue(event.getPreference().isFbpAllowed());
        }
    }

    @Test
    public void testSetRequestContextIsFluent() {
        try (MockedConstruction<ParamBuilder> mocked = mockConstruction(ParamBuilder.class)) {
            Event event = new Event().eventName("Lead").eventTime(1L);
            Event returned = event.setRequestContext(new Object());
            assertSame(event, returned);
        }
    }

    // ----------------------------------------------------------------
    // applyParamBuilderDefaults — auto-populate behavior
    // ----------------------------------------------------------------

    @Test
    public void testApplyParamBuilderDefaultsNoOpWhenSetRequestContextNotCalled() {
        // No setRequestContext, no auto-populate.
        Event event = new Event()
            .eventName("Purchase")
            .eventTime(1700000000L)
            .userData(new UserData().email("a@example.com"));
        event.applyParamBuilderDefaults();
        // userData still has only the email; no fbc/fbp added.
        assertNull(event.getUserData().getFbc());
        assertNull(event.getUserData().getFbp());
    }

    @Test
    public void testAutoPopulatesFbcAndFbp() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("fb.1.1700000000000.AbCdEf12345");
                     when(pb.getFbp()).thenReturn("fb.1.1700000000000.987654321");
                 })) {
            Event event = new Event()
                .eventName("PageView")
                .eventTime(1700000010L)
                .setRequestContext(new Object());

            event.applyParamBuilderDefaults();
            assertEquals("fb.1.1700000000000.AbCdEf12345", event.getUserData().getFbc());
            assertEquals("fb.1.1700000000000.987654321", event.getUserData().getFbp());
        }
    }

    @Test
    public void testCallerSuppliedFbcTakesPrecedence() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("BUILDER_FBC");
                 })) {
            Event event = new Event()
                .eventName("Lead")
                .eventTime(1700000020L)
                .userData(new UserData().fbc("CALLER_FBC"))
                .setRequestContext(new Object());

            event.applyParamBuilderDefaults();
            assertEquals("CALLER_FBC", event.getUserData().getFbc());
        }
    }

    @Test
    public void testCallerSuppliedFbpTakesPrecedence() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbp()).thenReturn("BUILDER_FBP");
                 })) {
            Event event = new Event()
                .eventName("Lead")
                .eventTime(1700000021L)
                .userData(new UserData().fbp("CALLER_FBP"))
                .setRequestContext(new Object());

            event.applyParamBuilderDefaults();
            assertEquals("CALLER_FBP", event.getUserData().getFbp());
        }
    }

    @Test
    public void testPreferenceGatesFbpButKeepsFbc() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("WITHFBC");
                     when(pb.getFbp()).thenReturn("WITHFBP");
                 })) {
            Preference pref = new Preference(true, false, true, true, true);
            Event event = new Event()
                .eventName("PageView")
                .eventTime(1700000030L)
                .setRequestContext(new Object(), pref);

            event.applyParamBuilderDefaults();
            assertEquals("WITHFBC", event.getUserData().getFbc());
            assertNull(event.getUserData().getFbp());
        }
    }

    @Test
    public void testPreferenceAllFalseSuppressesEveryAutoField() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("XX");
                     when(pb.getFbp()).thenReturn("YY");
                     when(pb.getEventSourceUrl()).thenReturn("https://shop.example.com/cart");
                 })) {
            Preference pref = new Preference(false, false, false, false, false);
            Event event = new Event()
                .eventName("PageView")
                .eventTime(1700000031L)
                .setRequestContext(new Object(), pref);

            event.applyParamBuilderDefaults();
            // A UserData WILL have been created (allowing setUserData later), but neither field set.
            UserData ud = event.getUserData();
            if (ud != null) {
                assertNull(ud.getFbc());
                assertNull(ud.getFbp());
            }
            assertNull(event.getEventSourceUrl());
        }
    }

    // ----------------------------------------------------------------
    // event_source_url auto-population (mocked ParamBuilder)
    // ----------------------------------------------------------------

    @Test
    public void testAutoPopulatesEventSourceUrl() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getEventSourceUrl()).thenReturn("https://shop.example.com/cart");
                 })) {
            Event event = new Event()
                .eventName("PageView")
                .eventTime(1700000060L)
                .setRequestContext(new Object());

            event.applyParamBuilderDefaults();
            assertEquals("https://shop.example.com/cart", event.getEventSourceUrl());
        }
    }

    @Test
    public void testCallerSuppliedEventSourceUrlTakesPrecedence() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getEventSourceUrl()).thenReturn("https://from-builder/");
                 })) {
            Event event = new Event()
                .eventName("Lead")
                .eventTime(1700000061L)
                .eventSourceUrl("https://from-caller/")
                .setRequestContext(new Object());

            event.applyParamBuilderDefaults();
            assertEquals("https://from-caller/", event.getEventSourceUrl());
        }
    }

    @Test
    public void testPreferenceGatesEventSourceUrl() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("WITHFBC");
                     when(pb.getEventSourceUrl()).thenReturn("https://from-builder/");
                 })) {
            Preference pref = new Preference(true, true, true, true, false);
            Event event = new Event()
                .eventName("PageView")
                .eventTime(1700000062L)
                .setRequestContext(new Object(), pref);

            event.applyParamBuilderDefaults();
            assertEquals("WITHFBC", event.getUserData().getFbc());
            assertNull(event.getEventSourceUrl());
        }
    }

    @Test
    public void testOrderIndependentUserDataBeforeRequestContext() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("FROM_BUILDER");
                 })) {
            Event event = new Event()
                .eventName("AddToCart")
                .eventTime(1700000040L)
                .userData(new UserData().email("a@b.com"))
                .setRequestContext(new Object());

            event.applyParamBuilderDefaults();
            UserData ud = event.getUserData();
            assertEquals("FROM_BUILDER", ud.getFbc());
            assertNotNull(ud.getEmail());
        }
    }

    @Test
    public void testOrderIndependentRequestContextBeforeUserData() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("FROM_BUILDER");
                 })) {
            Event event = new Event()
                .eventName("AddToCart")
                .eventTime(1700000041L)
                .setRequestContext(new Object());
            event.setUserData(new UserData().email("a@b.com"));

            event.applyParamBuilderDefaults();
            UserData ud = event.getUserData();
            assertEquals("FROM_BUILDER", ud.getFbc());
            assertNotNull(ud.getEmail());
        }
    }

    @Test
    public void testApplyParamBuilderDefaultsIsIdempotent() {
        try (MockedConstruction<ParamBuilder> mocked =
                 mockConstruction(ParamBuilder.class, (pb, ctx) -> {
                     when(pb.getFbc()).thenReturn("IDEMPOTENT");
                 })) {
            Event event = new Event()
                .eventName("Lead")
                .eventTime(1700000050L)
                .setRequestContext(new Object());

            event.applyParamBuilderDefaults();
            String fbcFirst = event.getUserData().getFbc();
            event.applyParamBuilderDefaults();
            String fbcSecond = event.getUserData().getFbc();
            assertEquals(fbcFirst, fbcSecond);
        }
    }

    // ----------------------------------------------------------------
    // Real-ParamBuilder integration — NO mocks. Guardrails against
    // drift between this SDK and the upstream capi-param-builder gem.
    // ----------------------------------------------------------------

    @Test
    public void testRealParamBuilderExposesMethodsTheSdkCalls() {
        // Guardrail against the SDK <-> upstream Maven artifact drifting apart.
        // Only checks the methods that Event#applyParamBuilderDefaults currently
        // calls today — getFbc + getFbp. processRequestFromContext is NOT
        // checked yet because the Maven Central release lags fbsource HEAD for
        // that method; Event#setRequestContext therefore does not invoke it yet
        // (see the NOTE in Event#setRequestContext). Add the
        // processRequestFromContext assertion in the follow-up diff that bumps
        // the pom pin and re-introduces the call.
        ParamBuilder pb = new ParamBuilder();
        try {
            ParamBuilder.class.getMethod("getFbc");
            ParamBuilder.class.getMethod("getFbp");
        } catch (NoSuchMethodException e) {
            fail("capi-param-builder must expose getFbc / getFbp; "
                + "Event.applyParamBuilderDefaults calls them. Bump the pinned "
                + "Maven version in pom.xml if the upstream API has shifted. Missing: "
                + e.getMessage());
        }
        assertNotNull(pb);
    }

    @Test
    public void testSetRequestContextStoresParamBuilderWithoutContextProcessing() {
        // Real ParamBuilder, no mocking. The SDK currently defers calling
        // ParamBuilder.processRequestFromContext until the Maven Central release
        // catches up with fbsource HEAD (see Event#setRequestContext). Until
        // then, applyParamBuilderDefaults is effectively a no-op for fbc/fbp
        // because the builder was never given any context to extract from —
        // getFbc / getFbp return null.
        //
        // When the upstream pin is bumped and the call is re-added in a
        // follow-up diff, this test should be replaced with the end-to-end
        // populate-from-cookie assertion that's currently captured in the
        // RealParamBuilderSmoke companion script (see test plan for D105523324).
        Map<String, Object> headers = new HashMap<>();
        headers.put("host", "shop.example.com");
        headers.put("cookie", "_fbp=fb.1.1700000000000.987654321");
        Map<String, Object> request = new HashMap<>();
        request.put("headers", headers);
        request.put("url", "/");

        Event event = new Event()
            .eventName("PageView")
            .eventTime(1700000000L)
            .setRequestContext(request);

        event.applyParamBuilderDefaults();
        // No fbc/fbp expected — the SDK isn't yet calling processRequestFromContext.
        UserData ud = event.getUserData();
        if (ud != null) {
            assertNull("fbc must not be populated until the SDK calls processRequestFromContext", ud.getFbc());
            assertNull("fbp must not be populated until the SDK calls processRequestFromContext", ud.getFbp());
        }
    }
}
