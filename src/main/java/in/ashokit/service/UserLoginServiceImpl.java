package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.UserSignIn;
import in.ashokit.constants.AppConstants;
import in.ashokit.entities.UserEntity;
import in.ashokit.props.AppProperties;
import in.ashokit.repositories.UserRepository;
@Service
public class UserLoginServiceImpl implements UserLoginService
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AppProperties appProps;

	@Override
	public String userLogin(UserSignIn user)
	{
		
		UserEntity userEntity =userRepo.findByUserEmailAndUserPwd(user.getEmail(),user.getPwd());
		if(null == userEntity)
		{
			return appProps.getMessages().get(AppConstants.INVALID_CREDENTIALS);
			
		}
			if(userEntity.getUserAccStatus().equals(AppConstants.LOCKED))
			{
				return appProps.getMessages().get(AppConstants.ACCOUNT_IS_LOCKED);
			}
			
			
		return appProps.getMessages().get(AppConstants.SUCESS);
	}
	

}
