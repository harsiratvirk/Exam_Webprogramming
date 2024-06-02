package oslomet.exam_webprogramming;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository rep;
    @Autowired
    private HttpSession session;

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        List<Book> books = rep.getBooks();
        return books;
    }

    @PutMapping("/modifyBook")
    public void modifyBook(Book book) {
        rep.modifyBook(book);
    }

    @DeleteMapping("/deleteBook")
    public void deleteBook(int id, HttpServletResponse response) throws IOException {
        if(!rep.deleteBook(id)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error in the DB");
        }
    }

    @GetMapping("/statistic")
    public String statistic() {
        return rep.statistic();
    }

    @PostMapping("/login")
    public void login(User user) {
        if(rep.login(user)) {
            session.setAttribute("Logged",user);
        }
    }

    @GetMapping("/logout")
    public void logout() {
        session.removeAttribute("Logged");
    }

    @DeleteMapping("/deletePoetry")
    public void deletePoetry(Book book, HttpServletResponse response) throws IOException {
        if(session.getAttribute("Logged" != null)) {
            if(!rep.deletePoetry(book)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error in the DB");
            }
        } else {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Must login first!");
        }
    }
}