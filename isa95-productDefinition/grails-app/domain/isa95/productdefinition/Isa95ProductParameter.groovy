package isa95.productdefinition

class Isa95ProductParameter {

	String name
	String description
	String value
	String valueUOM

    static constraints = {
    	name nullable: false
    	description nullable: true
    	value nullable: false
    	valueUOM nullable: false
    }
}
