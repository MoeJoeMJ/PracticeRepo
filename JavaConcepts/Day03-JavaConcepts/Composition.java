
// Misuse of Inheritance

class Customer {

    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

// Inheritance is not the right choice as Order and Customer doesn't have is-a relationship 
/*
class Order extends Customer {

    private String product;
    private String count;

    public Order(String product, String count, String name, String address) {
        super(name, address);
        this.product = product;
        this.count = count;
    }

    public String getProduct() {
        return product;
    }

    public String getCount() {
        return count;
    }

    public String postalAddress() {
        return this.getName() + "\n" + this.getAddress();
    }
}
*/



// Using Customer as object variable because they have has-a relationship 
class Order {

    private Customer customer;
    private String product;
    private String count;

    public Order(Customer customer, String product, String count) {
        this.customer = customer;
        this.product = product;
        this.count = count;
    }

    public String getProduct() {
        return product;
    }

    public String getCount() {
        return count;
    }

    public String postalAddress() {
        return this.customer.getName() + "\n" + this.customer.getAddress();
    }
}

public class Composition {
    public static void main(String[] args) {
        Customer customer = new Customer("Manoj", "123 Cor street, Nazareth");
        Order order = new Order(customer, "Mobile", "2");
        System.out.println(order.getProduct());
        System.out.println(order.getCount());
        System.out.println(order.postalAddress());
    }
}

/*
Ouput:
        Mobile
        2
        Manoj
        123 Cor street, Nazareth
*/
