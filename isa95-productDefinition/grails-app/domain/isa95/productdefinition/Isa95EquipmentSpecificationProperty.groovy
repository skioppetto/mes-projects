package isa95.productdefinition

class Isa95EquipmentSpecificationProperty {

    String name
	String description
	String value
	String valueUOM
	Double quantity
	String quantityUOM

    static constraints = {
    	name nullable: false
    	description nullable: true
    	value nullable: false
    	valueUOM nullable: false
    	quantity nullable: true
    	quantityUOM nullable: true
    }
}
