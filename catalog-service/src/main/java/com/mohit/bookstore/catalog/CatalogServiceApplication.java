package com.mohit.bookstore.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

// Add spring boot main class here
@SpringBootApplication
@ConfigurationPropertiesScan
public class CatalogServiceApplication {

    //    public static void main(String[] args) {
    //        List<ApplicationInfo> applications = List.of(
    //                new ApplicationInfo("CLML", "app-1", "env-1"),
    //                new ApplicationInfo("CLML", "app-2", "env-2"),
    //                new ApplicationInfo("CLML", "app-3", "env-1"),
    //                new ApplicationInfo("POM", "app-1", "env-1")
    //        );
    //
    //        Map<AbstractMap.SimpleEntry<String, String>, List<ApplicationInfo>> grouped = applications.stream()
    //                .collect(Collectors.groupingBy(
    //                        app -> new AbstractMap.SimpleEntry<>(app.getAppName(), app.getEnvironment())
    //                ));
    //
    //        List<GroupedApplication> transformed = grouped.entrySet().stream()
    //                .map(entry -> new GroupedApplication(
    //                        entry.getKey().getKey(), // appName
    //                        entry.getKey().getValue(), // environment
    //                        entry.getValue().stream()
    //                                .map(app -> new SubApplication(app.getSubApp()))
    //                                .collect(Collectors.toList())
    //                ))
    //                .collect(Collectors.toList());
    //
    //        //print transformed
    //        transformed.forEach(System.out::println);
    //    }

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }
}
