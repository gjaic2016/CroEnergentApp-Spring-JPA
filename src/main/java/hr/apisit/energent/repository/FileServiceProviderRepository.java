//package hr.apisit.energent.repository;
//
//import hr.apisit.energent.domain.ServiceProvider;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
////@Repository
//public class FileServiceProviderRepository implements ServiceProviderRepositoryInterface {
//
//    public static final Integer NUMBER_OF_SERVICEPROVIDER_DATA_LINES = 5;
//
//    public static final String SERVICEPROVIDERS_FILE_NAME = "dat/serviceProviders.txt";
////    public static final String SERVICEPROVIDERS_FILE_NAME_WRITE = "dat/testServiceProviders.txt";
//
//    @Override
//    public List<ServiceProvider> getAllServiceProviders() {
//        List<ServiceProvider> serviceProvidersList = new ArrayList<>();
//
//        Path stageFilePath = Path.of(SERVICEPROVIDERS_FILE_NAME);
//
//        List<String> lines = null;
//
//        try {
//            lines = Files.readAllLines(stageFilePath);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
////        for (int i = 0; i < lines.size() / NUMBER_OF_SERVICEPROVIDER_DATA_LINES; i++) {
////
////            Integer serviceProviderId = Integer.parseInt(lines.get(i * NUMBER_OF_SERVICEPROVIDER_DATA_LINES));
////            String serviceProviderNaziv = lines.get(i * NUMBER_OF_SERVICEPROVIDER_DATA_LINES + 1);
////            String serviceProviderAdresa = lines.get(i * NUMBER_OF_SERVICEPROVIDER_DATA_LINES + 2);
////            ServiceType serviceProviderVrstaUslugeENUM = ServiceType.valueOf(lines.get(i * NUMBER_OF_SERVICEPROVIDER_DATA_LINES + 3));
////            String cijenaUslugeString = lines.get(i * NUMBER_OF_SERVICEPROVIDER_DATA_LINES + 4);
////            BigDecimal serviceProviderCijenaUsluge = new BigDecimal(cijenaUslugeString);
////
////            ServiceProvider newServiceProvider = new ServiceProvider(serviceProviderId, serviceProviderNaziv,
////                    serviceProviderAdresa, serviceProviderVrstaUslugeENUM, serviceProviderCijenaUsluge);
////
////            serviceProvidersList.add(newServiceProvider);
////        }
//        return serviceProvidersList;
//
//    }
//
//    @Override
//    public ServiceProvider getServiceProviderById(Integer id) {
////        return getAllServiceProviders().stream().filter(f -> f.getId().equals(id)).findFirst();
//        return null;
//    }
//
//    @Override
//    public void saveNewServiceProvide(ServiceProvider newServiceProvider) {
//        List<ServiceProvider> allServiceProviders = getAllServiceProviders();
//        Integer highestId = allServiceProviders.stream()
//                .map(s -> s.getId())
//                .max((id1, id2) -> id1.compareTo(id2))
//                .get();
//
//        newServiceProvider.setId(highestId + 1);
//        allServiceProviders.add(newServiceProvider);
//
//        saveAllServiceProvidersToFile(allServiceProviders);
//    }
//
//    private static void saveAllServiceProvidersToFile(List<ServiceProvider> serviceProviderList) {
////        Path serviceProviderFilePath = Path.of(SERVICEPROVIDERS_FILE_NAME);
////
////        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(serviceProviderFilePath.toFile(), false))) {
////
////            for (ServiceProvider serviceProvider : serviceProviderList) {
////                bufferedWriter.write(serviceProvider.getId().toString());
////                bufferedWriter.newLine();
////                bufferedWriter.write(serviceProvider.getNaziv().toString());
////                bufferedWriter.newLine();
////                bufferedWriter.write(serviceProvider.getAdresa().toString());
////                bufferedWriter.newLine();
////                bufferedWriter.write(serviceProvider.getVrstaUsluge().name());
////                bufferedWriter.newLine();
////                bufferedWriter.write(serviceProvider.getCijenaUsluge().toString());
////                bufferedWriter.newLine();
////            }
////
////
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//    }
//
//    @Override
//    public ServiceProvider updateServiceProvider(ServiceProvider updatedServiceProvider, Integer id) {
//        List<ServiceProvider> serviceProvidersList = getAllServiceProviders();
//
//        ServiceProvider updatedServiceProviderOptional = null;
//
//        for(ServiceProvider provider : serviceProvidersList) {
//            if(provider.getId().equals(id)) {
//                provider.setNaziv(updatedServiceProvider.getNaziv());
//                provider.setAdresa(updatedServiceProvider.getAdresa());
//                provider.setVrstaUsluge(updatedServiceProvider.getVrstaUsluge());
//                provider.setCijenaUsluge(updatedServiceProvider.getCijenaUsluge());
//
//                updatedServiceProviderOptional = provider;
//                break;
//            }
//        }
//
////        if(updatedServiceProviderOptional.isPresent()) {
////        }
//            saveAllServiceProvidersToFile(serviceProvidersList);
//
//        return updatedServiceProviderOptional;
//    }
//
//    @Override
//    public void deleteServiceProvider(Integer id) {
//        List<ServiceProvider> serviceProvidersList = getAllServiceProviders();
//
//        List<ServiceProvider> serviceProviderRemovedList =
//                serviceProvidersList.stream()
//                        .filter( f -> !f.getId().equals(id))
//                        .collect(Collectors.toList());
//
//        if(serviceProviderRemovedList.size() != serviceProvidersList.size()){
//            saveAllServiceProvidersToFile(serviceProviderRemovedList);
//        }
//    }
//}
