package com.steph.cleanarch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class CleanArchitectureBoundaryTest {

    private static final String VIEW_LAYER = "View";
    private static final String CONSUMER_LAYER = "Consumer";
    private static final String BUSINESS_LOGIC_LAYER = "Business Logic";
    private static final String MESSAGING_LAYER = "Messaging";
    private static final String PERSISTENCE_LAYER = "Persistence";
    private static final String EXTERNAL_LAYER = "External";

    @Test
    void givenLayer_whenChecked_shouldNotViolateBoundary() {
        JavaClasses classes = new ClassFileImporter()
            .importPackages("com.steph.cleanarch");

        layeredArchitecture()
            .layer(VIEW_LAYER)
            .definedBy("..adapter.in.web..")
            .layer(CONSUMER_LAYER)
            .definedBy("..adapter.in.consumer..")
            .layer(BUSINESS_LOGIC_LAYER)
            .definedBy("..application.port..")
            .layer(MESSAGING_LAYER)
            .definedBy("..adapter.out.messaging..")
            .layer(PERSISTENCE_LAYER)
            .definedBy("..adapter.out.persistence..")
            .layer(EXTERNAL_LAYER)
            .definedBy("..external..")

            .whereLayer(VIEW_LAYER)
            .mayNotBeAccessedByAnyLayer()
            .whereLayer(BUSINESS_LOGIC_LAYER)
            .mayOnlyBeAccessedByLayers(VIEW_LAYER, CONSUMER_LAYER, MESSAGING_LAYER, PERSISTENCE_LAYER, EXTERNAL_LAYER)
            //TODO: redefine test for external layer
//            .whereLayer(EXTERNAL_LAYER)
//            .mayNotBeAccessedByAnyLayer()
            .check(classes);
    }
}

