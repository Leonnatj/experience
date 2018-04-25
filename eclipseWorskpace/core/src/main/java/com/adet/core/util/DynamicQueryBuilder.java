package com.adet.core.util;

import org.apache.commons.lang3.StringUtils;

import com.adet.core.constants.Constants;
import com.adet.core.constants.QueryConstants;

public class DynamicQueryBuilder {

	public static String buildQuery(String fields, String table) {
		StringBuilder sb = new StringBuilder();
		try {

			if (StringUtils.isNotEmpty(fields) && StringUtils.isNotEmpty(table)) {
				sb.append(QueryConstants.SELECT);
				sb.append(Constants.WHITESPACE);
				sb.append(fields);
				sb.append(Constants.WHITESPACE);
				sb.append(QueryConstants.FROM);
				sb.append(Constants.WHITESPACE);
				sb.append(table);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}

}
