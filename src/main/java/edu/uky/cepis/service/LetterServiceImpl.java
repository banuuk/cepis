

package edu.uky.cepis.service;

import java.util.List;

import edu.uky.cepis.dao.LetterDao;
import edu.uky.cepis.domain.Letter;
import edu.uky.cepis.domain.User;

public class LetterServiceImpl implements LetterService{
	
	private LetterDao letterDao;
	
	@Override
	public Letter findLetterById(long id) {
		return getLetterDao().findLetterById(id);
	}

	@Override
	public List<Letter> getLettersByExample(Letter letter) {
		return getLetterDao().getLettersByExample(letter);
	}

	@Override
	public boolean saveOrUpdateLetter(Letter letter) {
		return getLetterDao().saveOrUpdateLetter(letter);
	}

	@Override
	public boolean deleteLetter(Letter letter) {
		return getLetterDao().deleteLetter(letter);
	}
	
	@Override
	public List<Letter> getLettersForUser(User user) {
		return getLetterDao().getLettersForUser(user);
	}
	
	public LetterDao getLetterDao() {
		return letterDao;
	}

	public void setLetterDao(LetterDao letterDao) {
		this.letterDao = letterDao;
	}

}