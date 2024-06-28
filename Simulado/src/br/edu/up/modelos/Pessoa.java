package br.edu.up.modelos;

public class Pessoa {
  private int codigo;
  private String nome;
  private Endereco endereco;

  public Pessoa(int codigo, String nome) {
      this.codigo = codigo;
      this.nome = nome;
  }

  public int getCodigo() {
      return codigo;
  }

  public void setCodigo(int codigo) {
      this.codigo = codigo;
  }

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public Endereco getEndereco() {
      return endereco;
  }

  public void setEndereco(Endereco endereco) {
      this.endereco = endereco;
  }

  @Override
  public String toString() {
      return "Pessoa{codigo=" + codigo + ", nome='" + nome + "', endereco=" + endereco + "}";
  }

}

