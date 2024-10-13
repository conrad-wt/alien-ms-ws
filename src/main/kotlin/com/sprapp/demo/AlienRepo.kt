package com.sprapp.demo.repo

import com.sprapp.demo.model.Alien
import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import org.springframework.beans.factory.annotation.Autowired

@Repository
class AlienRepo(){
    private val alienRowMapper = AlienRowMapper()

    @Autowired
    private val template = JdbcTemplate()

    fun saveAlien(alien: Alien) {
        val sql = "insert into alien (id, name, tech) values (?, ?, ?)"
        val rows = template.update(sql, alien.id, alien.name, alien.tech)
        println("Rows affected: $rows")
    }

    fun getAliens(): List<Alien> {
        val sql = "select * from alien"
        val rows = template.query(sql, alienRowMapper)
        println("Alien list: $rows")
        return rows.toList()
    }

    fun getAlien(id: Int): Alien? {
        val sql = "select * from alien where id = ?"
        val alien = template.queryForObject(sql, alienRowMapper, id)
        return alien
    }

    fun updateAlien(alien: Alien){
        val sql = "update alien set name = ?, tech = ? where id = ?"
        val rows = template.update(sql, alien.name, alien.tech, alien.id)
        println("Rows affected: $rows")
    }
}

class AlienRowMapper: RowMapper<Alien> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Alien = Alien(rs.getInt("id"), rs.getString("name"), rs.getString("tech"));

 }