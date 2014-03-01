package edu.uky.cepis.dao;

import java.util.List;

import edu.uky.cepis.domain.Letter;
import edu.uky.cepis.domain.User;

/**
 * @author cawalk4
 *
 */
public interface LetterDao{
	
	public abstract Letter findLetterById(long id);
	
	public abstract List<Letter> getLettersByExample(Letter letter);
	
	public abstract List<Letter> getLettersForUser(User user);
	
	public abstract boolean saveOrUpdateLetter(Letter letter);
	
	public abstract boolean deleteLetter(Letter letter);
}