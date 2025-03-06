package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  @Modifying
  @Query(
    value = """
    insert into products(id, code, name)
    values(:#{#p.id}, :#{#p.code}, :#{#p.name})
    """,
    nativeQuery = true
  )
  void createProductIfNotExists(@Param("p") Product product);
}
