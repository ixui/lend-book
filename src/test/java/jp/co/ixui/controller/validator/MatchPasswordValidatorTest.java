package jp.co.ixui.controller.validator;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ixui.controller.NewUserRegistrationForm;
import jp.co.ixui.mapper.MstEmpMapper;
import jp.co.ixui.service.EmpService;

/**
 * {@link MatchPasswordValidator}のユニットテストです。<br>
 * バリデーションが正しく動作しているか確認しています。
 * @author NAKAJIMA
 *
 */
@RunWith(SpringRunner.class)
public class MatchPasswordValidatorTest {

	/**
	 * テスト対象クラス
	 */
	@InjectMocks
	private MatchPasswordValidator validator;

	/**
	 * バリデーションの設定
	 */
	private ConstraintValidatorContext context;

	/**
	 * 書籍マッパー<br>
	 * モック
	 */
	@Mock
	private MstEmpMapper mapper;

	/**
	 * 書籍の処理クラス<br>
	 * モック
	 */
	@Mock
	EmpService service;

	/**
	 * サービスクラスがTrueを返す時にバリデーションがTrueを正しく返しているか確認しています。
	 */
	@Test
	public void バリデーションがTrueを正しく返しているかを確認(){

		NewUserRegistrationForm form = new NewUserRegistrationForm();
		form.setPassword("aiueo");
		form.setRetypePassword("aiueo");

		when(service.passwordMatch(anyString(), anyString())).thenReturn((true));

		assertEquals(true, validator.isValid(form, context));
	}
}