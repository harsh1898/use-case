package com.harshit.backend.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshit.backend.repository.UserRepo;
import com.harshit.backend.response.ResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class BackendUrlCall {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserRepo userRepo;

    ObjectMapper mapper = new ObjectMapper();


    public List<ResponsePayload> callThirdPartyApi() throws IOException {
        ResponsePayload responsePayload = new ResponsePayload();
        String url = "https://dummyjson.com/users";
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        JsonNode usersNode = response.path("users");
        for (JsonNode userNode : usersNode) {
            responsePayload = mapper.treeToValue(userNode, ResponsePayload.class);
            try {
                userRepo.save(responsePayload);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }

        return (List<ResponsePayload>) userRepo.findAll();
    }
}
