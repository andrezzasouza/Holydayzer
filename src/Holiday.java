public class Holiday extends DateFormat {
  private String dateName;

  Holiday (String newDate, String dateName) {
    setNewDate(newDate);
    this.dateName = dateName;
  }

  public String getDateName() {
    return dateName;
  }  
}
