package com.desafio.banco.repositories;

import com.desafio.banco.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT obj FROM Account obj WHERE UPPER(obj.nickname) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Account> findByAccountName(String name, Pageable pageable);


}
