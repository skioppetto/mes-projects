package isa95.productdefinition

class Isa95EquipmentSpecification {

	String equipmentClass
	String equipment
	String description
	Float quantity
	String quantityUOM
	List<Isa95EquipmentSpecificationProperty> equipmentSpecificationProperties
	
	static embedded = ['equipmentSpecificationProperties']

    static constraints = {
    	equipment nullable: true, validator: {val, obj -> if (null == val && null == obj.equipmentClass) return ['bothNullable']}
    	equipmentClass nullable: true, validator: {val, obj -> if (null == val && null == obj.equipment) return ['bothNullable']}
    	description nullable: true
    	quantity nullable: true
    	quantityUOM nullable: true	
    }
}
