/**
 * 
 */
package com.tbooking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tbooking.services.ICarRepository;
import com.tbooking.services.IVehicalResetService;

/**
 * @author Shailendra
 *
 */
@Component
public class VehicalResetService implements IVehicalResetService {

	@Autowired
	private ICarRepository repo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tb.services.IVehicalResetService#resetAll()
	 */
	@Override
	public void resetAll() {
		repo.initRepository();
	}

}
