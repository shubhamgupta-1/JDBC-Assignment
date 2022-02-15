package com.model.service.trainee;

import java.util.*;

import com.model.exceptions.*;
import com.model.persistence.trainee.*;

public class TraineeServiceImpl implements TraineeService{

	private TraineeDao traineeDao;
	
	public TraineeServiceImpl() {
		traineeDao = new TraineeDaoImpl();
	}
	
	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeDao.addTrainee(trainee);
	}

	@Override
	public List<Trainee> getAll() throws DataAccessException {
		List<Trainee> trainees = new ArrayList<>();
		trainees = traineeDao.getAll();
		return trainees;
	}

	@Override
	public Optional<Trainee> getById(int id) throws TraineeNotFoundException {
		Optional<Trainee> trainee = traineeDao.getById(id);
		return trainee;
	}

}
