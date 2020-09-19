package com.example.JForce.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.JForce.model.SignUpdata;


@Repository
public interface SignUpdataRepository extends CrudRepository<SignUpdata, Integer> {

}
