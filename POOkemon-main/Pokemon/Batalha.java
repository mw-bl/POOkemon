import java.util.Scanner;

public class Batalha {

    private Scanner leitura = new Scanner(System.in);

    public void batalhaComum(Treinador jogador1, Treinador jogador2) {
        System.out.println("\n --------- Batalha iniciada entre " + jogador1.getNome() + " e " + jogador2.getNome() + "!---------");

        while (true) {
            realizarTurno(jogador1, jogador2);
            if (jogador2.pokemonsVivos() == 0) {
                System.out.println(jogador2.getNome() + " não tem mais Pokémon!");
                System.out.println(jogador1.getNome() + " venceu a batalha!");
                break;
            }

            realizarTurno(jogador2, jogador1);
            if (jogador1.pokemonsVivos() == 0) {
                System.out.println(jogador1.getNome() + " não tem mais Pokémon!");
                System.out.println(jogador2.getNome() + " venceu a batalha!");
                break;
            }
        }
    }

    private void realizarTurno(Treinador atacante, Treinador oponente) {
        Pokemon pokemonAtacante = atacante.getPokemonAtivo();
        Pokemon pokemonOponente = oponente.getPokemonAtivo();

        System.out.println("\n" + atacante.getNome() + " é a sua vez!");
        System.out.println("\nPokemon de " + atacante.getNome() + ": " + pokemonAtacante.getNome() + " - HP: " + pokemonAtacante.getHP());
        System.out.println("Pokemon de " + oponente.getNome() + ": " + pokemonOponente.getNome() + " - HP: " + pokemonOponente.getHP());

        realizarAtaque(atacante, oponente);
    }

    private void realizarAtaque(Treinador atacante, Treinador oponente) {
        Pokemon pokemonAtacante = atacante.getPokemonAtivo();
        Pokemon pokemonOponente = oponente.getPokemonAtivo();

        System.out.println("\nEscolha um ataque para " + pokemonAtacante.getNome() + ":");
        mostrarAtaquesDisponiveis(pokemonAtacante);

        int escolhaAtaque = leitura.nextInt();
        leitura.nextLine(); // Limpar o buffer

        if (escolhaAtaque >= 1 && escolhaAtaque <= 4) {
            Ataque ataqueSelecionado = pokemonAtacante.getListaAtaques()[escolhaAtaque - 1];
            int dano = ataqueSelecionado.getDano();

            pokemonOponente.receberDano(dano);

            System.out.println(pokemonAtacante.getNome() + " usou " + ataqueSelecionado.getNome() + "!");
            System.out.println("Dano causado: " + dano);

            if (pokemonOponente.getHP() <= 0) {
                System.out.println(pokemonOponente.getNome() + " foi derrotado!");
            }
        } else {
            System.out.println("Escolha de ataque inválida!");
        }
    }

    private void mostrarAtaquesDisponiveis(Pokemon pokemon) {
        System.out.println("Ataques disponíveis para " + pokemon.getNome() + ":");
        Ataque[] ataques = pokemon.getListaAtaques();
        for (int i = 0; i < ataques.length; i++) {
            System.out.println((i + 1) + " - " + ataques[i].getNome());
        }
    }
}
