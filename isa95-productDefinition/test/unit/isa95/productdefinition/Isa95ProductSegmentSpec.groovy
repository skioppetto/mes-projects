package isa95.productdefinition

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Isa95ProductSegment)
class Isa95ProductSegmentSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test id is not nullable"() {
    	when: "id is set to null"
    	def prod = new Isa95ProductSegment(
    		id: null,
    		description: "my-test-description",
    		duration: 12.45
    		)
    	then: "validation should fail"
    	!prod.validate()
    	prod.hasErrors()
    	prod.errors['id'].code == 'nullable'
    }

    void "test description is nullable"() {
    	when: "description is null"
    	def prod = new Isa95ProductSegment(
    		id: "my-test-id",
    		description: null,
    		duration: 12.45
    		)
    	then: "validation should ok"
    	prod.validate()
    	!prod.hasErrors()
    }

    void "test duration is nullable"() {
    	when: "duration is null"
    	def prod = new Isa95ProductSegment(
    		id: "my-test-id",
    		description: "my-test-description",
    		duration: null
    		)
    	then: "validation should ok"
    	prod.validate()
    	!prod.hasErrors()
    }
}
