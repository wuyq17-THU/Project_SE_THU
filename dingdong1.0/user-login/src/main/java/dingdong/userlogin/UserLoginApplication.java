package dingdong.userlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RestController
public class UserLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLoginApplication.class, args);
	}

	/**
	 * user login
	 *
	 * @param userid:   required, string
	 *        password: required, string
	 * @return {
	 *  			"success":bool
	 *  			"msg":String
	 * 			}
	 */
	@GetMapping("/api/user/login")
	public Dict loginResult()
}
