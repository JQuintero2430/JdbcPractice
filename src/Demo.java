public class Demo {

    public static void main(String[] args) {
        PersonDAO personDao = new PersonDAOImpl();

        Person person = new Person("Ronald", "Jesus", "Galindez",
                    "Rosso", "rjgr@gmail.com");

        personDao.insertPerson(person);
        personDao.showQuery();
    }
}
