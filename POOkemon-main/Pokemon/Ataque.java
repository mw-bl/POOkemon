public class Ataque {
    // Encapsulamento - * atributos privados *
    private String nome;
    private int dano;

    // Construtor da classe * Ataque *
    public Ataque(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    // getters da classe * ataque *
    public int getDano() {
        return dano;
    }
    public String getNome() {
        return nome;
    }
}
