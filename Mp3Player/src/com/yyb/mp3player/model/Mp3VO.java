package com.yyb.mp3player.model;

import java.io.Serializable;

public class Mp3VO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String mp3Name;
	private String mp3Size;
	public String getLrcName() {
		return lrcName;
	}

	public void setLrcName(String lrcName) {
		this.lrcName = lrcName;
	}

	public String getLrcSize() {
		return lrcSize;
	}

	public void setLrcSize(String lrcSize) {
		this.lrcSize = lrcSize;
	}

	private String lrcName;
	private String lrcSize;
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Mp3VO [id=" + id + ", mp3Name=" + mp3Name + ", pm3Size="
				+ mp3Size + ", lrcName=" + lrcName + ", lrcSize=" + lrcSize
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lrcName == null) ? 0 : lrcName.hashCode());
		result = prime * result + ((lrcSize == null) ? 0 : lrcSize.hashCode());
		result = prime * result + ((mp3Name == null) ? 0 : mp3Name.hashCode());
		result = prime * result + ((mp3Size == null) ? 0 : mp3Size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mp3VO other = (Mp3VO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lrcName == null) {
			if (other.lrcName != null)
				return false;
		} else if (!lrcName.equals(other.lrcName))
			return false;
		if (lrcSize == null) {
			if (other.lrcSize != null)
				return false;
		} else if (!lrcSize.equals(other.lrcSize))
			return false;
		if (mp3Name == null) {
			if (other.mp3Name != null)
				return false;
		} else if (!mp3Name.equals(other.mp3Name))
			return false;
		if (mp3Size == null) {
			if (other.mp3Size != null)
				return false;
		} else if (!mp3Size.equals(other.mp3Size))
			return false;
		return true;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMp3Name() {
		return mp3Name;
	}

	public void setMp3Name(String mp3Name) {
		this.mp3Name = mp3Name;
	}

	public String getMp3Size() {
		return mp3Size;
	}

	public void setMp3Size(String mp3Size) {
		this.mp3Size = mp3Size;
	}

	
}
