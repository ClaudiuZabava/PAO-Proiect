package com.company.config;

import com.company.catalog.Catalog;
import com.company.config.DatabaseConfiguration;
import com.company.curs.Materie;
import com.company.curs.Sala;
import com.company.services.CatalogService;
import com.company.services.ProfesorService;
import com.company.services.StudentService;
import com.company.utilizator.Adresa;
import com.company.utilizator.Contact;
import com.company.utilizator.Profesor;
import com.company.utilizator.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager
{
    private ProfesorService prof_service = ProfesorService.get_Instance();
    private StudentService student_service = StudentService.get_Instance();
    private CatalogService catalog_service = CatalogService.get_Instance();

    public static void createTabelAdresa() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS adresa " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "tara varchar(30), " +
                "judet varchar(30), " +
                "oras varchar(100), " +
                "strada varchar(200))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTabelContact() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS contact " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "email1 varchar(55), " +
                "email2 varchar(55), " +
                "telefon int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTabelSala() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS sala " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "etaj int, " +
                "cod varchar(55))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTabelMaterie() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS materie " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "denumire varchar(155), " +
                "nota_s double(5,3), " +
                "id_sala int, "+
                "FOREIGN KEY (id_sala) REFERENCES sala(id) ON DELETE CASCADE)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTabelStudent() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS student " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(55), " +
                "an_studiu int, "+
                "specializare varchar(155), " +
                "id_adresa int, "+
                "id_contact int, "+
                "FOREIGN KEY (id_adresa) REFERENCES adresa(id) ON DELETE CASCADE, "+
                "FOREIGN KEY (id_contact) REFERENCES contact(id) ON DELETE CASCADE)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTabelProfesor() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS profesor " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(55), " +
                "functie varchar(155), "+
                "id_materie int, "+
                "id_adresa int, "+
                "id_contact int, "+
                "FOREIGN KEY (id_materie) REFERENCES materie(id) ON DELETE CASCADE, "+
                "FOREIGN KEY (id_adresa) REFERENCES adresa(id) ON DELETE CASCADE, "+
                "FOREIGN KEY (id_contact) REFERENCES contact(id) ON DELETE CASCADE)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTabelFila() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS fila_catalog " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "id_student int, "+
                "id_profesor int, "+
                "FOREIGN KEY (id_student) REFERENCES student(id) ON DELETE CASCADE, "+
                "FOREIGN KEY (id_profesor) REFERENCES profesor(id) ON DELETE CASCADE)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAdresa(Adresa adresa)
    {
        String insertAddressSql = "INSERT INTO adresa VALUES(null, ?, ?,?,?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql);
            preparedStatement.setString(1, adresa.get_tara());
            preparedStatement.setString(2, adresa.get_judet());
            preparedStatement.setString(3, adresa.get_oras());
            preparedStatement.setString(4, adresa.get_strada());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insertContact(Contact con)
    {
        String insertAddressSql = "INSERT INTO contact VALUES(null, ?, ?,?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql);
            preparedStatement.setString(1, con.get_email1());
            preparedStatement.setString(2, con.get_email2());
            preparedStatement.setInt(3, con.get_tel());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insertSala(Sala sala)
    {
        String insertAddressSql = "INSERT INTO sala VALUES(null, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql);
            preparedStatement.setInt(1, sala.get_Etaj());
            preparedStatement.setString(2, sala.get_Cod());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

//    public int getIdSalaByCod(String codd)
//    {
//        String selectSql = "SELECT id FROM sala WHERE cod =" + codd;
//        Connection connection = DatabaseConfiguration.getDatabaseConnection();
//
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(selectSql);
//
//            while (resultSet.next())    {
//                var id = resultSet.getInt("id");
//                return id;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return 0;
//    }

    public void insertMaterie(Materie mat)
    {
        String insertAddressSql = "INSERT INTO materie VALUES(null, ?, ?,?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql);
            preparedStatement.setString(1,mat.get_Denumire());
            preparedStatement.setDouble(2, mat.get_Nota_student());
            preparedStatement.setInt(3,mat.get_Sala().get_Id());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student)
    {
        String insertAddressSql = "INSERT INTO student VALUES(null, ?, ?,?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql);
            preparedStatement.setString(1,student.get_Nume());
            preparedStatement.setInt(2, student.get_An());
            preparedStatement.setString(3, student.get_Specializare());
            preparedStatement.setInt(4,student.get_Adresa().get_id());
            preparedStatement.setInt(5,student.get_Contact().get_id());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insertProfesor(Profesor profesor)
    {
        String insertAddressSql = "INSERT INTO profesor VALUES(null, ?, ?,?, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql);
            preparedStatement.setString(1,profesor.get_Nume());
            preparedStatement.setString(2, profesor.get_Rank());
            preparedStatement.setInt(3, profesor.get_Materie().get_id());
            preparedStatement.setInt(4,profesor.get_Adresa().get_id());
            preparedStatement.setInt(5,profesor.get_Contact().get_id());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insertCatalog(Catalog catalog, int id_prf)
    {
        String insertAddressSql = "INSERT INTO fila_catalog VALUES(null, ?, ?)";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAddressSql);
            preparedStatement.setInt(1,catalog.get_Studenti().get_Id());
            preparedStatement.setInt(2, id_prf);
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public List<Adresa> getAllAddresses()
    {
        String selectSql = "SELECT * FROM adresa";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Adresa> addresses = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var tara = resultSet.getString("tara");
                var judet = resultSet.getString("judet");
                var oras = resultSet.getString("oras");
                var strada = resultSet.getString("strada");

                Adresa address = new Adresa(id, tara,judet,oras,strada);
                addresses.add(address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return addresses;
    }


    public List<Contact> getAllContacts()
    {
        String selectSql = "SELECT * FROM contact";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Contact> contacts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var email1 = resultSet.getString("email1");
                var email2 = resultSet.getString("email2");
                var telefon = resultSet.getInt("telefon");

                Contact contact = new Contact(id, email1,email2,telefon);
                contacts.add(contact);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return contacts;
    }


    public List<Sala> getAllRooms()
    {
        String selectSql = "SELECT * FROM sala";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Sala> rooms = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var etaj = resultSet.getInt("etaj");
                var cod = resultSet.getString("cod");

                Sala sala = new Sala(id, etaj,cod);
                rooms.add(sala);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rooms;
    }

    public Sala getRoomById(int x)
    {
        String selectSql = "SELECT * FROM sala WHERE id = "+x;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var etaj = resultSet.getInt("etaj");
                var cod = resultSet.getString("cod");

                Sala sala = new Sala(id, etaj, cod);

                return sala;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Materie> getAllMats()
    {
        String selectSql = "SELECT * FROM materie";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Materie> mats = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var denumire = resultSet.getString("denumire");
                var nota_s = resultSet.getDouble("nota_s");
                var sala = getRoomById(resultSet.getInt("id_sala"));

                Materie mat = new Materie(id, denumire,nota_s, sala);
                mats.add(mat);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return mats;
    }

    public Adresa getAddressById(int x)
    {
        String selectSql = "SELECT * FROM adresa WHERE id = "+x;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var tara = resultSet.getString("tara");
                var judet = resultSet.getString("judet");
                var oras = resultSet.getString("oras");
                var strada = resultSet.getString("strada");

                Adresa address = new Adresa(id, tara,judet,oras,strada);

                return address;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Contact getContactById(int x)
    {
        String selectSql = "SELECT * FROM contact WHERE id = "+x;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var email1 = resultSet.getString("email1");
                var email2 = resultSet.getString("email2");
                var telefon = resultSet.getInt("telefon");

                Contact contact = new Contact(id, email1,email2,telefon);

                return contact;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Materie getMaterieById(int x)
    {
        String selectSql = "SELECT * FROM materie WHERE id = "+x;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var denumire = resultSet.getString("denumire");
                var nota_s = resultSet.getDouble("nota_s");
                var sala = getRoomById(resultSet.getInt("id_sala"));

                Materie mat = new Materie(id, denumire,nota_s, sala);

                return mat;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int getAllStudents()
    {
        int check=0;
        String selectSql = "SELECT * FROM student";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
//        List<Student> studs = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var an_studiu = resultSet.getInt("an_studiu");
                var specializare = resultSet.getString("specializare");
                var adresa = getAddressById(resultSet.getInt("id_adresa"));
                var contact = getContactById(resultSet.getInt("id_contact"));

                if(adresa != null && contact != null)
                {
                    check=1;
                    Student student = new Student(id, nume,contact,adresa,an_studiu,specializare);
                    student_service.student_Add(student);

                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public int getAllProfs()
    {
        int check=0;
        String selectSql = "SELECT * FROM profesor";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
//        List<Student> studs = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var functie = resultSet.getString("functie");
                var materie = getMaterieById(resultSet.getInt("id_materie"));
                var adresa = getAddressById(resultSet.getInt("id_adresa"));
                var contact = getContactById(resultSet.getInt("id_contact"));

                if(adresa != null && contact != null && materie !=null)
                {
                    check=1;
                    Profesor prof = new Profesor(id, nume,contact,adresa,functie,materie);
                    prof_service.profesor_Add(prof);

                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public Student getStudentById(int x)
    {
        String selectSql = "SELECT * FROM student WHERE id = "+x;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var an_studiu = resultSet.getInt("an_studiu");
                var specializare = resultSet.getString("specializare");
                var adresa = getAddressById(resultSet.getInt("id_adresa"));
                var contact = getContactById(resultSet.getInt("id_contact"));

                if(adresa != null && contact != null)
                {
                    Student student = new Student(id, nume,contact,adresa,an_studiu,specializare);
                    return student;
                }
                else
                    return null;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public Profesor getProfesorById(int x)
    {
        String selectSql = "SELECT * FROM profesor WHERE id = "+x;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next())    {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var functie = resultSet.getString("functie");
                var materie = getMaterieById(resultSet.getInt("id_materie"));
                var adresa = getAddressById(resultSet.getInt("id_adresa"));
                var contact = getContactById(resultSet.getInt("id_contact"));

                if(adresa != null && contact != null && materie !=null)
                {
                    Profesor prof = new Profesor(id, nume,contact,adresa,functie,materie);
                    return prof;
                }
                else
                    return null;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


//    public void deleteStudent(int address_id)
//    {
//        int id1,id2;
//        try {
//            String deleteSql = "delete from student where id = ?";
//            getAddressById()
//            Connection connection = DatabaseConfiguration.getDatabaseConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
//            preparedStatement.setInt(1, address_id);
//            preparedStatement.execute();
//        }
//        catch (SQLException throwables)
//        {
//            throwables.printStackTrace();
//        }
//    }

    public void deleteStudent(int address_id)
    {
        try {
            String deleteSql = "delete from student where id = ?";
            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, address_id);
            preparedStatement.execute();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void deleteProf(int address_id)
    {
        try {
            String deleteSql = "delete from profesor where id = ?";

            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, address_id);
            preparedStatement.execute();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public void deleteFila(int address_id)
    {
        try {
            String deleteSql = "delete from fila_catalog where id = ?";

            Connection connection = DatabaseConfiguration.getDatabaseConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, address_id);
            preparedStatement.execute();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    public int getSize(String s)
    {
        int size=0;
        String selectSql = "SELECT COUNT(*) AS 'sz' FROM " +s;
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            if(resultSet.next())
            {
                size = resultSet.getInt("sz");
                return size;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return size;
    }

//    public Address getAddress(Long address_id) throws IndexOutOfBoundsException
//    {
//        Predicate<Address> c1 = p -> p.getId() == address_id;
//        var address = getAllAddresses().stream().filter(c1).toList().get(0);
//        return address;
//    }
}
