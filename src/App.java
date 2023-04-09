import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    try (Scanner choiceInput = new Scanner(System.in)) {
      System.out.println("\n----------------------\n\nVocê deseja consultar:\n\n1 -> Uma data de 2023\n2 -> Todos os feriados de 2023\n\nEscolha o número 1 ou 2!");
      String choiceValue = choiceInput.nextLine();

      if (!choiceValue.equals("1") && !choiceValue.equals("2")) {
        System.out.println("\nEscolha inválida!");
        return;
      }


      if (choiceValue.equals("1")) {
        try (Scanner dateInput = new Scanner(System.in)) {
          System.out.println("\nInsira a data que deseja consultar no formato DD/MM/YYYY:");
          String chosenDate = dateInput.nextLine();
          Date specificDate = new Date(chosenDate);

          try {
            if (specificDate.checkIfValidDate()) {
              System.out.println(specificDate.checkIfHoliday());
              return;
            }
            System.out.println("\nData inválida!");
            return;
          } catch (Exception e) {
            System.out.println("\nData inválida!");
          }
          
        }
      }

      if (choiceValue.equals("2")) {
        Date allDates = new Date();
        allDates.showHolidays();
      }
    }
  }
}
