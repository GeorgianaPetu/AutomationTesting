package ConfigUtility;

public class DataBaseConfig {
    private String port;
    private String dataBase;
    private String userName;
    private String password;

    public String getPort() {
        return port;
    }

    public String getDataBase() {
        return dataBase;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
