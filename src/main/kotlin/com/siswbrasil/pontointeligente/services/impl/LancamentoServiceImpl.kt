package com.siswbrasil.pontointeligente.services.impl

import com.siswbrasil.pontointeligente.documents.Lancamento
import com.siswbrasil.pontointeligente.repositories.LancamentoRepository
import com.siswbrasil.pontointeligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {
    override fun buscarPorFuncionarioId(funciondarioId: String, pageable: PageRequest): Page<Lancamento> =
            lancamentoRepository.findByFuncionarioId(funciondarioId, pageable)

    override fun buscarPorId(id: String): Optional<Lancamento> = lancamentoRepository.findById(id)

    override fun persistir(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)

    override fun remover(id: String) = lancamentoRepository.deleteById(id)
}