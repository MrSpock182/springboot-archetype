package com.example.demo.domain.dto;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class DTORulesTest {

    @ArchTest
    static ArchRule dtos_must_be_suffixed_in_correctPackage =
            classes()
                    .that().resideInAPackage("..dto..")
                    .should().haveSimpleNameEndingWith("DTO");
}
