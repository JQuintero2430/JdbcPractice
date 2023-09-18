import dao.PersonDAO;
import daoimpl.PersonDAOImpl;
import model.Person;

public class Demo {

    public static void main(String[] args) {
        PersonDAO personDao = new PersonDAOImpl();

        Person person = new Person("Jorge", "Felipe", "Quintero",
                    "Suarez", "sqfj@gmail.com");

        personDao.insertPerson(person);
        personDao.showQuery();
    }
}
