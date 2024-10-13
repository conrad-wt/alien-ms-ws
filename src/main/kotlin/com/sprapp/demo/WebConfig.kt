package com.sprapp.demo

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")  // Apply CORS to all endpoints
            .allowedOrigins("http://localhost:8088")  // Allow requests from this origin
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
            .allowedHeaders("*")  // Allow all headers
            .allowCredentials(true)  // Allow credentials like cookies or Authorization headers
    }
}
