package ksi.springbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ksi.springbooks.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
