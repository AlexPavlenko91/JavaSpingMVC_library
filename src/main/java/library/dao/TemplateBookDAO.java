package library.dao;

public class TemplateBookDAO {
    private static final String INSERT = "INSERT INTO `books` values (?,?)";
    private static final String SELECT = "SELECT * from `books` where id_book = ?";
}
