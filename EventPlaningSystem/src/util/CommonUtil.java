package util;

import java.util.ArrayList;
import java.util.Properties;

import util.CommonConstants;

public class CommonUtil {
	
	public static final Properties properties = new Properties();

	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.Event_ID_Prefix + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.Event_ID_Prefix + next;
		}
		return id;
	}
}
