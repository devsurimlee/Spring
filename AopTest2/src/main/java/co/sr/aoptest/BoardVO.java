package co.sr.aoptest;

public class BoardVO {
	
	private int id;
	private String title;
	private String contents;
	private String writer;
	private int hit;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", hit="
				+ hit + "]";
	}
	
}
