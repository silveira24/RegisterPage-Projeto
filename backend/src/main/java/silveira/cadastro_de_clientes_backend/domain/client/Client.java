package silveira.cadastro_de_clientes_backend.domain.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="client")
@Entity(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer age;
    private String email;

    public Client(RequestClient client) {
        this.name = client.name();
        this.age = client.age();
        this.email = client.email();
    }
}
