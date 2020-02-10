package com.example.demo.domain;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.demo")
public class ModelRulesTest {

    @ArchTest
    static ArchRule entities_must_be_suffixed_in_correct_package =
            classes()
                    .that().areAnnotatedWith("Entity")
                    .should().resideInAPackage("..model..");
}
