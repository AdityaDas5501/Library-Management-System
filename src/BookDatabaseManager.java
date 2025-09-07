import java.io.*;
import java.util.ArrayList;
public class BookDatabaseManager {
    String fileName = "Book_List.csv";
    public void write(int bookId,String title,String author){
        //Check whether csv file exist
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            try(FileWriter writer = new FileWriter(fileName,true)) {
                writer.write(bookId+","+title+","+author+"\n");
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        catch(IOException e1){
            //If csv file don't exist then create a new one and add the book
            try (FileWriter writer = new FileWriter(fileName)) {
            //header row
            writer.write("Book Id,Title,Author\n");
            writer.write(bookId+","+title+","+author+"\n");
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void loadBooksFromDB(ArrayList<Book> books){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //Skip header row
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma
                String[] data = line.split(",");
                books.add(new Book(Integer.parseInt(data[0]),data[1],data[2]));
            }
        }
        catch (IOException e){}
    }
}
