package Incryption;

import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class IncryptNumber {
	public static String sharedSecret = "XGh+RKd+aY/UwpbYQwqYh1zFkkvUdaFcVN3TDzWuUtA=";
	public static String initVector = "5qrM7di1XuSDSqsNCBx2LQ==";

	public static String encrypt(String plainText, String sharedSecret, String initVector) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(initVector));
		SecretKeySpec skeySpec = new SecretKeySpec(Base64.getDecoder().decode(sharedSecret), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

		byte[] encrypted = cipher.doFinal(plainText.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}

	public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);

			System.out.print("Enter mobile number: ");
			String mobileNumber = scanner.nextLine();
			try {
			String encryptedText = encrypt(mobileNumber, sharedSecret, initVector);
			System.out.println("Encrypted Text: " + encryptedText);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			  scanner.close();
	}

}
