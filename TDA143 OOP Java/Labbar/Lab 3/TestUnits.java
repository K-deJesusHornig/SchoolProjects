public class TestUnits {

   // Uncomment one of the lines to run a test
   public static void main(String[] args){
      //testDistanceUnit();
      //testDistanceConverter();
   }

   /* Expected output:
   100.0
   100.0
   30.48
   328.0839895013123
   1.616229E-33
   6.187242030677584E36
   3.08567758E18
   3.240779291010696E-15
   */
   public static void testDistanceUnit(){
      System.out.println(DistanceUnit.METER.toMetric(100));
      System.out.println(DistanceUnit.METER.fromMetric(100));
      System.out.println(DistanceUnit.FOOT.toMetric(100));
      System.out.println(DistanceUnit.FOOT.fromMetric(100));
      System.out.println(DistanceUnit.PLANCK.toMetric(100));
      System.out.println(DistanceUnit.PLANCK.fromMetric(100));;
      System.out.println(DistanceUnit.PARSEC.toMetric(100));
      System.out.println(DistanceUnit.PARSEC.fromMetric(100));
   }
   
   // Expected output (small rounding errors are possible):
   //   30.48
   //   328.0839895013123
   //   The Millenium Falcon did the Kessel Run in less than 1214833692913385730.000000 feet
   //   TODO: Fill in expected output for light-year conversion
   public static void testDistanceConverter(){
      /* TODO: Remove this multiline comment after you have created the DistanceConverter class
      // Converter feet->meters
      DistanceConverter f2m = new DistanceConverter(DistanceUnit.FOOT);
      
      // Converter meters->feet (same as new DistanceConverter(DistanceUnit.METER, DistanceUnit.FOOT)
      DistanceConverter m2f = f2m.reverseDirection();

      // Convert 100 feet to meters and prints the result (30.48)
      System.out.println(f2m.convert(100));

      // Convert 100 feet to meters and prints the result (328.0839895013123)
      System.out.println(m2f.convert(100));  
      
      // Convert from parsec to foot
      DistanceConverter parsec2foot = new DistanceConverter(DistanceUnit.PARSEC, DistanceUnit.FOOT);
      
      System.out.printf("The Millenium Falcon did the Kessel Run in less than %f feet", parsec2foot.convert(12));
      
      
      */
      
      // TODO: Make a DistanceUnit for Lightyears (look up the conversion factor)
      // DistanceUnit lightYear = ...
      
      // TODO: Make a converter from lightyears to parsec and test it with a value, don't forget to calculate the expected output of tne test
   }
}

