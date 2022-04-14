public class PrintShop {
  public static void main(String[] args) {
    // Make 10 prints and put them in an array
    MonaLisaPrint[] prints = new MonaLisaPrint[10];
    for (int i=0; i<10; i++) {
      prints[i] = new MonaLisaPrint("round 1, i="+i);
    }

    MonaLisaPrint myPrint = prints[2];

    System.out.println(myPrint.getPrintNumber());
    System.out.println(myPrint.getLabel());
    
    for (int i=0; i<10; i++) {
      prints[i] = new MonaLisaPrint("round 2, i="+i);
    }

    System.out.println(myPrint.getPrintNumber());
    System.out.println(myPrint.getLabel());
    System.out.println(prints[2].getPrintNumber());
    System.out.println(prints[2].getLabel());
  }

}
