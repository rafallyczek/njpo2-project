package njpo2.project.bookrepo.file;

import njpo2.project.bookrepo.book.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileHandler {

    //Utworzenie listy książek na podstawie danych z pliku
    public List<Book> convertToBookList(List<String> lines){
        List<Book> books = new ArrayList<>();
        for(int i=0;i<lines.size();i++){
            String line = lines.get(i);
            List<String> fields = Arrays.asList(line.split(";"));
            books.add(new Book(fields.get(0),fields.get(1),fields.get(2),fields.get(3)));
        }
        return books;
    }

    //Wczytanie danych z pliku
    public List<String> readFromFile(MultipartFile file){
        BufferedReader bufferedReader;
        List<String> result = new ArrayList<>();
        try{
            String line;
            InputStream inputStream = file.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while((line=bufferedReader.readLine())!=null){
                result.add(line);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return result;
    }

}
