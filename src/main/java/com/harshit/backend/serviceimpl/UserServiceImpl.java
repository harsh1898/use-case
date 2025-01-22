package com.harshit.backend.serviceimpl;


import com.harshit.backend.helper.BackendUrlCall;
import com.harshit.backend.repository.UserRepo;
import com.harshit.backend.request.RoleBasedRequest;
import com.harshit.backend.request.UserById;
import com.harshit.backend.response.ResponsePayload;
import com.harshit.backend.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BackendUrlCall backendUrlCall;

    @Override
    public List<ResponsePayload> getAllUsers() throws IOException {

        if(ObjectUtils.isEmpty(userRepo.findAll())) {
            return backendUrlCall.callThirdPartyApi();
        }else{
            return (List<ResponsePayload>) userRepo.findAll();
        }
    }

    @Override
    public List<ResponsePayload> getRoleBasedUsers(RoleBasedRequest inputRole) {
        String roleValue = inputRole.getRole();
        return userRepo.findByRole(roleValue);
    }
    @Override
    public List<ResponsePayload> getSortedUsers() {
        return userRepo.findSortedUsers();
    }

    @Override
    public ResponsePayload getUserById(UserById id) {
        try {
            int idValue = id.getId();
            return userRepo.findById(idValue);
        } catch (NullPointerException e) {
            throw new NullPointerException("User not found");
        }
    }

}
