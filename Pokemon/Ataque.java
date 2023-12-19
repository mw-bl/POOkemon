public class Ataque {
    private String nome;
    private int dano;

    public Ataque(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    public String getNome() {
        return nome;
    }
}
