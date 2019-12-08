package Model;

import javax.persistence.*;

@Entity
@Table(name="purchases")
public class Purchase {
    private static final long serialVersionUID = -8718578618578349488L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "count")
    private int count;

    @Column(name = "isBought")
    private boolean isBought;

    public Purchase() {}

    public Purchase(String name, float price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.isBought = false;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public boolean getIsBought() {
        return isBought;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setIsBought(boolean bought) {
        isBought = bought;
    }
}
