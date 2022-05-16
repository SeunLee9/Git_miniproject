package com.todo.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todo;
import com.todo.utils.DBUtils;

// Data Access Object , DB 접근을 담당하는 클래스
public class TodoDAO {

	private Todo todo;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	// 전체 Todo 조회(try-catch, Java 7 이전 방식)
	public List<Todo> findAll() {

		// SELECT Query
		final String selectQuery = "SELECT * FROM todo";
		List<Todo> todos = new ArrayList<>();

		try {
			// Java 와 MySQL의 연결 통로(Connection)생성, DB 커넥션 연결
			connection = DBUtils.getConnection();
			// 통로를 통해 SQL을 전달할 객체 Statement 생성, DB로의 Query 전달 객체
			statement = connection.createStatement();
			// 실제 Query 전달 및 수행(진행시켜)
			resultSet = statement.executeQuery(selectQuery);

			// while문 안에 조건식 next() => boolean type
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Date duedate = resultSet.getDate("due_date");
				boolean isCompleted = resultSet.getBoolean("is_Completed");
				todo = new Todo(id, title, description, duedate.toLocalDate(), isCompleted);
				todos.add(todo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 자원 해제, 마지막으로 생성된 순서부터 거꾸로 해제
			// MySQL과 자바의 통로를 반환하는 작업
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return todos;
	}

	public Todo findById(Long id) {

		// SELECT QUERY
		final String selectQuery = "SELECT * FROM todo WHERE id = ? ";
		// Java & MySQL 연결을 위한 Connection 생성
		try (Connection connection = DBUtils.getConnection(); // 자원을 해제할 수 있는 것만 넣을수 있다.
				PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, id);
				ResultSet resultSet = preparedStatement.executeQuery();) {
			// try()에서 ()내부에 작성할 수 있는 객체 혹은 인터페이스는 Autoclosable 인터페이스를 상속받은 것만 가능하다.

			// 결과값(ResultSet)맵핑
			while (resultSet.next()) {
				todo = new Todo.Builder(resultSet.getLong("id")).title(resultSet.getString("title"))
						.description(resultSet.getString("description"))
						.dueDate(resultSet.getDate("due_date").toLocalDate())
						.isCompleted(resultSet.getBoolean("is_completed")).build();
//							resultSet.getLong("id"), 
//							resultSet.getString("title"),
//							resultSet.getString("description"), 
//							resultSet.getDate("due_date").toLocalDate(),
//							resultSet.getBoolean("is_completed")

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return todo;
	}

	private PreparedStatement createPreparedStatement(Connection connection, String sql, Long id) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		return preparedStatement;
	}

	// Todo 등록 (INSERT)
	public int save(Todo newTodo) {
		String insertQuery = "INSERT INTO todo (title, description, due_date) VALUES(?, ?, ?)";
		int affectedRows = 0;

		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, insertQuery, newTodo)) {
			// query는 미리 넣어둠
			// 행의 갯수를 출력
			affectedRows = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	private PreparedStatement createPreparedStatement(Connection connection, String sql, Todo todo)
			throws SQLException {
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, todo.getTitle());
		preparedStatement.setString(2, todo.getDescription());
		preparedStatement.setString(3, todo.getDueDate().toString());

		return preparedStatement;
	}

	public int deleteById(Long id) {
		String deleteQuery = "DELETE FROM todo WHERE id = ? ";

		int affectedRows = 0;
		try (Connection connection = DBUtils.getConnection(); // 자원을 해제할 수 있는 것만 넣을수 있다.
				PreparedStatement preparedStatement = createPreparedStatement2(connection, deleteQuery, id);) {

			affectedRows = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	private PreparedStatement createPreparedStatement2(Connection connection, String sql, Long id) throws SQLException {

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);

		return preparedStatement;
	}

	public int updateById(Long todoNumber, Todo todo2) {
		String updateQuery = "UPDATE todo SET title='유튜브보기', description='Teded를 시청한다.', due_date='2022-05-10' WHERE id= ?;";
		int affectedRows = 0;
		try (Connection connection = DBUtils.getConnection(); // 자원을 해제할 수 있는 것만 넣을수 있다.
				PreparedStatement preparedStatement = createPreparedStatement2(connection, updateQuery, todoNumber);) {
			
//			preparedStatement.setString(todo.getTitle());
//			preparedStatement.setString(todo.getDescription());
//			preparedStatement.setString(todo.getDueDate().toString());
			

			affectedRows = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("completefwefwefew");
		}
		return affectedRows;
		
	}

	
	
}
