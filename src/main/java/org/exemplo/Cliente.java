package org.exemplo;
class Cliente {
    private int id;
    private String nome;
    private int idade;
    public Cliente(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }
    
    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome='" + nome + '\'' + ", idade=" + idade + '}';
    }
}
