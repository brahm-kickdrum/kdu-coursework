package org.example;

import org.example.config.Config;
import org.example.entities.InventoryStore;
import org.example.entities.Vehicle;
import org.example.service.TyreService;
import org.example.service.SpeakerService;
import org.example.service.VehicleFactoryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        VehicleFactoryService factory1Service = context.getBean("factory1Service", VehicleFactoryService.class);
        factory1Service.createAndStoreVehicle();

        TyreService tyreService = context.getBean("factoryTyreService", TyreService.class);
        SpeakerService speakerService = context.getBean("factorySpeakerService", SpeakerService.class);
        InventoryStore factory1Inventory = context.getBean("factory1Inventory", InventoryStore.class);

        VehicleFactoryService factory2Service = context.getBean("factory2Service", VehicleFactoryService.class);
        factory2Service.setTyreService(tyreService);
        factory2Service.setSpeakerService(speakerService);
        factory2Service.setInventoryStore(factory1Inventory);
        factory2Service.createAndStoreVehicle();

        InventoryStore factory2Inventory = context.getBean("factory2Inventory", InventoryStore.class);

        Vehicle highestPriceVehicleFactory1 = factory1Inventory.findHighestPricedVehicle();
        Vehicle lowestPriceVehicleFactory1 = factory1Inventory.findLowestPricedVehicle();

        System.out.println("Factory 1 - Highest Priced Vehicle: " + highestPriceVehicleFactory1.getPrice());
        System.out.println("Factory 1 - Lowest Priced Vehicle: " + lowestPriceVehicleFactory1.getPrice());

        Vehicle highestPriceVehicleFactory2 = factory2Inventory.findHighestPricedVehicle();
        Vehicle lowestPriceVehicleFactory2 = factory2Inventory.findLowestPricedVehicle();

        System.out.println("Factory 2 - Highest Priced Vehicle: " + highestPriceVehicleFactory2.getPrice());
        System.out.println("Factory 2 - Lowest Priced Vehicle: " + lowestPriceVehicleFactory2.getPrice());

        context.close();
    }
}
