package silveira.cadastro_de_clientes_backend.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByEmail(String email);
}
