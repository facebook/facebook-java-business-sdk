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
import java.util.HashMap;
import java.util.Map;
import java.lang.StackTraceElement;
import java.util.Arrays;

public class CrashReporter implements Thread.UncaughtExceptionHandler {
	private static final String TAG = CrashReporter.class.getSimpleName();
	private static CrashReporter instance = null;

	private final Thread.UncaughtExceptionHandler prevHandler;
	private final String appID;

	private static PrintStream logger = System.out;

	private CrashReporter(Thread.UncaughtExceptionHandler prevHandler, String appID) {
		this.prevHandler = prevHandler;
		this.appID = appID;
	}

	public static synchronized void enable(APIContext context) {
		if (instance != null) {
			log("Already enabled!");
			return;
		}
		String appID = context.getAppID();
		if (appID == null) {
			log("Unrecognized appID, cannot enable CrashReporter!");
			return;
		}
		Thread.UncaughtExceptionHandler mPrevHandler = Thread.getDefaultUncaughtExceptionHandler();
		instance = new CrashReporter(mPrevHandler, appID);
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

	public static synchronized boolean isEnabled() {
		return instance != null;
	}

  public static void setLogger(PrintStream parameterLogger) {
    logger = parameterLogger;
  }

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		Map<String, Object> report = parseIfIsSDKException(e);
		if (report != null) {
			log("Crashes detected!");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bizsdk_crash_report", report);
			sendOutReporter(params);
		}
		if (this.prevHandler != null) {
			this.prevHandler.uncaughtException(t, e);
		} else {
			e.printStackTrace();
		}
	}

	private void sendOutReporter(Map<String, Object> params) {
		try {
			APIRequest.DefaultRequestExecutor executor = new APIRequest.DefaultRequestExecutor();
			APIContext anonymous = new APIContext(null, null, null, false);
			String apiUrl = APIContext.DEFAULT_API_BASE + "/" + APIContext.DEFAULT_API_VERSION + "/" + this.appID + "/instruments";
			APIRequest.ResponseWrapper response = executor.execute("POST", apiUrl, params, anonymous);
			log("Success to send out crash reporter");
		} catch (Exception e) {
			log("Fail to send out crash reporter");
		}
	}

	private static Map<String, Object> parseIfIsSDKException(Throwable e) {
		String reason = null;
		StackTraceElement[] eles = e.getStackTrace();
		String[] stacktrace = new String[eles.length];
		int i = 0;
		for (StackTraceElement ele : eles) {
			String str = ele.toString();
			if (reason == null && str.contains("com.facebook.ads.")) {
				reason = "SDK Exception:" + e.getClass().getSimpleName();
			}
			stacktrace[i++] = ele.toString();
		}

		if (e instanceof APIException) {
			reason = "API Exception:" + e.getClass().getSimpleName();
		}

		if (reason != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("reason", reason);
			map.put("platform", System.getProperty("java.version"));
			map.put("callstack", stacktrace);
			return map;
		}

		return null;
	}

	private static void log(String content) {
		if (logger != null) {
			logger.println(String.format("%s : %s", TAG, content));
		}
	}
}
