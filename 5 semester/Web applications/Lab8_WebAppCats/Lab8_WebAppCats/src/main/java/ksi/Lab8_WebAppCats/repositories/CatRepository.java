package ksi.Lab8_WebAppCats.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ksi.Lab8_WebAppCats.models.Cat;

@Repository
public
interface CatRepository extends JpaRepository<Cat,Long> {

}
