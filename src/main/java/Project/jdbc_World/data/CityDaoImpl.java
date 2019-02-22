package Project.jdbc_World.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Project.jdbc_World.data.models.City;

public class CityDaoImpl implements CityDao {

	private PreparedStatement creatPreparedStatementAdd(Connection conn, City city) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("INSERT INTO city VALUES (?,?,?,?,?)");
		statement.setInt(1, city.getId());
		statement.setString(2, city.getName());
		statement.setString(3, city.getCountryCode());
		statement.setString(4, city.getDistrict());
		statement.setInt(5, city.getPopulation());
		return statement;
	}

	@Override
	public City add(City city) {

		try (Connection conn = DatabaseAlt.getConnection();
				PreparedStatement statement = creatPreparedStatementAdd(conn, city);) {

			statement.executeUpdate();
			return findById(city.getId());

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return city;
	}

	private PreparedStatement creatPreparedStatementDelete(Connection conn, City city) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM city WHERE id=?");
		statement.setInt(1, city.getId());
		return statement;
	}

	@Override
	public int delete(City city) {

		try (Connection conn = DatabaseAlt.getConnection();
				PreparedStatement statement = creatPreparedStatementDelete(conn, city);) {

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("<City With below Id Has Been Removed>");
		return city.getId();
	}

	private PreparedStatement creatPreparedStatementFindAll(Connection conn) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city ");
		statement.getResultSet();
		return statement;
	}

	@Override
	public List<City> findAll() {

		List<City> result = new ArrayList<>();

		try (Connection conn = DatabaseAlt.getConnection();
				PreparedStatement statement = creatPreparedStatementFindAll(conn);
				ResultSet rs = statement.executeQuery()) {
			while (rs.next()) {
				return creatCityFormatResultList(rs);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return result;
	}

	private PreparedStatement creatPreparedStatementFindByCode(Connection conn, String Code) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE CountryCode like ?");
		statement.setString(1, Code + "%");
		return statement;
	}

	@Override
	public List<City> findByCode(String code) {

		List<City> result = new ArrayList<>();

		try (Connection conn = DatabaseAlt.getConnection();
				PreparedStatement statement = creatPreparedStatementFindByCode(conn, code);
				ResultSet rs = statement.executeQuery()) {
			while (rs.next()) {
				return creatCityFormatResultList(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return result;
	}

	private PreparedStatement creatPreparedStatementbyId(Connection conn, int number) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE id=?");
		statement.setInt(1, number);
		return statement;
	}

	@Override
	public City findById(int id) {

		City result = null;

		try (Connection conn = DatabaseAlt.getConnection();
				PreparedStatement statement = creatPreparedStatementbyId(conn, id);
				ResultSet rs = statement.executeQuery()) {
			while (rs.next()) {
				return creatCityFormatResultSet(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}

	private PreparedStatement creatPreparedStatementFindByName(Connection conn, String Name) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE Name like ?");
		statement.setString(1, Name + "%");
		return statement;
	}

	@Override
	public List<City> findByName(String name) {

		List<City> result = new ArrayList<>();

		try (Connection conn = DatabaseAlt.getConnection();
				PreparedStatement statement = creatPreparedStatementFindByName(conn, name);
				ResultSet rs = statement.executeQuery()) {
			while (rs.next()) {
				return creatCityFormatResultList(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return result;
	}

	@Override
	public void printCities() {
		try (Connection conn = DatabaseAlt.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("SELECT Name FROM city")) {

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private PreparedStatement creatPreparedStatementUpdate(Connection conn, City city) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("UPDATE city set name = ?,Population=? where id = ?");

		statement.setString(1, city.getName());
		statement.setInt(2, city.getPopulation());
		statement.setInt(3, city.getId());
		return statement;
	}

	@Override
	public City update(City city) {

		try (Connection conn = DatabaseAlt.getConnection();
				PreparedStatement statement = creatPreparedStatementUpdate(conn, city);) {

			statement.executeUpdate();
			return findById(city.getId());

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return city;
	}

	private List<City> creatCityFormatResultList(ResultSet rs) throws SQLException {

		List<City> result = new ArrayList<>();

		while (rs.next()) {
			City Found = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			result.add(Found);

		}
		return result;
	}

	private City creatCityFormatResultSet(ResultSet rs) throws SQLException {
		return new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
	}

}