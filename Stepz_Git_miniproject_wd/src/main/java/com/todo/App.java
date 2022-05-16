package com.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Mouse;
import com.todo.model.Todo;
import com.todo.utils.DBUtils;

public class App {

	public static void main(String[] args) {
		
		//빌더테스트
		Mouse m = new Mouse();
		m.setName("제리");
		System.out.println(m);
		
//		Mouse.builder().name("안녕").isbool(false).build();
		
		
		// 초기 테이블 생성
//		DBUtils.dropAndCreateTable();
		
		TodoController todoController = new TodoController();
		
		// 전체 Todo 조회(SELECT * FROM todo;)
		todoController.findAll();
		
		// 할일 순서 번호(id)로 하나의 Todo 조회
//		long todoId = 7L;
//		todoController.findById(todoId);

//		// 하나의 Todo 등록
//		Todo todo = new Todo.Builder(null)
//				.title("빵 먹기")
//				.description("소보루 빵을 먹는다")
//				.dueDate(LocalDate.of(2022, 05, 22))
//				.build();
//		todoController.save(todo);
		
//		long todoNumber = 2L;
//		todoController.deleteById(todoNumber);
//		
		Long todoNumbers = 5L;
		todoController.updateById(todoNumbers, new Todo("유튜브보기", "Ted ed를 시청한다.", LocalDate.of(2022, 05, 10)));
	}
}
