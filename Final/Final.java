import java.util.Scanner;

import javax.sound.midi.Soundbank;

class Publication {
    private String title;
    private double price;

    Publication(double price, String title) {
        setPrice(price);
        setTitle(title);

        this.price = getPrice();
        this.title = getTitle();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void display() {
        System.out.println("This publication has the price: " + this.price);
        System.out.println("This publication has the title: " + this.title);
    }
}

class Book extends Publication {
    private int pageCount;

    Book(double price, String title, int pageCount) {
        super(price, title);
        setPageCount(pageCount);
        this.pageCount = getPageCount();
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void display() {
        System.out.println("This book has the price: " + this.getPrice());
        System.out.println("This book has the title: " + this.getTitle());
        System.out.println("This book has page count of: " + this.pageCount);
    }
}

class Tape extends Publication {
    private int playingTime;

    Tape(double price, String title, int playingTime) {
        super(price, title);
        setPlayingTime(playingTime);
        this.playingTime = getPlayingTime();
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void display() {
        System.out.println("This tape has the price: " + this.getPrice());
        System.out.println("This tape has the title: " + this.getTitle());
        System.out.println("This tape has play time of: " + this.playingTime + " minutes");
    }
}

class Computer {
    public int wordSize;
    public int memorySize;
    public int storageSize;
    public int speed;

    Computer() {

    }

    Computer(int wordSize, int memorySize, int storageSize, int speed) {
        this.wordSize = wordSize;
        this.memorySize = memorySize;
        this.storageSize = storageSize;
        this.speed = speed;
    }

    public void display() {
        System.out.println("This computer has wordsize of: " + this.wordSize * 8 + " bits");
        System.out.println("This computer has memory size of: " + (this.memorySize / 1024 * 1024) + " megabytes");
        System.out.println("This computer has storage size of: " + (this.storageSize / 1024 * 1024) + " megabytes");
        System.out.println("This computer has speed of: " + this.speed + "MHz");
    }
}

class Laptop extends Computer {
    public int length;
    public int weight;
    public int width;
    public int height;

    Laptop() {

    }

    Laptop(int length, int weight, int width, int height, int word, int memory, int storage, int mhz) {
        super(word, memory, storage, mhz);
        this.length = length;
        this.weight = weight;
        this.width = width;
        this.height = height;
    }

    public void display() {
        System.out.println("This laptop has wordsize of: " + this.wordSize * 8 + " bits");
        System.out.println("This laptop has memory size of: " + (this.memorySize / 1024 * 1024) + " megabytes");
        System.out.println("This laptop has storage size of: " + (this.storageSize / 1024 * 1024) + " megabytes");
        System.out.println("This laptop has speed of: " + this.speed + "MHz");
        System.out.println("This laptop has length in cm: " + this.length);
        System.out.println("This laptop has width in cm: " + this.width);
        System.out.println("This laptop has height in cm: " + this.height);
        System.out.println("This laptop has weight in kg: " + this.weight);
    }
}

public class Final {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter price and name of your publication");
        Publication pub = new Publication(input.nextDouble(), input.nextLine());
        pub.display();

        System.out.println("Enter price, name and page count of your book");
        Book book = new Book(input.nextDouble(), input.nextLine(), input.nextInt());
        book.display();

        System.out.println("Enter price, name and play time of your tape");
        Tape tape = new Tape(input.nextDouble(), input.nextLine(), input.nextInt());
        tape.display();

        Computer computer = new Computer(8, 102400, 1024000, 20);
        computer.display();
        Laptop laptop = new Laptop(20, 5, 15, 20, 10, 1024, 24680, 30);
        laptop.display();
    }

}
