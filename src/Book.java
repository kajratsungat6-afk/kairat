import java.util.ArrayList;

public class Book {
    private int id;
    private static int id_Gen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private static ArrayList<Book> books = new ArrayList<>();


    public Book(){
        id = id_Gen++;
        available = true;
    }

    public Book(String title, String author, int year){
        this();
        setAuthor(author);
        setYear(year);
        setTitle(title);
    }


    public void setAuthor(String author) {
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException();
        }
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int year) {
        if (year < 1500 || year > 2025) {
            throw new IllegalArgumentException();
        }
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }


    public void markAsReturned(){
        this.available = true;
    }
    public void markAsBorrowed(){
        this.available = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }


}
