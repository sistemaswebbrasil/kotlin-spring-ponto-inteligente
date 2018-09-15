package com.siswbrasil.pontointeligente.services

import com.siswbrasil.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
interface LancamentoService {

    fun buscarPorFuncionarioId(funciondarioId: String, pageable: PageRequest): Page<Lancamento>

    fun buscarPorId(id: String): Optional<Lancamento>

    fun persistir(lancamento: Lancamento): Lancamento

    fun remover(id: String)

}