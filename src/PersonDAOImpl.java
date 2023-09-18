import java.sql.*;

public class PersonDAOImpl implements PersonDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/practice_db";
    private static final String USER = "root";
    private static final String PASSWORD = "my5q1P455w0rd";

    @Override
    public void insertPerson(Person person){
        String addQueryPerson = "INSERT INTO person (first_name, second_name, first_lastname, second_lastname, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(addQueryPerson)) {
            statement.setString(1, person.getFirst_name());
            statement.setString(2, person.getSecond_name());
            statement.setString(3, person.getFirst_lastname());
            statement.setString(4, person.getSecond_lastname());
            statement.setString(5, person.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void showQuery(){
        String basicQuery = "SELECT * FROM person LIMIT 20";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(basicQuery)) {

            System.out.println("ID : Name and Email");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id_person") + " : " +
                        resultSet.getString("first_name") + " " +
                        resultSet.getString("second_name") + " " +
                        resultSet.getString("first_lastname") + " " +
                        resultSet.getString("second_lastname") + " " +
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
