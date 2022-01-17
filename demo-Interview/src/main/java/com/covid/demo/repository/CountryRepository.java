/**
 * 
 */
package com.covid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.demo.entities.Country;

/**
 * @author ameni.zouaoui
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String>{

}
