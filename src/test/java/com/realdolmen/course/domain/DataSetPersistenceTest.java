package com.realdolmen.course.domain;


import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import java.sql.Connection;
import java.sql.DriverManager;


public class DataSetPersistenceTest extends PersistenceTest {

    @Before
    public void loadDataSet() throws Exception{
        logger.info("loading dataSet");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(getClass().getResource("/data.xml"));

        //set factorytype in dbconfig to remove warning
        DatabaseConfig dbConfig = connection.getConfig();
        dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());

        DatabaseOperation.CLEAN_INSERT.execute(connection,dataSet);
    }
    
}
