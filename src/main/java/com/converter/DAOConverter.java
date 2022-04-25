package com.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dto.AdminModel;
import com.dto.UserModel;
import com.entity.AdminEntity;
import com.entity.UserModelEntity;

@Service
public class DAOConverter {
	private DAOConverter() {

	}

	public static UserModel userEntityToDto(UserModelEntity userEntity) {
		if (userEntity != null) {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(userEntity, UserModel.class);
		}
		return null;
	}

	public static UserModelEntity userDtoToEntity(UserModel userDTO) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(userDTO, UserModelEntity.class);
	}

	public static AdminModel adminEntitytoDto(AdminEntity adminEntity) {
		if(adminEntity!=null)
		{
			ModelMapper mapper = new ModelMapper();
			return mapper.map(adminEntity, AdminModel.class);	
		}
		return null;
	}

	public static AdminEntity adminDtoToEntity(AdminModel adminModel) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(adminModel, AdminEntity.class);
	}
}
