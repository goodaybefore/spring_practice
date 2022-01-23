package kr.green.practice.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_gender;
	private Date me_birth;
	private String me_address;
	private String me_phone;
	
	public void setMe_birth(String me_birth) {
		SimpleDateFormat format;
		try {
			format = new SimpleDateFormat("yyyy-MM-dd");
			this.me_birth = format.parse(me_birth);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}
}
