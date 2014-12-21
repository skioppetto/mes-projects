import isa95.productdefinition.*

def rule = new Isa95ProductionRule(
    id: "my-test-rule",
    version: "vDefault",
    description: "this is a test rule",
    durationUOM: "minutes",
    productSegments: [
        new Isa95ProductSegment(
            id: "rule-prod-segment-1",
            description: "first production segment for test-rule",
            duration: 25.45,
            equipmentSpecifications: [
                new Isa95EquipmentSpecification(
                    equipmentClass: "eq-class",
                    description: "eq-description",
                    quantity: 20.50,
                    quantityUOM: "seconds"
                ),
                new Isa95EquipmentSpecification(
                    equipmentClass: "eq-class-b",
                    description: "eq-description-v",
                    quantity: 20.55,
                    quantityUOM: "seconds"
                )
            ],
            materialSpecifications: [
                new Isa95MaterialSpecification(
                    materialClass: "material-class",
                    description: "material-description",
                    quantity: 21.50,
                    quantityUOM: "chilograms",
                    materialUse: "Produced"
                ),
                new Isa95MaterialSpecification(
                    materialClass: "material-class-1",
                    description: "material-description-d",
                    quantity: 21.90,
                    quantityUOM: "chilograms",
                    materialUse: "Consumed"
                )
            ],
            personnelSpecifications: [
                new Isa95PersonnelSpecification(
                    personnelClass: "personnel-class-1",
                    description: "personnel-description-d",
                    quantity: 4,
                    quantityUOM: "hours"                   
                )
            ]
        )
    ]
)

rule.insert(failOnError: true)