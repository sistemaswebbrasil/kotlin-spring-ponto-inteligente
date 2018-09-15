package com.siswbrasil.pontointeligente.repositories

import com.siswbrasil.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.transaction.annotation.Transactional

interface LancamentoRepository : MongoRepository<Lancamento, String> {

    @Transactional(readOnly = true)
    fun findByFuncionarioId(funcionarioId: String, pageRequest: Pageable): Page<Lancamento>
}