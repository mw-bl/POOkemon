import java.util.Scanner;

public class InterfacePokemon {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nSeja bem-vindo ao mundo dos Pokémon!\nPrepare-se para desafiar outros treinadores e fortalecer os laços com seus Pokémon!\n");

        System.out.println("\nParabéns!! Agora voce é um treinador pokemon!!\n");


        // Criação dos Pokémons com seus ataques

        Ataque[] ataquesCharmander = {
            new Ataque("Scratch", 40),
            new Ataque("Ember", 40),
            new Ataque("Flame Burst", 70),
            new Ataque("Inferno", 100)
        };
        Pokemon charmander = new Pokemon("Charmander", "Fogo", 300, ataquesCharmander);

        Ataque[] ataquesPikachu = {
            new Ataque("Close Combat", 120),
            new Ataque("Revenge", 60),
            new Ataque("Rolling Kick", 60),
            new Ataque("Quick Attack", 40)
        };
        Pokemon pikachu = new Pokemon("Pikachu", "Elétrico", 310, ataquesPikachu);

        // Criação dos treinadores
        Treinador jogador1 = criarTreinador(leitura, "Jogador 1", pikachu);
        Treinador jogador2 = criarTreinador(leitura, "Jogador 2", charmander);

        // Iniciar a batalha entre os jogadores
        Batalha batalha = new Batalha();
        batalha.batalhaComum(jogador1, jogador2);
    }

    private static Treinador criarTreinador(Scanner leitura, String nome, Pokemon pokemonInicial) {
        System.out.println(nome + ", digite seu nome de treinador:");
        String nomeTreinador = leitura.nextLine();

        Pokemon[] equipe = {pokemonInicial};
        return new Treinador(nomeTreinador, equipe);
    }
}
