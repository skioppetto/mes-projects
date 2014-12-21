package isa95.productdefinition

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Isa95EquipmentSpecification)
class Isa95EquipmentSpecificationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "description should be nullable"() {
    	when: "description is null"
    	def eq = new Isa95EquipmentSpecification(
    		equipmentClass: "eq-class",
    		equipment: "eq-test",
    		description: null,
    		quantity: 14.34,
    		quantityUOM: "kilograms"
    		)
    	then: "object should be validated"
    	eq.validate()
    	!eq.hasErrors()
    }

    void "equipment should be nullable"() {
    	when: "equipment is null"
    	def eq = new Isa95EquipmentSpecification(
    		equipmentClass: "eq-class",
    		equipment: null,
    		description: "eq-description",
    		quantity: 14.34,
    		quantityUOM: "kilograms"
    		)
    	then: "object should be validated"
    	eq.validate()
    	!eq.hasErrors()
    }

    void "equipmentClass should be nullable"() {
    	when: "equipmentClass is null"
    	def eq = new Isa95EquipmentSpecification(
    		equipmentClass: null,
    		equipment: "eq-test",
    		description: "eq-description",
    		quantity: 14.34,
    		quantityUOM: "kilograms"
    		)
    	then: "object should be validated"
    	eq.validate()
    	!eq.hasErrors()
    }

    void "quantity and quantityUOM should be nullable"() {
    	when: "quantity and quantityUOM are null"
    	def eq = new Isa95EquipmentSpecification(
    		equipmentClass: "eq-class",
    		equipment: "eq-test",
    		description: "eq-description",
    		quantity: null,
    		quantityUOM: null
    		)
    	then: "object should be validated"
    	eq.validate()
    	!eq.hasErrors()
    }

    void "equipment and equipmentClass should not be both nullable"() {
    	when: "both equipment and equipmentClass are null"
    	def eq = new Isa95EquipmentSpecification(
    		equipmentClass: null,
    		equipment: null,
    		description: "eq-description",
    		quantity: 12.32,
    		quantityUOM: "kilograms"
    		)
    	then: "object should be validated"
    	!eq.validate()
    	eq.hasErrors()
    	eq.errors['equipmentClass'].code == 'bothNullable'
    	eq.errors['equipment'].code == 'bothNullable'
    }
}
