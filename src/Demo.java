import java.sql.*;

public class Demo {
    public static void main(String[] args) {

        String basicQuery = "SELECT * FROM person limit 20";
        String url = "jdbc:mysql://localhost:3306/practice_db";
        String user = "root";
        String password = "my5q1P455w0rd";
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(basicQuery);
            resultSet.next();
            System.out.println("ID : Name and Email");
            do{
                System.out.println(resultSet.getInt("id_person") + " : " +
                        resultSet.getString("first_name") + " " +
                        resultSet.getString("second_name") + " " +
                        resultSet.getString("first_lastname") + " " +
                        resultSet.getString("second_lastname") + " " +
                        resultSet.getString("email"));
            }while(resultSet.next());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
