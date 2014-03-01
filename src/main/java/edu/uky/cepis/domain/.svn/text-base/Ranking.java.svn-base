package edu.uky.cepis.domain;

/**
 * Role Class to store the role information of a user
 */
public class Ranking implements java.util.Comparator<Ranking>,
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String rankingCode;
	private String title;
	private String program;

	/**
	 * 
	 */
	public Ranking() {
	}

	/**
	 * @param rankingCode
	 * @param title
	 * @param program
	 */
	public Ranking(String rankingCode, String title, String program) {
		this.rankingCode = rankingCode;
		this.title = title;
		this.program = program;
	}

	/**
	 * @return  the rankingCode
	 * @uml.property  name="rankingCode"
	 */
	public String getRankingCode() {
		return rankingCode;
	}

	/**
	 * @param rankingCode  the rankingCode to set
	 * @uml.property  name="rankingCode"
	 */
	public void setRankingCode(String rankingCode) {
		this.rankingCode = rankingCode;
	}

	/**
	 * @return  the title
	 * @uml.property  name="title"
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title  the title to set
	 * @uml.property  name="title"
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return  the program
	 * @uml.property  name="program"
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program  the program to set
	 * @uml.property  name="program"
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	@Override
	public int compare(Ranking o1, Ranking o2) {
		return o1.getRankingCode().compareToIgnoreCase(o2.getRankingCode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((program == null) ? 0 : program.hashCode());
		result = prime * result
				+ ((rankingCode == null) ? 0 : rankingCode.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ranking other = (Ranking) obj;
		if (program == null) {
			if (other.program != null)
				return false;
		} else if (!program.equals(other.program))
			return false;
		if (rankingCode == null) {
			if (other.rankingCode != null)
				return false;
		} else if (!rankingCode.equals(other.rankingCode))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%-5s) %-25s - %-50s", this.getRankingCode(),this.getTitle(),this.getProgram());
	}
}
