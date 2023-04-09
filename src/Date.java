import java.util.ArrayList;
import java.util.List;

public class Date extends DateFormat {
  private List<Holiday> holiday = new ArrayList<Holiday>();

  public List<Holiday> getHoliday() {
    return holiday;
  }

  Date () {

  }

  Date (String newDate) {
    setNewDate(newDate);
  }

  private void createHolidays() {
    String[] holidayInfo = new String[]{"01/01/2023", "Confraternização mundial", "21/02/2023", "Carnaval", "17/04/2023", "Páscoa", "21/04/2023", "Tiradentes", "01/05/2023", "Dia do trabalho", "08/06/2023",  "Corpus Christi", "07/09/2023", "Independência do Brasil", "12/10/2023", "Nossa Senhora Aparecida", "02/11/2023", "Finados", "15/11/2023", "Proclamação da República", "25/12/2023", "Natal"};

    for (int i = 0; i < holidayInfo.length; i+=2) {
      Holiday newHoliday = new Holiday(holidayInfo[i], holidayInfo[i+1]);
      holiday.add(newHoliday);
    }
  }

  void showHolidays() {
    createHolidays();

    for (int i = 0; i < holiday.size(); i++) {
      if (i == 0) {
        System.out.println("\n");
      }

      System.out.println(holiday.get(i).getNewDate() + " => " + holiday.get(i).getDateName());
    }
  }

  boolean checkIfValidDate() {
    String date = getNewDate();

    boolean charCount = date.length() == 10;
    boolean separator = date.indexOf("/") == 2 && date.lastIndexOf("/") == 5;
    boolean dateRegex = date.matches("\\d{2}/\\d{2}/\\d{4}");

    String[] splitDate = date.split("/");
    boolean dayRules = Integer.parseInt(splitDate[0]) >= 1 && Integer.parseInt(splitDate[0]) <= 31;
    boolean monthRules = Integer.parseInt(splitDate[1]) >= 1 && Integer.parseInt(splitDate[1]) <= 12;
    boolean yearRules = Integer.parseInt(splitDate[2]) == 2023;
    boolean thirtyException = Integer.parseInt(splitDate[1]) == 4 || Integer.parseInt(splitDate[1]) == 6 || Integer.parseInt(splitDate[1]) == 9 || Integer.parseInt(splitDate[1]) == 11;

    if (charCount && separator && dateRegex && dayRules && monthRules && yearRules) {
      if (Integer.parseInt(splitDate[1]) == 2 && Integer.parseInt(splitDate[0]) > 29) {
        return false;
      }
      if (thirtyException && Integer.parseInt(splitDate[0]) > 30) {
        return false;
      }
      return true;
    }
    
    return false;
  }

  String checkIfHoliday() {
    createHolidays();
    for (int i = 0; i < holiday.size(); i++) {
      if ((holiday.get(i).getNewDate()).equals(getNewDate())) {
        return "\nO feriado de " + holiday.get(i).getDateName() + " acontece no dia " + getNewDate();
      } 
    }
    return "\nNão tem nenhum feriado no dia " + getNewDate();
  }
}
