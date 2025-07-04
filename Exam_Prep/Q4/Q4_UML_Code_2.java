package Q4;

import java.util.Date;

public class Q4_UML_Code_2 {

}

interface Borrowable {
    Date borrow(String memberID);
}

interface Returnable {
    void returnItem(String memberID);
}

abstract class Member {
    protected String memberID;
    protected String name;

    public Member(String id, String name) {
        this.memberID = id;
        this.name = name;
    }

    public boolean validate() {
        return this.memberID != null && !this.memberID.isEmpty();
    }

    public abstract void notify(String message);
}

class StudentMember extends Member {
    protected String course;

    public StudentMember(String id, String name, String course) {
        super(id, name);
        this.course = course;
    }

    @Override
    public void notify(String message) {
        System.out.println("this is noti.");
    }
}

class FacultyMember extends Member {
    protected String department;

    public FacultyMember(String id, String name, String dp) {
        super(id, name);
        this.department = dp;
    }

    public void notify(String message) {
        System.out.println("This is FacultyMember noi.");
    }
}

abstract class LibraryItem {
    protected String itemID, title;

    public LibraryItem(String id, String title) {
        this.itemID = id;
        this.title = title;
    }

    public boolean checkAvailability() {
        return this.itemID != null;
    }

    public abstract Date borrow(String memberID);

    public abstract void returnItem(String memberID);
}

class Book extends LibraryItem implements Borrowable, Returnable {
    protected String author;
    protected String isbn;

    public Book(String id, String title, String author, String isbn) {
        super(id, title);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public Date borrow(String memberID) {
        return new Date();
    }

    public void returnItem(String memberID) {
        System.out.println(memberID + "Book returned.");
    }
}

class DVD extends LibraryItem implements Borrowable, Returnable {
    protected String director;
    protected int regionCode;

    public DVD(String id, String title, String director, int code) {
        super(id, title);
        this.director = director;
        this.regionCode = code;
    }

    public Date borrow(String id) {
        return new Date();
    }

    public void returnItem(String id) {
        System.out.println(id + "DVD returned.");
    }
}