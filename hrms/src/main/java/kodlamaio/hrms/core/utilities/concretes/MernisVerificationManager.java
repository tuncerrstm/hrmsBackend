package kodlamaio.hrms.core.utilities.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.abstracts.MernisVerificationService;


@Service
public class MernisVerificationManager implements MernisVerificationService {

	@Override
	public void mernisVerification() {
		System.out.println("Mernis dogrulamasi yapiliyor.");
		
	}
	
}
