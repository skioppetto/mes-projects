package isa95.productdefinition

class Isa95PersonnelSpecification {

    String personnelClass
	String person
	String description
	Double quantity
	String quantityUOM
	List<Isa95PersonnelSpecificationProperty> personnelSpecificationProperties

   	static embedded = ['personnelSpecificationProperties']

    static constraints = {
    	personnelClass nullable: true, validator: {val, obj -> if (null == val && null == obj.person) return ['bothNullable']}
    	person nullable: true, validator: {val, obj -> if (null == val && null == obj.personnelClass) return ['bothNullable']}
    	description nullable: true
    	quantity nullable: true
    	quantityUOM nullable: true
    }
}
