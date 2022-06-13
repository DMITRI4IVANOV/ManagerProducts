package Product;

import java.util.Objects;

public class Smartphone extends Product {
    private String company;


    public Smartphone(int id, String title, int price, String company) {
        super(id, title, price);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany( String company) {
        this.company = company;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone smartphone = (Smartphone) o;
        return Objects.equals(company, smartphone.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "maker='" + company +
                '}';
    }

    @Override
    public boolean matches( String search) {
        if (super.matches(search)) {
            return  true;
        }
        if (getCompany().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
