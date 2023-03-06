package main.model;

//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //@NotBlank("username is required")
    private String username;
   //@NotBlank("password is required")
    private String password;
    private String email;
    private String shippingAddress;
    private String billingAddress;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private ShoppingCartModel shoppingCart;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<OrderModel> orderList;
    // toString

    public UserModel(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String toString() {
        return "User #: " + id + "\n" + "Username: " + username + "\n" + "Billing Address: " + billingAddress + "\n" + "Shipping Address: " + shippingAddress + "\n";
    }
}
