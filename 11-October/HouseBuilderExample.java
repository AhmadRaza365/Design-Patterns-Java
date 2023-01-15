// Builder Design Pattern
// Date: 11-October-2022

interface HousePlan {
	public void setBasement(String basement);

	public void setStructure(String structure);

	public void setRoof(String roof);

	public void setInterior(String interior);
}

class House implements HousePlan {

	private String basement;
	private String structure;
	private String roof;
	private String interior;

	public void setBasement(String basement) {
		this.basement = basement;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

}

interface HouseBuilder {

	public void buildBasement();

	public void buildStructure();

	public void buildRoof();

	public void buildInterior();

	public House getHouse();
}

class SimpleHouseBuilder implements HouseBuilder {

	private House house;

	public SimpleHouseBuilder() {
		this.house = new House();
	}

	public void buildBasement() {
		house.setBasement("Simple Basement");
	}

	public void buildStructure() {
		house.setStructure("Simple Structure");
	}

	public void buildRoof() {
		house.setRoof("Simple Roof");
	}

	public void buildInterior() {
		house.setInterior("Simple Interior");
	}

	public House getHouse() {
		System.out.println("Simple House");
		return this.house;
	}
}

class PremiumHouseBuilder implements HouseBuilder {

	private House house;

	public PremiumHouseBuilder() {
		this.house = new House();
	}

	public void buildBasement() {
		house.setBasement("Premium Basement");
	}

	public void buildStructure() {
		house.setStructure("Premium Structure");
	}

	public void buildRoof() {
		house.setRoof("Premium Roof");
	}

	public void buildInterior() {
		house.setInterior("Premium Interior");
	}

	public House getHouse() {
		System.out.println("Premium House");
		return this.house;
	}
}

class CivilEngineer {

	private HouseBuilder houseBuilder;

	public CivilEngineer(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	public House getHouse() {
		return this.houseBuilder.getHouse();
	}

	public void constructHouse() {
		this.houseBuilder.buildBasement();
		this.houseBuilder.buildStructure();
		this.houseBuilder.buildRoof();
		this.houseBuilder.buildInterior();
	}
}

class Director {
	HouseBuilder houseType;
	CivilEngineer engineer;

	CivilEngineer buildHouse(String type) {
		if (type == "simple") {
			houseType = new SimpleHouseBuilder();
		}
		if (type == "premium") {
			houseType = new PremiumHouseBuilder();
		}

		return engineer = new CivilEngineer(houseType);
	}
}

class HouseBuilderExample {
	public static void main(String[] args) {

		Director dir = new Director();

		CivilEngineer engineer = dir.buildHouse("simple");
		engineer.constructHouse();

		System.out.println("Construct Simple House");
		House house = engineer.getHouse();
		System.out.println("House Builder: " + house);
	}
}
