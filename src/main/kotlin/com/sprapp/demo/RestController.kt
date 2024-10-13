package com.sprapp.demo

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import com.sprapp.demo.repo.AlienRepo
import com.sprapp.demo.model.Alien

@RestController
@RequestMapping("/api/v1/aliens")
class RestController(private val repository: AlienRepo) {

    @GetMapping
    fun getAliens(): List<Alien> = repository.getAliens()

    @GetMapping("/{alienId}")
    fun getAlien(@PathVariable alienId: Int): Alien? = repository.getAlien(alienId)

    @PostMapping
    fun saveArticle(@RequestBody article: String): Nothing = TODO() // = repository.saveArticle(article)

    @PutMapping
    fun updateArticle(@RequestBody article: String, @PathVariable slug: String): Nothing = TODO() // = repository.updateArticle(article, slug)

    @DeleteMapping
    fun deleteArticle(@PathVariable slug: String): Nothing = TODO() // = repository.deleteArticle(slug)
}