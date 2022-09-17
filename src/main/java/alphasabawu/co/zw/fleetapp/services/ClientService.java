package alphasabawu.co.zw.fleetapp.services;
import alphasabawu.co.zw.fleetapp.models.Client;
import alphasabawu.co.zw.fleetapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    // Get Clients
    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    // Add Clients
    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public Optional<Client> getClientByID(int id) {
        return clientRepository.findById(id);
    }

    public void removeClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
