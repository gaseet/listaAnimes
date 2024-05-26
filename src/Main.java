import java.util.Scanner;
import java.io.IOException;
import controller.animeController;
import controller.userController;
import entities.Anime;
import view.animeListView;

public class Main {
  public static void main(String[] args) throws IOException {
      Anime animex = new Anime();
      animeController animeController = new animeController();
      animeListView View = new animeListView();
      userController userController = new userController();
      Scanner leitor = new Scanner(System.in);
      String arquivo = userController.wellCome(); // Nome do arquivo específico do usuário

      while (true) {
          exibirOpcoes();
          int opcao = leitor.nextInt();
          leitor.nextLine(); // Consumir a nova linha

          switch (opcao) {
              case 1:
                  animeController.registrarAnimes(animex);
                  animeController.escreverEmArquivo(animex, arquivo); // Usar o arquivo específico do usuário
                  break;

              case 2:
                  View.exibirListaAnimes(arquivo); // Usar o arquivo específico do usuário
                  System.out.println("Informe o nome do anime que deseja deletar:");
                  String nomeAnime = leitor.nextLine();
                  animeController.deletarAnime(arquivo, nomeAnime); // Usar o arquivo específico do usuário
                  break;

              case 3:
                  View.exibirListaAnimes(arquivo); // Usar o arquivo específico do usuário
                  System.out.println("Informe o nome do anime que deseja alterar:");
                  String nomeParaAlterar = leitor.nextLine();
                  animeController.alterarAnime(arquivo, nomeParaAlterar); // Usar o arquivo específico do usuário
                  break;

              case 4:
                  View.exibirListaAnimes(arquivo); // Usar o arquivo específico do usuário
                  break;

              case 9:
                  System.out.println("Deseja deletar o arquivo por completo? Digite \"CONFIRMAR\" para seguir: ");
                  if (leitor.nextLine().equals("CONFIRMAR")) {
                      animeController.deletarArquivo(arquivo); // Usar o arquivo específico do usuário
                  } else {
                      System.out.println("Operação cancelada!\n");
                  }
                  break;

              case 0:
                  System.out.println("Saindo...");
                  leitor.close();
                  animeController.fecharLeitor();
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
