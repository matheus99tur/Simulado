package br.edu.up.crontroler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.up.modelos.Endereco;
import br.edu.up.modelos.Pessoa;

public class PessoaService {
  public List<Pessoa> lerPessoas(String filePath) {
    List<Pessoa> pessoas = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            int codigo = Integer.parseInt(dados[0].trim());
            String nome = dados[1].trim();
            pessoas.add(new Pessoa(codigo, nome));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return pessoas;
}

public Map<Integer, Endereco> lerEnderecos(String filePath) {
    Map<Integer, Endereco> enderecos = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            String rua = dados[0].trim();
            String cidade = dados[1].trim();
            int id = Integer.parseInt(dados[2].trim());
            Endereco endereco = new Endereco(rua, cidade);
            enderecos.put(id, endereco);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return enderecos;
}

public List<Pessoa> combinarDados(List<Pessoa> pessoas, Map<Integer, Endereco> enderecos) {
    List<Pessoa> pessoasComEndereco = new ArrayList<>();
    for (Pessoa pessoa : pessoas) {
        Endereco endereco = enderecos.get(pessoa.getCodigo());
        if (endereco != null) {
            pessoa.setEndereco(endereco);
            pessoasComEndereco.add(pessoa);
        }
    }
    return pessoasComEndereco;
}

public void escreverPessoaComEndereco(String filePath, List<Pessoa> pessoasComEndereco) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (Pessoa pessoa : pessoasComEndereco) {
            writer.write(pessoa.getCodigo() + "," + pessoa.getNome() + "," + pessoa.getEndereco().getRua() + "," + pessoa.getEndereco().getCidade());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
