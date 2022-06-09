package default.api

import default.model.Person
import gen.api.UsersApiDelegate
import gen.model.User
import gen.model.UsersGet200Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.context.request.NativeWebRequest
import java.util.*
import default.services.DbUserService

@Service
class UsersApiService(private val dbUserService: DbUserService):UsersApiDelegate  {
    override fun getRequest(): Optional<NativeWebRequest> {
        return super.getRequest()
    }

    override fun usersGet(): ResponseEntity<UsersGet200Response> {
        val users= dbUserService.list().stream().filter{ it != null }.map { User(id = it?.id?:0, name = it?.name.orEmpty(), tag = ""  ) }.toList()
        return ResponseEntity<UsersGet200Response>(UsersGet200Response(propertyValues = users, count = users.size),HttpStatus.OK)
    }

    override fun showUserById(userId: Long): ResponseEntity<User> {
        val person= dbUserService.getById(userId)?:return ResponseEntity(HttpStatus.BAD_REQUEST)
        val user = User(person.id?:0,person.name,"")
        return ResponseEntity<User>(user,HttpStatus.OK)
    }

    override fun addUser(user: User): ResponseEntity<Unit> {
            val person = Person()
            person.name = user.name
            val success = dbUserService.add(person)
            if (success){
                return ResponseEntity(HttpStatus.CREATED)
            }
            return ResponseEntity(HttpStatus.BAD_REQUEST)

    }

    override fun updateUserById(userId: Long, user: User): ResponseEntity<Unit> {
        val dbUser = dbUserService.getById(userId) ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        dbUser.name = user.name
        return ResponseEntity(HttpStatus.OK)
    }
}
