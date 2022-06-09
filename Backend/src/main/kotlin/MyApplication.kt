package default


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@SpringBootApplication
class MyApplication {
    fun main(args: Array<String>){

    }
    //scans gen package which is generated
    @ComponentScan(basePackages = ["gen"])
    @Configuration
    class SpringComponentScanApp {
    }


}

/**
 * This Config is for Development only it disables all Security measures to
 * have access from different HTTP Clients
 */
@EnableWebSecurity
class WebSecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors { corsConfigurationSource() }
        http.csrf().and().csrf().disable()
        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:3000","http://localhost:3001")
        configuration.allowedMethods = listOf("GET", "POST","PUT","DELETE")
        configuration.allowCredentials = true
        configuration.allowedHeaders = listOf("*")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}
