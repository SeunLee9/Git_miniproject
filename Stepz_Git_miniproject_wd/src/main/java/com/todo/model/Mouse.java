package com.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter  // setter 메서드 자동 생성
@Getter
@NoArgsConstructor // NoArgs(Arguments)인자값이 없는 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@Builder


//lombok 테스트용
public class Mouse {
	private String name;
}

