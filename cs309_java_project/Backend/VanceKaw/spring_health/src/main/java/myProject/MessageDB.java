package myProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDB extends JpaRepository<Message, Long>{

}
