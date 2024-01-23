    package org.example.service;

    import org.example.entities.InventoryStore;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    public class FactoryConfig {

        @Bean("factory1Service")
        public VehicleFactoryService factory1Service(
                @Qualifier("mrf") TyreService tyreService,
                @Qualifier("sony") SpeakerService speakerService,
                @Qualifier("factoryInventory") InventoryStore factory1Inventory) {
            return new VehicleFactoryService(tyreService, speakerService, factory1Inventory);
        }

        @Bean("factory2Service")
        public VehicleFactoryService factory2Service(
                @Qualifier("mrf") TyreService tyreService,
                @Qualifier("bose") SpeakerService speakerService,
                @Qualifier("factoryInventory") InventoryStore factory2Inventory) {
            return new VehicleFactoryService(tyreService, speakerService, factory2Inventory);
        }
    }
//    public class FactoryConfig {
//
//        @Bean("factoryTyreService")
//        public TyreService factoryTyreService() {
//            return new TyreService();
//        }
//
//        @Bean("factorySpeakerService")
//        public SpeakerService factorySpeakerService() {
//            return new SpeakerService();
//        }
//
//        @Bean("factoryInventory")
//        public InventoryStore factoryInventory() {
//            return new InventoryStore();
//        }
//
//        @Bean("factory1Service")
//        public VehicleFactoryService factory1Service(
//                @Qualifier("factoryTyreService") TyreService tyreService,
//                @Qualifier("factorySpeakerService") SpeakerService speakerService,
//                @Qualifier("factoryInventory") InventoryStore factory1Inventory) {
//            return new VehicleFactoryService(tyreService, speakerService, factory1Inventory);
//        }
//
//        @Bean("factory2Service")
//        public VehicleFactoryService factory2Service(
//                @Qualifier("factoryTyreService") TyreService tyreService,
//                @Qualifier("factorySpeakerService") SpeakerService speakerService,
//                @Qualifier("factoryInventory") InventoryStore factory2Inventory) {
//            return new VehicleFactoryService(tyreService, speakerService, factory2Inventory);
//        }
//    }
