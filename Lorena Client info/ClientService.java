package com.example.demo.client;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

        private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getClient(){
       return clientRepository.findAll();

    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
            clientRepository.save(client);
        }

    public void deleteClient(Long clientId) {

     boolean exists =  clientRepository.existsById(clientId);
     if(!exists) {
         throw new IllegalStateException("client with id"  + clientId + "does not exists");
     }
    clientRepository.deleteById(clientId);
    }
    @Transactional
    public void updateClient(Long clientId, String first_name, String last_name, String email, String gender) {
    Client client = clientRepository.findById(clientId).orElseThrow(()->new IllegalStateException("client with id"+ clientId
    + "does not exist"));

    if ( first_name != null && first_name.length()>0 && !Objects.equals(client.getFirst_name(),first_name)){
        client.setFirst_name(first_name);
         }
         if ( last_name != null && last_name.length()>0 && !Objects.equals(client.getLast_name(),last_name)){

             client.setLast_name(last_name);
         }

         if ( email != null && email.length()>0 && !Objects.equals(client.getEmail(),email)){
            Optional<Client> clientOptional = clientRepository.findClientByEmail(email);
            if(clientOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
             client.setEmail(email);
         }

         if ( gender != null && gender.length()>0 && !Objects.equals(client.getGender(),gender)){

             client.setGender(gender);
        } }

    }


