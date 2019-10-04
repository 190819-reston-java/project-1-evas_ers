package com.revature.model;

public class Image {

	private int imageid;
	private String imagename;
	private byte[] image;
	
	//generated by Source Menu - Constructor
	public Image(int imageid, String imagename, byte[] image) {
		super();
		this.imageid = imageid;
		this.imagename = imagename;
		this.image = image;
		
	}
	//generated by Source Menu - Getters and Setters
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	//default constructor for jackson
		public Image() {
			super();
		}
	
	//generated by Source Menu - toString (did not include byte[] image)
	@Override
	public String toString() {
		return "Image [imageid=" + imageid + ", imagename=" + imagename +  "]";
	}
	
}
