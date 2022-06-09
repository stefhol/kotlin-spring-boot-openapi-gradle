package default.services

import default.model.Person
import default.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


    @Service
class DbUserService {
        @Autowired
        private val userRepository: UserRepository? = null
        fun list(): List<Person?> {
            return userRepository?.findAll() ?: list()
        }
        fun add(entity:Person):Boolean {
            val result = userRepository?.save(entity)
            if (result!=null){
                return true
            }
            return false
        }
        fun getById(id:Long):Person?{
            return userRepository?.getReferenceById(id)
        }

}