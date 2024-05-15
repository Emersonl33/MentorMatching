package com.example.mentormatching.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mentormatching.model.Pessoa

@Dao
interface PessoaDao {
    @Insert
    fun salvar(pessoa: Pessoa): Long
    @Update
    fun atualizar(pessoa: Pessoa): Int
    @Delete
    fun excluir(pessoa: Pessoa): Int
    @Query("SELECT * FROM tb_pessoa WHERE email = :email AND password = :password LIMIT 1")
    fun auth(email: String, password: String): Pessoa?
    @Query("SELECT * FROM tb_pessoa WHERE id = :id")
    fun buscarPessoaPeloId(id: Long): Pessoa
    @Query("SELECT * FROM tb_pessoa ORDER BY name ASC")
    fun listarPessoas(): List<Pessoa>
}