package bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application{

    @PostConstruct
    private void init(){
        List<Book> bookList = null;
        try{
            File file = new File("Books.dat");
            if(!file.exists()){
                Book book1 = new Book(12340, "George Orwell", "1984", "Post-Apocalyptic Fiction");
                Book book2 = new Book(8000, "J. R. R. Tolkien", "The Lord of the Rings", "Fantasy");
                Book book3 = new Book(9000, "Harper Lee", "To Kill a Mockingbird", "Southern Gothic Fiction");
                Book book4 = new Book(555, "Jane Austen", "Pride and Prejudice", "Comedy");
                bookList = new ArrayList<Book>();
                bookList.add(book1);
                bookList.add(book2);
                bookList.add(book3);
                bookList.add(book4);
                saveBookList(bookList);
            }
            else{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                bookList = (List<Book>) ois.readObject();
                ois.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
