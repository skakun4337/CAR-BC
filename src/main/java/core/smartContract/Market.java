package core.smartContract;

import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.UUID;


public class Market implements java.io.Serializable{

    private final UUID contractAddress;
    private final PublicKey contractOwner;
    private final PublicKey contractPublicKey;

    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

    private Market(byte[] owner) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Contract contract = new Contract(owner);
        this.contractAddress = contract.getContractAddress();
        this.contractOwner = contract.getContractOwner();
        this.contractPublicKey = contract.getContractPublicKey();


    }

    private class Vehicle{
        private PublicKey currentVehicleOwner;
        private String addressOfCurrentOwner;
        private String vehicleID;
        private String engineNumber;
        private String vehicleClass;
        private String condition;
        private String make;
        private String model;
        private String yearOfManufacture;
        private String dateOfRegistration;
        private String engineCapacity;
        private String fuelType;
        private String statusWhenRegistered;
        private String crType;
        private String typeOfBody;

        public Vehicle(PublicKey currentVehicleOwner, String addressOfCurrentOwner,
                       String vehicleID, String engineNumber, String vehicleClass,
                       String condition, String make, String model, String yearOfManufacture,
                       String dateOfRegistration, String engineCapacity, String fuelType,
                       String statusWhenRegistered, String crType, String typeOfBody,
                       byte[] validatorArray) {

            this.currentVehicleOwner = currentVehicleOwner;
            this.addressOfCurrentOwner = addressOfCurrentOwner;
            this.vehicleID = vehicleID;
            this.engineNumber = engineNumber;
            this.vehicleClass = vehicleClass;
            this.condition = condition;
            this.make = make;
            this.model = model;
            this.yearOfManufacture = yearOfManufacture;
            this.dateOfRegistration = dateOfRegistration;
            this.engineCapacity = engineCapacity;
            this.fuelType = fuelType;
            this.statusWhenRegistered = statusWhenRegistered;
            this.crType = crType;
            this.typeOfBody = typeOfBody;

            JSONObject validators = new JSONObject(new String(validatorArray));
//            JSONParser parser = new JSONParser();

        }

        public void changeOwnership(){
            //code goes here
        }


    }
}
