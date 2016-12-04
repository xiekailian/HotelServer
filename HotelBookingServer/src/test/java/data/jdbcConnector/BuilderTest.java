package data.jdbcConnector;

import static org.junit.Assert.*;
import data.dataHelper.jdbc.*;

import java.sql.Connection;

import org.junit.Test;

public class BuilderTest {
	Builder bd = new Builder();
	Connection conn = null;

	@Test
	public void testBuildConnection() {
		conn = bd.BuildConnection();
		assertNotNull(conn);

	}

}
