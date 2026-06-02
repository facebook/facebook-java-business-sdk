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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PreferenceTest {

    @Test
    public void testDefaultConstructorAllowsEverything() {
        Preference p = new Preference();
        assertTrue(p.isFbcAllowed());
        assertTrue(p.isFbpAllowed());
        assertTrue(p.isClientIpAddressAllowed());
        assertTrue(p.isReferrerUrlAllowed());
    }

    @Test
    public void testAllDisallowedDeniesEveryField() {
        Preference p = new Preference(false, false, false, false);
        assertFalse(p.isFbcAllowed());
        assertFalse(p.isFbpAllowed());
        assertFalse(p.isClientIpAddressAllowed());
        assertFalse(p.isReferrerUrlAllowed());
    }

    @Test
    public void testPartialAllowlist() {
        // Only fbc and client_ip_address allowed.
        Preference p = new Preference(true, false, true, false);
        assertTrue(p.isFbcAllowed());
        assertFalse(p.isFbpAllowed());
        assertTrue(p.isClientIpAddressAllowed());
        assertFalse(p.isReferrerUrlAllowed());
    }

    @Test
    public void testEachFlagIndependentlyControllable() {
        boolean[][] cases = {
            {true,  false, false, false},
            {false, true,  false, false},
            {false, false, true,  false},
            {false, false, false, true},
        };
        for (boolean[] c : cases) {
            Preference p = new Preference(c[0], c[1], c[2], c[3]);
            assertEquals(c[0], p.isFbcAllowed());
            assertEquals(c[1], p.isFbpAllowed());
            assertEquals(c[2], p.isClientIpAddressAllowed());
            assertEquals(c[3], p.isReferrerUrlAllowed());
        }
    }

    @Test
    public void testFluentSettersAndPlainSetters() {
        Preference p = new Preference()
            .fbcAllowed(false)
            .fbpAllowed(true)
            .clientIpAddressAllowed(false)
            .referrerUrlAllowed(true);
        assertFalse(p.isFbcAllowed());
        assertTrue(p.isFbpAllowed());
        assertFalse(p.isClientIpAddressAllowed());
        assertTrue(p.isReferrerUrlAllowed());

        // Plain setters
        p.setFbcAllowed(true);
        p.setFbpAllowed(false);
        p.setClientIpAddressAllowed(true);
        p.setReferrerUrlAllowed(false);
        assertTrue(p.isFbcAllowed());
        assertFalse(p.isFbpAllowed());
        assertTrue(p.isClientIpAddressAllowed());
        assertFalse(p.isReferrerUrlAllowed());
    }

    @Test
    public void testEqualsAndHashCode() {
        assertEquals(new Preference(), new Preference());
        assertEquals(new Preference().hashCode(), new Preference().hashCode());

        Preference a = new Preference(true, false, true, false);
        Preference b = new Preference(true, false, true, false);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testNotEqualWhenAnyFlagDiffers() {
        Preference a = new Preference();
        Preference b = new Preference(false, true, true, true);
        assertNotEquals(a, b);
    }
}
