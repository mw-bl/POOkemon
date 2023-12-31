import java.util.Random;

// Herança - * Pokemon * herda atributos de * EntidadeBatalha *
public class Pokemon extends EntidadeBatalha {
    // Encapsulamento - * atributos privados *
    private String tipo;
    private Ataque[] listaAtaques;

    // Construtor da classe * Pokemon *
    public Pokemon(String nome, String tipo, int hp, Ataque[] listaAtaques) {
        super(nome, hp);
        this.tipo = tipo;
        this.listaAtaques = listaAtaques;
    }

    // Polimorfismo
    @Override
    public void realizarAtaque(EntidadeBatalha oponente) {
        if (oponente instanceof Pokemon) {
            Pokemon oponentePokemon = (Pokemon) oponente;

            Random random = new Random();
            int indiceAtaque = random.nextInt(listaAtaques.length);
            Ataque ataqueSelecionado = listaAtaques[indiceAtaque];

            int dano = ataqueSelecionado.getDano();

            oponentePokemon.receberDano(dano);

            System.out.println(getNome() + " usou " + ataqueSelecionado.getNome() + "!");
            System.out.println("Dano causado: " + dano);
        } else {
            System.out.println("Erro: Oponente não é um Pokémon.");
        }
    }

    public Ataque[] getListaAtaques() {
        return listaAtaques;
    }
}
