public class Temperature {
  public static void main(String[] args) {
    int[][] temperatureTable = {
      {35, 35, 45, 49, 53, 53, 55},
      {50, 52, 68, 75, 78, 76, 75}};

      //Output low temperature for Sunday
      System.out.println(temperatureTable[0][0]);

      //Output high temperature for Thursday
      System.out.println(temperatureTable[1][4]);

      //Output low temperature for Tuesday
      System.out.println(temperatureTable[0][2]);

      //Calculate the average low temperature
      int sum = 0;
      for(int i=0; i<temperatureTable[0].length; i++)
      sum += temperatureTable[0][i];
      int avgLow = sum / temperatureTable[0].length;
      System.out.println("Average low temp: " + avgLow);

      //Calculate the average temperature overall
      int aSum = 0;
      for (int i=0; i<=6; i++)
      aSum += temperatureTable[0][i]
      + temperatureTable[1][i];
      int average = aSum/(temperatureTable.length * temperatureTable[0].length);
      System.out.println("Average temp: " + average);

      //Determine the temperature range
      int min = temperatureTable[0][0];
      int max = temperatureTable[0][0];
      for (int i = 0; i < temperatureTable.length; i++)
      for (int j = 0; j < temperatureTable[i].length; j++) {
        if (temperatureTable[i][j] < min)
        min = temperatureTable[i][j];
        if (temperatureTable[i][j] > max)
        max = temperatureTable[i][j];
      }
      System.out.println("Temp range: " + min + " - " + max);
    }
  }
