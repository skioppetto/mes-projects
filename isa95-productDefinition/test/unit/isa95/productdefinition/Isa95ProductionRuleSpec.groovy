package isa95.productdefinition

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Isa95ProductionRule)
class Isa95ProductionRuleSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "id is not nullable"() {
    	when: "id is set to null"
    	def  rule = new Isa95ProductionRule(
    		id: null,
    		version: "vDefault",
    		description: "test-description",
    		publishedDate: new Date(),
    		durationUOM: "minutes"
    		)
    	then: "should not be validated"
    	!rule.validate()
    	rule.hasErrors()
    	rule.errors['id'].code == 'nullable'
    }

    void "version is not nullable"() {
    	when: "version is set to null"
    	def  rule = new Isa95ProductionRule(
    		id: "my-test-id",
    		version: null,
    		description: "test-description",
    		publishedDate: new Date(),
    		durationUOM: "minutes"
    		)
    	then: "should not be validated"
    	!rule.validate()
    	rule.hasErrors()
    	rule.errors['version'].code == 'nullable'
    }

    void "publishedDate has default value"() {
    	when: "publishedDate is set to null"
    	def  rule = new Isa95ProductionRule(
    		id: "my-test-id",
    		version: "vDefault",
    		description: "test-description",
    		durationUOM: "minutes"
    		)
    	then: "should be valued"
    	rule.validate()
    	!rule.hasErrors()
    	rule.publishedDate != null
    }

    void "description is nullable"() {
    	when: "description is set to null"
    	def  rule = new Isa95ProductionRule(
    		id: "my-test-id",
    		version: "vDefault",
    		description: null,
    		durationUOM: "minutes"
    		)
    	then: "should  be validated"
    	rule.validate()
    	!rule.hasErrors()
    }

    void "durationUOM is nullable"() {
    	when: "durationUOM is set to null"
    	def  rule = new Isa95ProductionRule(
    		id: "my-test-id",
    		version: "vDefault",
    		description: "test-description",
    		durationUOM: null
    		)
    	then: "should  be validated"
    	rule.validate()
    	!rule.hasErrors()
    }
}
