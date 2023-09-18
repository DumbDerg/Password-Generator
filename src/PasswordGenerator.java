import java.util.Random;

public class PasswordGenerator {


 private final String numbers = "1234567890";
 private final String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
 private final String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 private final String symbols = "!@#$%^&*()";
 private final Random random = new Random();



  public String generatePassword(int length, boolean numbers, boolean lowercaseLetters, boolean uppercaseLetters, boolean symbols){
   StringBuilder password = new StringBuilder();
   if (!numbers && !lowercaseLetters && !uppercaseLetters && !symbols){
     return password.toString();
   }else {
    StringBuilder builder = new StringBuilder();
    if (numbers){
     builder.append(this.numbers);
    }
    if (lowercaseLetters){
     builder.append(this.lowercaseLetters);
    }
    if (uppercaseLetters){
     builder.append(this.uppercaseLetters);
    }
    if (symbols){
     builder.append(this.symbols);
    }
    for (int i = 0; i < length; i++){
     password.append(builder.charAt(random.nextInt(builder.length())));
    }

   return password.toString();
   }

  }








}