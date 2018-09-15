package com.siswbrasil.pontointeligente

import com.siswbrasil.pontointeligente.documents.Empresa
import com.siswbrasil.pontointeligente.documents.Funcionario
import com.siswbrasil.pontointeligente.enums.PerfilEnum
import com.siswbrasil.pontointeligente.repositories.EmpresaRepository
import com.siswbrasil.pontointeligente.repositories.FuncionarioRepository
import com.siswbrasil.pontointeligente.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PontoInteligenteApplication(
        val empresaRepository: EmpresaRepository,
        val funcionarioRepository: FuncionarioRepository) :
        CommandLineRunner {

    override fun run(vararg args: String?) {
        empresaRepository.deleteAll()
        funcionarioRepository.deleteAll()

        val empresa: Empresa = Empresa("Empresa", "10443887000146")
        empresaRepository.save(empresa)

        val admin: Funcionario = Funcionario("Admin", "admin@empresa.com",
                SenhaUtils().gerarBcrypt("123456"), "25708317000",
                PerfilEnum.ROLE_ADMIN, empresa.id!!)

        funcionarioRepository.save(admin)

        val funcionario: Funcionario = Funcionario("Funcionario",
                "funcionario@empresa.com", SenhaUtils().gerarBcrypt("123456"),
                "44325441557", PerfilEnum.ROLE_USUARIO, empresa.id!!)

        funcionarioRepository.save(funcionario)

        println("Empresa ID: " + empresa.id)
        println("Admin ID: " + admin.id)
        println("Funcionario ID: " + funcionario.id)
    }
}

fun main(args: Array<String>) {
    runApplication<PontoInteligenteApplication>(*args)
}
