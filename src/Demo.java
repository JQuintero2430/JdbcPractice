import java.sql.*;

public class Demo {
    public static void main(String[] args) {

        String first_name = "Hector";
        String second_name = "Ivan";
        String first_lastname = "Figueroa";
        String second_lastname = "";
        String email = "hifdsc@hotmail.com";
        String basicQuery = "SELECT * FROM person LIMIT 20";
        String addQuery = "INSERT INTO person (first_name, second_name, first_lastname, second_lastname, email) " +
                          "VALUES ('" + first_name +
                          "', '" + second_name +
                          "', '" + first_lastname +
                          "', '" + second_lastname +
                          "', '" + email + "')";
        String url = "jdbc:mysql://localhost:3306/practice_db";
        String user = "root";
        String password = "my5q1P455w0rd";
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.executeUpdate(addQuery);
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
