package isa95.productdefinition
import grails.rest.*

@Resource(uri='/productionRules')
class Isa95ProductionRule {

	String id
	String version
	String description
	Date publishedDate = new Date()
	String durationUOM
	List<Isa95ProductSegment> productSegments

	static embedded=['productSegments']

	static mapping = {
		id generator: 'assigned'
	}

    static constraints = {
    	id nullable: false, bindable: true
    	version nullable: false, bindable: true
    	description nullable: true
    	durationUOM nullable: true
    }
}
