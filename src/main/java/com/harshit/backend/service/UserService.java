package com.harshit.backend.service;

import com.harshit.backend.request.RoleBasedRequest;
import com.harshit.backend.request.UserById;
import com.harshit.backend.response.ResponsePayload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {
    List<ResponsePayload> getAllUsers() throws IOException;

    List<ResponsePayload> getRoleBasedUsers(RoleBasedRequest role);

    List<ResponsePayload> getSortedUsers();

    ResponsePayload getUserById(UserById role);


}
