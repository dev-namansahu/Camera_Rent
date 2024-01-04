package camera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Camera {
    private String brand;
    private String model;
    private double rentalAmount;

    public Camera(String brand, String model, double rentalAmount) {
        this.brand = brand;
        this.model = model;
        this.rentalAmount = rentalAmount;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }
}
class Wallet {
    private double balance;

    public Wallet() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public boolean deduct(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount deducted. New balance: " + balance);
            return true;
        } else {
            System.out.println("Transaction Failed due to insufficient wallet amount.");
            return false;
        }
    }
}
class CameraRentalApp {
    private List<Camera> cameraList;
    private Wallet userWallet;

    public CameraRentalApp() {
        this.cameraList = new ArrayList<>();
        this.userWallet = new Wallet();
    }
    public void myCAMERA() {
        String[] arr2 = {"\n1.ADD",
         
                "2.VIEW MY CAMERAS"
        };
        
        int[] arr3 = {1,2};
        int  slen = arr3.length;
        for(int a=0; a<slen;a++){
            System.out.println(arr2[a]);}
            // display the all the Strings mentioned in the String array
        }

    public void addCamera(String brand, String model, double rentalAmount) {
        Camera newCamera = new Camera(brand, model, rentalAmount);
        cameraList.add(newCamera);
        System.out.println("New camera added successfully.");
    }

    public void listCameras() {
        if (cameraList.isEmpty()) {
            System.out.println("No Data Present at This Moment.");
        } else {
            for (Camera camera : cameraList) {
                System.out.println("Brand: " + camera.getBrand() +
                                   ", Model: " + camera.getModel() +
                                   ", Rental Amount: $" + camera.getRentalAmount());
            }
        }
    }
    
    public void listmyCameras() {
        if (cameraList.isEmpty()) {
            System.out.println("No Data Present at This Moment.");
        } else {
            for (Camera camera : cameraList) {
                System.out.println("Brand: " + camera.getBrand() +
                                   ", Model: " + camera.getModel() +
                                   ", Rental Amount: $" + camera.getRentalAmount());
            }
        }
    }
public void rentCamera(int cameraIndex) {
    if (cameraIndex >= 0 && cameraIndex < cameraList.size()) {
        Camera selectedCamera = cameraList.get(cameraIndex);
        if (userWallet.deduct(selectedCamera.getRentalAmount())) {
            System.out.println("Camera rented successfully: " + selectedCamera.getBrand() +
                               " " + selectedCamera.getModel());
        }
    } else {
        System.out.println("Invalid camera selection.");
    }
}

public void viewWalletBalance() {
    System.out.println("Current wallet balance: $" + userWallet.getBalance());
}

public void depositToWallet(double amount) {
    userWallet.deposit(amount);
}
}

public class CameraRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CameraRentalApp rentalApp = new CameraRentalApp();

        System.out.println("\n*********************************************\n");
        System.out.println("\tWELCOME TO CAMERA RENTAL APP \n");
        System.out.println("*********************************************");
        System.out.println("\nPLEASE LOGIN TO CONTINUE- \n");
       
      	  	String username,password;
      	  	Scanner s = new Scanner(System.in);
      	  	System.out.print("Enter username: ");
      	  	username=s.nextLine();
      	  	System.out.print("Enter password: ");
      	  	password=s.nextLine();
      	  	String validUsername="user123";
      	  	String validPassword="password";
      	  	username="user123";
      	  	password="password";
      	  	if(username.equals(validUsername) && password.equals(validPassword))
      	  	{
      	  		System.out.print("Authentication Successfull\n ");	
      	  	}
      	  	else
      	  	{
      	  		System.out.print("Authentication Unsuccessfull\n");
      	  	}
    	
   
        int choice;
        do {
            System.out.println("\nOptions:");
            System.out.println("1. List Cameras");
            System.out.println("2. Rent a Camera");
            System.out.println("3. My Camera");
            System.out.println("4. View Wallet Balance");
            System.out.println("5. Deposit to Wallet");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
            case 1:
                rentalApp.listCameras();
                break;
            case 2:
                System.out.print("Enter the index of the camera to rent: ");
                int cameraIndex = scanner.nextInt();
                rentalApp.rentCamera(cameraIndex);
                break;
            case 3:
            	rentalApp.myCAMERA();
            	System.out.print("Enter your choice from MY CAMERA: ");
            	Scanner sc=new Scanner(System.in);
            	int obj=sc.nextInt();
            	switch(obj) {
            	case 1:
            		System.out.print("Enter brand: ");
                    String brand = scanner.next();
                    System.out.print("Enter model: ");
                    String model = scanner.next();
                    System.out.print("Enter rental amount: ");
                    double rentalAmount = scanner.nextDouble();
                    rentalApp.addCamera(brand, model, rentalAmount);
                    break;
            	case 2:
            		rentalApp.listmyCameras();
            		break;
            		
            	}
            	
                
            case 4:
                rentalApp.viewWalletBalance();
                break;
            case 5:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                rentalApp.depositToWallet(depositAmount);
                break;
            case 6:
                System.out.println("Exiting RentMyCam. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }while (choice != 6);

        scanner.close();

        }}