package jp.co.ixui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ixui.domain.MstEmp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginUserDetailsTest {

	@Test
	public void ユーザー情報が格納されているか確認(){

		//MstEmpに仮の値を入れる
		MstEmp mstEmp = new MstEmp();
		mstEmp.setMailAddress("test@tosyo.co.jp");
		mstEmp.setPassword("test");
		mstEmp.setAdminFrag("0");

		LoginUserDetails loginUserDetails = new LoginUserDetails(mstEmp);
		System.out.println(loginUserDetails.getUser());
	}

	@Test
	public void MstEmpが空の場合(){

		MstEmp mstEmp = new MstEmp();

		try{
		LoginUserDetails loginUserDetails = new LoginUserDetails(mstEmp);
		System.out.println(loginUserDetails.getUser());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}