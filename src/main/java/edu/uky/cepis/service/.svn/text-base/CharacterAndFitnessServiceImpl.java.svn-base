

package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.CharacterAndFitnessDao;
import edu.uky.cepis.domain.CharacterAndFitness;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public class CharacterAndFitnessServiceImpl implements CharacterAndFitnessService{
	
	private CharacterAndFitnessDao characterAndFitnessDao;

	@Override
	public CharacterAndFitness findCharacterAndFitnessById(long id) {
		return getCharacterAndFitnessDao().findCharacterAndFitnessById(id);
	}

	@Override
	public List<CharacterAndFitness> findCharacterAndFitnessByExample(CharacterAndFitness characterAndFitness) {
		return getCharacterAndFitnessDao().findCharacterAndFitnessByExample(characterAndFitness);
	}

	@Override
	public boolean saveOrUpdateCharacterAndFitness(CharacterAndFitness characterAndFitness) {
		return getCharacterAndFitnessDao().saveOrUpdateCharacterAndFitness(characterAndFitness);
	}

	@Override
	public boolean deleteCharacterAndFitness(CharacterAndFitness characterAndFitness) {
		return getCharacterAndFitnessDao().deleteCharacterAndFitness(characterAndFitness);
	}
	
	@Override
	public List<CharacterAndFitness> getCharacterAndFitnessForUser(User user) {
		return getCharacterAndFitnessDao().getCharacterAndFitnessForUser(user);
	}	

	public CharacterAndFitnessDao getCharacterAndFitnessDao() {
		return characterAndFitnessDao;
	}

	public void setCharacterAndFitnessDao(CharacterAndFitnessDao characterAndFitnessDao) {
		this.characterAndFitnessDao = characterAndFitnessDao;
	}			
}