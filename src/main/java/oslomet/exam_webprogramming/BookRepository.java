package oslomet.exam_webprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate db;
    private Logger logger = LoggerFactory.getLogger(BookRepository.class);

    public List<Book> getBooks() {
        String sql = "SELECT * FROM Book";
        List<Book> books = db.query(sql, new BeanPropertyRowMapper(Book.class));
        return books;
    }

    public void modifyBook(Book book) {
        String sql = "UPDATE Book SET year='2024' WHERE id=6";
        db.update(sql, book.getYear(), book.getId());
    }

    public boolean deleteBook(int id) {
        String sql = "DELETE FROM Book WHERE id=?";
        try {
            db.update(sql, id);
            return true;
        } catch (Exception e) {
            logger.error("Error in method deleteBook: " +e);
            return false;
        }
    }

    public String statistic() {
        String books = "SELECT * FROM Book";
        String authors = "SELECT * FROM Book WHERE author > 1";
        String oldestBook = "SELECT * FROM Book ORDER BY year ASC LIMIT 1";
        // alterantively we could use Collections.sort to find the oldest book:
        // books.sort(books, Comparator.comparing(Book::getYear)

        List<Book> book = db.query(books, new BeanPropertyRowMapper(Book.class));
        List<Book> author = db.query(authors, new BeanPropertyRowMapper(Book.class));

        String text = "";
        int totalBooks = 0;
        for (Book b : book) {
            ++totalBooks;
        }
        text += "The library has a total of " + totalBooks;

        int aut = 0;
        for (Book a : author) {
            ++aut;
        }
        text += "Authors that appear more than once: " + aut +
                "Oldest book from the list: " + oldestBook;
        return text;
    }

    public boolean login(User user) {
        String sql = "SELECT * FROM User WHERE username=?";
        User dbUser = db.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class),
                user.getUsername());
        return BCrypt.checkpw(user.getPassword(), dbUser.getPassword);
    }

    public boolean deletePoetry(Book book) {
        String deletePoetry = "DELETE Poetry FROM Book WHERE year > 2000";
        try {
            db.update(deletePoetry, book.getYear());
            return true;
        } catch (Exception e) {
            logger.error("Error in method deletePoetry: " +e);
            return false;
        }
    }
}