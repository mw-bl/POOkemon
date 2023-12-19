public abstract class EntidadeBatalha {
    // Encapsulamento - * atributos privados *
    private String nome;
    private int hp;

    // Construtor da classe * EntidadeBatalha *
    public EntidadeBatalha(String nome, int hp) {
        this.nome = nome;
        this.hp = hp;
    }

    public abstract void realizarAtaque(EntidadeBatalha oponente);

    public void receberDano(int dano) {
        hp -= dano;
        if (hp < 0) {
            hp = 0;
        }
    }

    // getters da classe * EntidadeBatalha *
    public int getHP() {
        return hp;
    }

    public String getNome() {
        return nome;
    }
}
