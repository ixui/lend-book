package jp.co.ixui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ixui.mapper.MstEmpMapper;
import jp.co.ixui.security.UserDetailsServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LendBookApplicationTests {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	MstEmpMapper mstEmpMapper;

	@Test
	public void 判定が正しいかのテスト(){
		String mail_address = "admin@tosyo.co.jp";
		try{
		userDetailsServiceImpl.loadUserByUsername(mail_address);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void 判定が正しくない場合のテスト(){
		try{
		userDetailsServiceImpl.loadUserByUsername("null@tosyo.co.jp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
