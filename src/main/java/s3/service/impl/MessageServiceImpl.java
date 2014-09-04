package s3.service.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import s3.service.MessageService;



@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageServiceImpl implements MessageService {
	@Override
	public String getMessage() {
		
		return "H311o World!";
	}
}
