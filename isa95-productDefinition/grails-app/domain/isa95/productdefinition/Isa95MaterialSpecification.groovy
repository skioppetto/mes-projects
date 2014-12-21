package isa95.productdefinition

class Isa95MaterialSpecification {

    String materialClass
	String materialDefinition
	String description
	String materialUse
	Double quantity
	String quantityUOM
	List<Isa95MaterialSpecificationProperty> materialSpecificationProperties
	
   	static embedded = ['materialSpecificationProperties']

    static constraints = {
    	materialUse inList: ['Consumed', 'Produced', 'Consumable'], nullable: false
    	materialClass nullable: true, validator: {val, obj -> if (null == val && null == obj.materialDefinition) return ['bothNullable']}
    	materialDefinition nullable: true, validator: {val, obj -> if (null == val && null == obj.materialClass) return ['bothNullable']}
    	description nullable: true
    	quantity nullable: true
    	quantityUOM nullable: true
    }
}
