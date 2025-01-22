package com.harshit.backend.repository;

import com.harshit.backend.response.ResponsePayload;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<ResponsePayload, Integer> {

    @Query("SELECT u FROM ResponsePayload u WHERE u.role =:role")
    List<ResponsePayload> findByRole(String role);

    @Query("SELECT u FROM ResponsePayload u ORDER BY u.age")
    List<ResponsePayload> findSortedUsers();

    @Query("SELECT u FROM ResponsePayload u WHERE u.id =:id")
    ResponsePayload findById(int id);
}
