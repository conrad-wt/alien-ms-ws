package com.sprapp.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.sprapp.demo.repo.AlienRepo
import com.sprapp.demo.model.Alien
import kotlin.reflect.jvm.jvmName

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	val appContext = runApplication<DemoApplication>(*args)

	val alien = Alien(4, "Gipnu", "Bangslang")
	val alienRepo: AlienRepo = appContext.getBean(AlienRepo::class.java) as AlienRepo
	alienRepo.getAliens()
	alienRepo.saveAlien(alien)
	alienRepo.getAliens()
}
