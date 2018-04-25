package com.adet.core.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.adet.core.connection.ConnectionFactory;
import com.adet.core.constants.Constants;
import com.adet.core.util.DynamicQueryBuilder;

public class CsvGenerator {
	
	private static final String CSV_DATE_FORMAT = "yyyy-MM-dd HH.mm.ss.SSS";
	private static final String CSV_EXT = ".csv";
	

	public boolean generate(String fields, String table) {
		boolean success = false;
		try {

			String query = DynamicQueryBuilder.buildQuery(fields, table);

			System.out.println(query);

			Connection conn = ConnectionFactory.getConnection(ConnectionFactory.TYPE_MYSQL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			int index = StringUtils.countMatches(query, Constants.COMMA) + 1;
			int count = 0;

			System.out.println("Field count : " + index);

			FileWriter fw = null;
			BufferedWriter bw = null;

			try {
				
//				Properties prop = new Properties();

				fw = new FileWriter(new StringBuilder("D:\\")
						.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(CSV_DATE_FORMAT))).append(Constants.WHITESPACE).append(Constants.PARENTHESIS_OPEN)
						.append(table).append(Constants.PARENTHESIS_CLOSE).append(CSV_EXT).toString());

				bw = new BufferedWriter(fw);

				StringBuilder content = new StringBuilder(fields);
				content.append(Constants.NEW_LINE);

				while (rs.next()) {

					for (int x = 1; x <= index; x++) {
						content.append(Constants.DOUBLE_QUOTE);
						content.append(rs.getString(x));
						content.append(Constants.DOUBLE_QUOTE);
						
						if (x < index) {
							content.append(Constants.COMMA);
						} else {
							content.append(Constants.NEW_LINE);
						}
					}
					count++;
				}

				bw.write(content.toString());
				bw.flush();

				System.out.println("Number of records : " + count);

				success = true;
			} catch (IOException ioex) {
				ioex.printStackTrace();
			} finally {
				try {
					if (bw != null) {
						bw.close();
					}
					if (fw != null) {
						fw.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
