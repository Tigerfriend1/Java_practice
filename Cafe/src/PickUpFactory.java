public class PickUpFactory {

    class Delivery implements Order.PickUp {

        private String address;

        // your code here

    }

    class DriveThru implements Order.PickUp {

        private String vehicleNumber;

        // your code here

    }

    class TakeOut implements Order.PickUp {

        // your code here

    }

    public Order.PickUp makeTakeOut (){

        return new TakeOut();

    }

    public Order.PickUp makeDriveThru (String vehicleNumber){

        return new DriveThru(vehicleNumber);

    }

    public Order.PickUp makeDelivery (String address){

        return new Delivery(address);

    }


}