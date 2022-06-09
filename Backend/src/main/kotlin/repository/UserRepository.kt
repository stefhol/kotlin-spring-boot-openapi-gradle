package default.repository

import default.model.Person
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository : JpaRepository<Person, Long> {
}

