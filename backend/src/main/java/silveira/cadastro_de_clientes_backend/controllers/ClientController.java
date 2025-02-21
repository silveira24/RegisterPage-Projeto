package silveira.cadastro_de_clientes_backend.controllers;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import silveira.cadastro_de_clientes_backend.domain.client.Client;
import silveira.cadastro_de_clientes_backend.domain.client.ClientRepository;
import silveira.cadastro_de_clientes_backend.domain.client.RequestClient;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public ResponseEntity getAllClients() {
        var allClients = repository.findAll();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping
    public ResponseEntity registerClient(@RequestBody @Valid RequestClient data) {
        Optional<Client> optionalClient = repository.findByEmail(data.email());
        if(optionalClient.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já em uso");
        }

        Client newClient = new Client(data);
        repository.save(newClient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable String id) {
        Optional<Client> optionalClient = repository.findById(id);
        if(optionalClient.isPresent()) {
            Client client = optionalClient.get();
            repository.delete(client);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
