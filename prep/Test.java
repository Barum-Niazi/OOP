class Movie {

    private String rating;
    private int id;
    private String title;

    Movie(String r, int id, String title) {
        setID(id);
        setRating(r);
        setTitle(title);
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return this.rating;
    }

    public int getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public boolean equals(Object m) {

        if (this.id == ((Movie) m).id)
            return true;
        else
            return false;
    }

    public void calcLateFees(int days) {
        int lateFees = 0;
        lateFees = days * 2;
        System.out.println("Your late fee is: " + lateFees + "$");
    }
}

class Action extends Movie {

    Action(String r, int id, String title) {
        super(r, id, title);
    }

    public void calcLateFees(int days) {
        int lateFees = 0;
        lateFees = days * 3;
        System.out.println("Your late fee is: " + lateFees + "$");
    }

}

class Comedy extends Movie {

    Comedy(String r, int id, String title) {
        super(r, id, title);
    }

    public void calcLateFees(int days) {
        double lateFees = 0;
        lateFees = days * 2.50;
        System.out.println("Your late fee is: " + lateFees + "$");
    }
}

class Drama extends Movie {

    Drama(String r, int id, String title) {
        super(r, id, title);
    }

    public void calcLateFees(int days) {
        int lateFees = 0;
        lateFees = days * 2;
        System.out.println("Your late fee is: " + lateFees + "$");
    }
}

public class Test {
    public static void main(String[] args) {
        Movie m = new Movie("PG-13", 1, "Batman");
        Action a = new Action("Rated G", 2, "ActionMovie");
        Comedy c = new Comedy("Rated R", 1, "Comedy");
        Drama d = new Drama("Rated G", 3, "Drama");

        m.equals(c);
        if (m.equals(c) == true)
            System.out.println("Movies are identical.");
        else
            System.out.println("Movies are not identical");

        m.equals(a);
        if (m.equals(a) == true)
            System.out.println("Movies are identical.");
        else
            System.out.println("Movies are not identical");

        m.calcLateFees(2);
        a.calcLateFees(2);
        c.calcLateFees(2);
        d.calcLateFees(2);
    }
}