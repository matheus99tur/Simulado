package br.edu.up.telas;

import java.util.List;
import java.util.Map;

import br.edu.up.crontroler.PessoaService;
import br.edu.up.modelos.Endereco;
import br.edu.up.modelos.Pessoa;

public class Main {
  public static void main(String[] args) {
    PessoaService pessoaService = new PessoaService();

    // Caminhos para os arquivos CSV
    String pessoaFilePath = "Simulado/src/br/edu/up/dao/Pessoa.csv";
    String enderecoFilePath = "Simulado/src/br/edu/up/dao/Endereco.csv";
    String pessoaComEnderecoFilePath = "Simulado/src/br/edu/up/dao/PessoaComEndereco.csv";

    // Ler dados dos arquivos
    List<Pessoa> pessoas = pessoaService.lerPessoas(pessoaFilePath);
    Map<Integer, Endereco> enderecos = pessoaService.lerEnderecos(enderecoFilePath);

    // Combinar dados
    List<Pessoa> pessoasComEndereco = pessoaService.combinarDados(pessoas, enderecos);

    // Escrever dados combinados no novo arquivo
    pessoaService.escreverPessoaComEndereco(pessoaComEnderecoFilePath, pessoasComEndereco);

    // Imprimir dados combinados (opcional)
    for (Pessoa pessoa : pessoasComEndereco) {
      System.out.println(pessoa);
    }
  }
}
