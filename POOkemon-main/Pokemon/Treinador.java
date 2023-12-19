// Herança - * Treinador * recebe atributos de  * EntidadeBatalha *
public class Treinador extends EntidadeBatalha {
    // Encapsulamento - * atributos privados *
    private Pokemon[] equipe;
    private int pokemonAtivo;

    // Construtor da classe * Treinador *
    public Treinador(String nome, Pokemon[] equipe) {
        super(nome, equipe[0].getHP());
        this.equipe = equipe;
        this.pokemonAtivo = 0;
    }

    // Polimorfismo
    @Override
    public void realizarAtaque(EntidadeBatalha oponente) {
        System.out.println(getNome() + " está atacando!");

        Pokemon pokemonAtivo = getPokemonAtivo();
        pokemonAtivo.realizarAtaque(oponente);

        System.out.println(pokemonAtivo.getNome() + " atacou " + oponente.getNome() +
                " causando " + (pokemonAtivo.getHP() - oponente.getHP()) + " de dano.");

        if (oponente.getHP() <= 0) {
            System.out.println(oponente.getNome() + " foi derrotado!");
        }
    }

    public void atacarOponente(EntidadeBatalha oponente) {
        realizarAtaque(oponente);
    }

    public int pokemonsVivos() {
        int count = 0;
        for (Pokemon pokemon : equipe) {
            if (pokemon.getHP() > 0) {
                count++;
            }
        }
        return count;
    }

    public Pokemon getPokemonAtivo() {
        return equipe[pokemonAtivo];
    }
}
