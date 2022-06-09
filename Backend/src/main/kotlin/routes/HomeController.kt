package default.routes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Home redirection to OpenAPI api documentation
 */
@RestController
class HomeController {
    @GetMapping("/")
    fun index(): String = "Hello World"
}
