package com.julian.lista.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.lista.models.contact;

@Repository
public interface contactrepo extends CrudRepository<contact, Long>{

}