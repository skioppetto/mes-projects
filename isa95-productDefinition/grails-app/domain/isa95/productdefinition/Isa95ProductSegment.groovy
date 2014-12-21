package isa95.productdefinition

class Isa95ProductSegment {

	String id
    String description
    Double duration
    List<Isa95EquipmentSpecification> equipmentSpecifications
	List<Isa95MaterialSpecification> materialSpecifications
	List<Isa95PersonnelSpecification> personnelSpecifications
	List<Isa95ProductParameter> productParameters

	static mapping = {
		id generator: 'assigned'
	}

    static embedded = ['equipmentSpecifications', 
    	 'materialSpecifications', 
    	 'personnelSpecifications',
    	 'productParameters']

    static constraints = {
    	id nullable: false, bindable: true
    	description nullable: true
    	duration nullable: true
    }
}
