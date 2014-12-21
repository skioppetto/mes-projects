package isa95.productdefinition

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Isa95MaterialSpecification)
class Isa95MaterialSpecificationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test materialUse in list"() {
    	when: "materialUse out of defined list"
    	def mat = new Isa95MaterialSpecification(
			materialClass:"material-class",
			materialDefinition:"test-mat-definition",
			description: "test-description",
			materialUse: "BlaBla",
			quantity: 12.34,
			quantityUOM: "kilograms"
    		)
    	then: "validation should fail"
    	!mat.validate()
    	mat.hasErrors()
    	mat.errors['materialUse'].code=='not.inList'
    }

    void "test materialClass and materialDefinition both null"(){
    	when: "materialClass and materialDefinition are null"
    	def mat = new Isa95MaterialSpecification(
			materialClass:null,
			materialDefinition:null,
			description: "description",
			materialUse: "Consumed",
			quantity: 12.34,
			quantityUOM: "kilograms"
    		)
    	then: "validation should fail"
    	!mat.validate()
    	mat.hasErrors()
    	mat.errors['materialClass'].code == 'bothNullable'
    	mat.errors['materialDefinition'].code == 'bothNullable'
    }

    void "test materialClass null and materialDefinition not null"(){
    	when: "materialClass is null"
    	def mat = new Isa95MaterialSpecification(
			materialClass:null,
			materialDefinition:"test-mat-definition",
			description: "description",
			materialUse: "Consumed",
			quantity: 12.34,
			quantityUOM: "kilograms"
    		)
    	then: "validation should not fail"
    	mat.validate()
    	!mat.hasErrors()
	}

    void "test materialClass not null and materialDefinition null"(){
    	when: "materialDefinition is null"
    	def mat = new Isa95MaterialSpecification(
			materialClass:"test-mat-class",
			materialDefinition:null,
			description: "description",
			materialUse: "Consumed",
			quantity: 12.34,
			quantityUOM: "kilograms"
    		)
    	then: "validation should not fail"
    	mat.validate()
    	!mat.hasErrors()
    }

    void "test description null"(){
    	when: "description is null"
    	def mat = new Isa95MaterialSpecification(
			materialClass:"test-mat-class",
			materialDefinition:"test-mat-definition",
			description: null,
			materialUse: "Consumed",
			quantity: 12.34,
			quantityUOM: "kilograms"
    		)
    	then: "validation should not fail"
    	mat.validate()
    	!mat.hasErrors()
    }

    void "test quantity and quantityUOM null"(){
    	when: "quantity/quantityUOM are null"
    	def mat = new Isa95MaterialSpecification(
			materialClass:"test-mat-class",
			materialDefinition:"test-mat-definition",
			description: "test-mat-definition",
			materialUse: "Consumed",
			quantity: null,
			quantityUOM: null
    		)
    	then: "validation should not fail"
    	mat.validate()
    	!mat.hasErrors()
    }


}
