package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/client")


public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClient(){
        return clientService.getClient();
    }


    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);

    }
    @DeleteMapping(path = "{clientId}")
   public void deleteClient(@PathVariable("clientIs") Long clientId)
    {
        clientService.deleteClient(clientId);

    }
/*
    @PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable(" clientId") Long clientId,
            @RequestParam(required = false) String first_name,
            @RequestParam(required = false) String last_name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String gender){
        clientService.updateClient(clientId, first_name, last_name, email, gender);
    }
    */




}
