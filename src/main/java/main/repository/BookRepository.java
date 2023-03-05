package main.repository;

import main.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
    List<BookModel> findAll();
}
