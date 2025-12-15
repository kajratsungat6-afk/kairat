public class Class {
    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Class(){
        this.id = idGen++;
        this.available = true;
    }

    public Class(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);

    }



    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean getAvailable() {
        return available;
    }


    public void setTitle(String title){
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");

        }
        this.title = title;
    }
    public void setAuthor(String author){
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.author = author;
    }
    public void setYear(int year){
        if (year < 1500 || year > 2025) {
            throw new IllegalArgumentException("Year must be between 1500 and 2025");
        }
        this.year = year;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }
    public void markAsBorrowed() {
        available = false; // книга взята, значит больше не доступна
    }
    public void markAsReturned() {
        available = true; // книга вернулась на полку
    }
    @Override
    public String toString() {
        return "Book{id=" + id +
                ", title='" + title + '\'' +
                ",author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }



}
