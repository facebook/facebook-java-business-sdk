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

package com.facebook.ads.sdk;

import java.io.PrintStream;
import com.facebook.ads.sdk.APIContext;

public class CrashReporter implements Thread.UncaughtExceptionHandler {
	private static final String TAG = CrashReporter.class.getCanonicalName();
	private static CrashReporter instance = null;

	private final Thread.UncaughtExceptionHandler prevHandler;
	private final APIContext context;

	private static PrintStream logger = System.out;

	private CrashReporter(Thread.UncaughtExceptionHandler prevHandler, APIContext context) {
		this.prevHandler = prevHandler;
		this.context = context;
	}

	public static synchronized void enable(APIContext context) {
		if (instance != null) {
			log("Already enabled!");
			return;
		}
		Thread.UncaughtExceptionHandler prevHandler = Thread.getDefaultUncaughtExceptionHandler();
		instance = new CrashReporter(prevHandler, context);
		Thread.setDefaultUncaughtExceptionHandler(instance);
		log("Enabled!");
	}

	public static synchronized void disable() {
		if (instance == null) {
			log("Already disabled!");
			return;
		}
    Thread.UncaughtExceptionHandler mPrevHandler = instance.prevHandler;
    instance = null;
    log("Disabled!");
		Thread.setDefaultUncaughtExceptionHandler(mPrevHandler);
	}

  public static void setLogger(PrintStream logger) {
    logger = logger;
  }

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		if (isSDKRelatedException(e)) {
			// TODO send report
			log("Send report..." + e.getMessage());
		}
		if (this.prevHandler != null) {
			this.prevHandler.uncaughtException(t, e);
		} else {
			e.printStackTrace();
		}
	}

	private static boolean isSDKRelatedException(Throwable e) {
		// TODO implement this function
		return true;
	}

	private static void log(String content) {
		if (logger != null) {
			logger.println(String.format("%s : %s", TAG, content));
		}
	}
}
