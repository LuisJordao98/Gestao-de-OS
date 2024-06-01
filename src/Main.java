import model.OrdemDeServico;
import model.OrdemDeServicoDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar uma nova OS");
            System.out.println("2. Ler todas as OSs");
            System.out.println("3. Atualizar uma OS");
            System.out.println("4. Deletar uma OS");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcao) {
                case 1:
                    
                    OrdemDeServico os1 = new OrdemDeServico();
                    System.out.print("Nome do cliente: ");
                    os1.setCliente(scanner.nextLine());
                    System.out.print("Telefone: ");
                    os1.setTelefone(scanner.nextLine());
                    System.out.print("Modelo: ");
                    os1.setModelo(scanner.nextLine());
                    System.out.print("Problema: ");
                    os1.setProblema(scanner.nextLine());
                    os1.setDataRecebimento(new Date());
                    os1.setDataEntrega(new Date());
                    System.out.print("Valor: ");
                    os1.setValor(scanner.nextDouble());
                    scanner.nextLine();  

                    try {
                        dao.create(os1);
                        System.out.println("OS criada com sucesso!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    
                    try {
                        List<OrdemDeServico> oss = dao.read();
                        for (OrdemDeServico os : oss) {
                            System.out.println(os);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    
                    try {
                        System.out.print("ID da OS para atualizar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha
                        OrdemDeServico osToUpdate = dao.read().stream().filter(os -> os.getId() == id).findFirst().orElse(null);
                        if (osToUpdate != null) {
                            System.out.print("Novo problema: ");
                            osToUpdate.setProblema(scanner.nextLine());
                            dao.update(osToUpdate);
                            System.out.println("OS atualizada com sucesso!");
                        } else {
                            System.out.println("OS não encontrada!");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    // Deletar uma OS
                    try {
                        System.out.print("ID da OS para deletar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha
                        dao.delete(id);
                        System.out.println("OS deletada com sucesso!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
