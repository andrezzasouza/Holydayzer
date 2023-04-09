public class Holiday extends DateFormat {
  private String newDate;
  private String dateName;

  Holiday (String newDate, String dateName) {
    this.newDate = newDate;
    this.dateName = dateName;
  }

  public String getDate() {
    return newDate;
  }

  public String getDateName() {
    return dateName;
  }  
}
