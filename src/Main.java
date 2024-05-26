import java.util.Scanner;
import java.io.IOException;
import controller.animeController;
import entities.Anime;
import view.animeListView;

public class Main {
    public static void main(String[] args) throws IOException {
        Anime animex = new Anime();
        animeController Controller = new animeController();
        animeListView View = new animeListView();
        Scanner leitor = new Scanner(System.in);

        while (true) {
            exibirOpcoes();
            int opcao = leitor.nextInt();
            leitor.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    Controller.registrarAnimes(animex);
                    Controller.escreverEmArquivo(animex, "listaAnimes.txt");
                    break;

                case 2:
                    View.exibirListaAnimes("listaAnimes.txt");
                    System.out.println("Informe o nome do anime que deseja deletar:");
                    String nomeAnime = leitor.nextLine();
                    Controller.deletarAnime("listaAnimes.txt", nomeAnime);
                    break;

                case 3:
                    View.exibirListaAnimes("listaAnimes.txt");
                    System.out.println("Informe o nome do anime que deseja alterar:");
                    String nomeParaAlterar = leitor.nextLine();
                    Controller.alterarAnime("listaAnimes.txt", nomeParaAlterar);
                    break;

                case 4:
                    View.exibirListaAnimes("listaAnimes.txt");
                    break;

                case 9:
                    System.out.println("Deseja deletar o arquivo por completo? Digite \"CONFIRMAR\" para seguir: ");
                    if (leitor.nextLine().equals("CONFIRMAR")) {
                        Controller.deletarArquivo("listaAnimes.txt");
                    } else {
                        System.out.println("Operação cancelada!\n");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    leitor.close();
                    Controller.fecharLeitor();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void exibirOpcoes() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Registrar novo anime");
        System.out.println("2. Deletar anime");
        System.out.println("3. Alterar anime");
        System.out.println("4. Exibir lista de animes");
        System.out.println("9. Deletar o arquivo");
        System.out.println("0. Sair");
    }
}
