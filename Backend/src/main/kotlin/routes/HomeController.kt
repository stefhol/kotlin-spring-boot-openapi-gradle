package default.routes
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * Home redirection to OpenAPI api documentation
 */
@Controller
class HomeController {
    @GetMapping("/")
    fun index(): String = "Hello World"
}
