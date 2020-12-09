package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Meow;
import pl.coderslab.entity.User;

import java.util.List;

public interface MeowRepository extends JpaRepository<Meow, Long> {

    List<Meow> findAllByUserOrderByCreatedDesc(User user);


}

