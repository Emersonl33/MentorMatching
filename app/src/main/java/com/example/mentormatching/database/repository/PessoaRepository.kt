package com.example.mentormatching.database.repository

import android.content.Context
import com.example.mentormatching.database.dao.PessoaDB
import com.example.mentormatching.model.Pessoa

class PessoaRepository(context: Context) {

    private var db = PessoaDB.getDatabase(context).PessoaDao()

    fun salvar(pessoa: Pessoa): Long{
        return db.salvar(pessoa = pessoa)
    }
    fun atualizar(pessoa: Pessoa): Int{
        return db.atualizar(pessoa = pessoa)
    }
    fun excluir(pessoa: Pessoa): Int{
        return db.excluir(pessoa = pessoa)
    }
    fun buscarPessoaPeloId(id: Long): Pessoa{
        return db.buscarPessoaPeloId(id = id)
    }
    fun listarContatos(): List<Pessoa>{
        return db.listarPessoas()
    }
    fun authenticate(email: String, password: String): Pessoa? {
        return db.auth(email, password)
    }
}
