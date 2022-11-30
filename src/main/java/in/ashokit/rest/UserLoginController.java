package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.UserSignIn;
import in.ashokit.service.UserLoginService;

@RestController
public class UserLoginController
{
	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping("/login")
	public String userLogin(@RequestBody UserSignIn userSignIn)
	{
		return userLoginService.userLogin(userSignIn);
		
	}

}
