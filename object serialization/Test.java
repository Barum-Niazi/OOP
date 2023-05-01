import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cars implements Serializable {
    String company;
    String model;
    transient String make;
    int price;

    Cars(String company, String model, int price, String make) {
        this.company = company;
        this.model = model;
        this.price = price;
        this.make = make;
    }

    public String toString() {
        return "Company: " + company + "\n" + "Model: " + model + "\n" + "Price: $" +
                price + "\n" + "Make: ";
    }
}

public class Test {
    public static void main(String[] args) throws IOException {

        try {
            ObjectInputStream lala = new ObjectInputStream(new FileInputStream("handling"));
            Cars cn[] = new Cars[2];
            cn[0] = (Cars) lala.readObject();
            cn[1] = (Cars) lala.readObject();

            for (int i = 0; i < cn.length; i++) {
                System.out.println(cn[i]);

            }
        } catch (Exception e) {

        }

    }
}
