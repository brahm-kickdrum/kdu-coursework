package org.example.service;

import org.example.Constants;
import org.example.entities.InventoryStore;
import org.example.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleFactoryService {
    private TyreService tyreService;
    private SpeakerService speakerService;
    private InventoryStore inventoryStore;
    private double locationBasedPriceAdjustment;

    @Autowired
    public VehicleFactoryService(TyreService tyreService,
                                 SpeakerService speakerService,
                                 InventoryStore inventoryStore) {
        this.tyreService = tyreService;
        this.speakerService = speakerService;
        this.inventoryStore = inventoryStore;
    }

    public void createAndStoreVehicle() {
        double tyrePrice = tyreService.getRandomTyre().getTyrePrice();
        double speakerPrice = speakerService.getRandomSpeaker().getSpeakerPrice();
        double vehiclePrice = Constants.VEHICLE_PRICE + speakerPrice + tyrePrice * Constants.NUMBER_OF_TYRES;

        vehiclePrice += vehiclePrice * locationBasedPriceAdjustment / 100.0;

        Vehicle vehicle = new Vehicle(speakerService.getRandomSpeaker(), tyreService.getRandomTyre(), vehiclePrice);

        inventoryStore.addToInventory(vehicle);
    }

    public TyreService getTyreService() {
        return tyreService;
    }

    public void setTyreService(TyreService tyreService) {
        this.tyreService = tyreService;
    }

    public SpeakerService getSpeakerService() {
        return speakerService;
    }

    public void setSpeakerService(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    public InventoryStore getInventoryStore() {
        return inventoryStore;
    }

    public void setInventoryStore(InventoryStore inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    public double getLocationBasedPriceAdjustment() {
        return locationBasedPriceAdjustment;
    }


    protected void setLocationBasedPriceAdjustment(double adjustment) {
        this.locationBasedPriceAdjustment = adjustment;
    }
}
