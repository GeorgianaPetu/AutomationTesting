//package dataBase;
//
//import ConfigUtility.ConfigReader;
//import ConfigUtility.Configuration;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnection {
//    private static DBConnection instance;
//    private Connection connection;
//
//    public DBConnection() throws SQLException{
//        createConnection();
//    }
//
//    private void createConnection() throws SQLException {
//        Configuration config = ConfigReader.readConfig("src/test/resources/generalConfiguration.xml");
//        connection = DriverManager.getConnection(getPreparedUrl(config), config.getDataBaseConfig().getUserName(), config.getDataBaseConfig().getPassword());
//    }
//
//    public static synchronized DBConnection getInstance() throws SQLException {
//        if(instance == null){
//            instance = new DBConnection();
//        } return instance;
//    }
//
//    private static String getPreparedUrl(Configuration configuration) {
//        return "jdbc:mysql://localhost:" + configuration.getDataBaseConfig().getPort() +
//                "/" + configuration.getDataBaseConfig().getDataBase() +
//                "?allowPublicKeyRetrieval=true&useSSL=false";
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//}
