package chap03;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class C2 implements Driver{

	public static void main(String[] args) {
		Driver c2 = new C2();
		c2.getMajorVersion();
		System.out.println(Driver.class.getClassLoader());
		System.out.println(c2.getClass().getClassLoader());
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		return null;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return null;
	}

	@Override
	public int getMajorVersion() {
		System.out.println("ok");
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
}