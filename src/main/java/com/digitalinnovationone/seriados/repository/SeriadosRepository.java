package com.digitalinnovationone.seriados.repository;

import com.digitalinnovationone.seriados.document.Seriados;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SeriadosRepository extends CrudRepository<Seriados, String> {
}
