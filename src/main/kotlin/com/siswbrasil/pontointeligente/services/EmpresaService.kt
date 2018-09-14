package com.siswbrasil.pontointeligente.services

import com.siswbrasil.pontointeligente.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa
}