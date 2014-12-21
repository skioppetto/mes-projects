package isa95.productdefinition

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Isa95MaterialSpecificationProperty)
class Isa95MaterialSpecificationPropertySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test set name"() {
    	when: 'init name in constructor' 
    	def prop = new Isa95MaterialSpecificationProperty(name:"my-test-name")
    	then: 'the property must be set'
    	prop.name == 'my-test-name'
    }

    void "test set description"() {
    	when: 'init description in constructor' 
    	def prop = new Isa95MaterialSpecificationProperty(description:"my-test-description")
    	then: 'the property must be set'
    	prop.description == 'my-test-description'
    }

    void "test set value and uom"() {
    	when: 'init value  and uom in constructor' 
    	def prop = new Isa95MaterialSpecificationProperty(value:"my-test-value", valueUOM:"ohm")
    	then: 'the properties must be set'
    	prop.value == 'my-test-value'
    	prop.valueUOM == 'ohm'  		
    }

    void "test set quantity double value and uom"() {
    	when: 'init quantity  and uom in constructor' 
    	def prop = new Isa95MaterialSpecificationProperty(quantity:12.25, quantityUOM:"kilograms")
    	then: 'the properties must be set'
    	prop.quantity == 12.25
    	prop.quantityUOM == 'kilograms'
    }

    void "init the whole object"() {
    	when: 'init all properties' 
    	def prop = new Isa95MaterialSpecificationProperty(
    		name:"my-test-name",
    		description: "my-test-description",
    		value: "my-test-value",
    		valueUOM: "ohm",
    		quantity:34.34, 
    		quantityUOM:"kilograms")
    	then: 'the properties must be set'
    	prop.name == 'my-test-name'
    	prop.description == 'my-test-description'
    	prop.value == 'my-test-value'
    	prop.valueUOM == 'ohm'
    	prop.quantity == 34.34
    	prop.quantityUOM == 'kilograms'
    } 

    void "description should be nullable"(){
    	when: 'description is null' 
    	def prop = new Isa95MaterialSpecificationProperty(
    		name:"my-test-name",
    		description: null,
    		value: "my-test-value",
    		valueUOM: "ohm",
    		quantity:34.34, 
    		quantityUOM:"kilograms")
    	then: 'the object should be validated'
    	prop.validate()
    	!prop.hasErrors()
    }

     void "quantity should be nullable"(){
    	when: 'quantity is null' 
    	def prop = new Isa95MaterialSpecificationProperty(
    		name:"my-test-name",
    		description: "my-test-description",
    		value: "my-test-value",
    		valueUOM: "ohm",
    		quantity:null, 
    		quantityUOM:"kilograms")
    	then: 'the object should be validated'
    	prop.validate()
    	!prop.hasErrors()
    }

    void "quantity and quantityUOM should be nullable"(){
    	when: 'quantityUOM is null' 
    	def prop = new Isa95MaterialSpecificationProperty(
    		name:"my-test-name",
    		description: "my-test-description",
    		value: "my-test-value",
    		valueUOM: "ohm",
    		quantity:null, 
    		quantityUOM:null)
    	then: 'the object should be validated'
    	prop.validate()
    	!prop.hasErrors()
    }

    void "name should be not nullable"(){
    	when: 'description is null' 
    	def prop = new Isa95MaterialSpecificationProperty(
    		name:null,
    		description: "my-test-description",
    		value: "my-test-value",
    		valueUOM: "ohm",
    		quantity:34.34, 
    		quantityUOM:"kilograms")
    	then: 'the object should contains errors'
    	!prop.validate()
    	prop.hasErrors()
    	prop.errors['name'].code=='nullable'
    }

    void "value should be not nullable"(){
    	when: 'description is null' 
    	def prop = new Isa95MaterialSpecificationProperty(
    		name:"my-test-name",
    		description: "my-test-description",
    		value: null,
    		valueUOM: "ohm",
    		quantity:34.34, 
    		quantityUOM:"kilograms")
    	then: 'the object should contains errors'
    	!prop.validate()
    	prop.hasErrors()
    	prop.errors['value'].code=='nullable'
    }

     void "valueUOM should be not nullable"(){
    	when: 'description is null' 
    	def prop = new Isa95MaterialSpecificationProperty(
    		name:"my-test-name",
    		description: "my-test-description",
    		value: "my-test-value",
    		valueUOM: null,
    		quantity:34.34, 
    		quantityUOM:"kilograms")
    	then: 'the object should contains errors'
    	!prop.validate()
    	prop.hasErrors()
    	prop.errors['valueUOM'].code=='nullable'
    }
}
