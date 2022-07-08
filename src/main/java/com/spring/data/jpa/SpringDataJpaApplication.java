package com.spring.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.data.jpa.repository.UserRepository;
import com.spring.data.jpa.repository.UserRepositoryImpl;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		/* Create */
		UserRepositoryImpl.saveSingelObject(repository, "FirstName LastName", 'M', 0);
		UserRepositoryImpl.saveListOfObject(repository);
		/* Read */
		UserRepositoryImpl.getAllUsers(repository);
		UserRepositoryImpl.getUserById(1, repository);
		/* Update */
		UserRepositoryImpl.update(1, repository, "FirstName LastName", 'M', 20000);
		/* Delete */
		UserRepositoryImpl.delete(1, repository);

		/* Custom Methods */
		UserRepositoryImpl.getUsersByGender('M', repository);
		UserRepositoryImpl.getUsersBySalary(10000, repository);

		System.out.println(repository.getAllUsersUsingJPQL());
		System.out.println(repository.getUserByName("Prashant Dake", 'M'));
		System.out.println(repository.getAllUsersUsingNativeSQLQuery());

	}

}
