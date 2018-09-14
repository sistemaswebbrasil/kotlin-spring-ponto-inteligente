package com.siswbrasil.pontointeligente.services.impl

import com.siswbrasil.pontointeligente.documents.Empresa
import com.siswbrasil.pontointeligente.repositories.EmpresaRepository
import com.siswbrasil.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}