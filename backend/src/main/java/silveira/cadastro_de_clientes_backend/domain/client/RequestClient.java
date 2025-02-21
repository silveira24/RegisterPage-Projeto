package silveira.cadastro_de_clientes_backend.domain.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestClient(
        String id,
        @NotBlank
        String name,
        @NotNull
        Integer age,
        @NotBlank
        String email) {
}
