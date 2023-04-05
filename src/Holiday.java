public class Holiday {
  private String date;
  private String dateName;

  Holiday (String date, String dateName) {
    this.date = date;
    this.dateName = dateName;
  }

  public String getDate() {
    return date;
  }

  public String getDateName() {
    return dateName;
  }  
}
