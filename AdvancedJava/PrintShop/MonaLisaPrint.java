public class MonaLisaPrint {
  /* static variable shared across all instances */
  private static int copiesMade = 0;

  /* final ivars associated with a particular copy */
  private final int COPY_NUM;
  private final String label;

  /* a constructor that sets up class and ivars */
  public MonaLisaPrint(String label) {
    copiesMade++;
    COPY_NUM = copiesMade;
    this.label = label;
  }

  public String getPrintNumber() {
    return COPY_NUM+"/"+copiesMade;
  }

  public String getLabel() {
    return label;
  }

}
