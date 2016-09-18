package util;

import java.util.*;

public class ExceptionLogger {
	private static final List<Exception> loggedExceptions = new ArrayList<Exception>();

	public static void log(String where, Exception e) {
		System.err.println("Crash at: " + where + "!");

		if (e != null) {
			e.printStackTrace();
			loggedExceptions.add(e);
		}
	}
}