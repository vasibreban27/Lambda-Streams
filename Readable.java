package utcn;

import java.util.List;

public interface Readable {
    void read();

    default void readAll(){
        for(int i=0; i<5; i++)
            read();
    }
    static List<String> getSupportedFormats(){
        return List.of("PDF","TXT","DOCX","EPUB");
    }
}

class Book implements Readable {
    private int currentPage = 1;

    public void read(){
        System.out.println("Reading page "+currentPage);
        currentPage++;
    }
}

class PDFDocument implements Readable {
    private int cursor = 0;
    public void read(){
        System.out.println("Reading from position "+cursor);
        cursor+=10;
    }
}

class TestReadable{
    public static void main(String[] args) {
        PDFDocument pdf = new PDFDocument();
        pdf.readAll();
        Book book = new Book();
        book.readAll();
    }
}
