public abstract class EntidadeBatalha {
    private String nome;
    private int hp;

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

    public int getHP() {
        return hp;
    }

    public String getNome() {
        return nome;
    }
}
