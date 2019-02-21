package Project.jdbc_World.data.models;

public class City {

	private int id; 
	private String Name;
	private String CountryCode;
	private String district;
	private int Population;
	
	public City(int id, String name, String countryCode, String district, int population) {
		super();
		this.id = id;
		Name = name;
		CountryCode = countryCode;
		this.district = district;
		Population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return Population;
	}

	public void setPopulation(int population) {
		Population = population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", Name=" + Name + ", CountryCode=" + CountryCode + ", district=" + district
				+ ", Population=" + Population + "]";
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CountryCode == null) ? 0 : CountryCode.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Population;
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (CountryCode == null) {
			if (other.CountryCode != null)
				return false;
		} else if (!CountryCode.equals(other.CountryCode))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Population != other.Population)
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (id != other.id)
			return false;
		return true;
	}


	
	
}
