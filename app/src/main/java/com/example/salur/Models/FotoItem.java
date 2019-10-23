package com.example.salur.Models;

import com.google.gson.annotations.SerializedName;

public class FotoItem{

	@SerializedName("id_foto")
	private int idFoto;

	@SerializedName("id_post")
	private int idPost;

	@SerializedName("url_photo")
	private String urlPhoto;

	public void setIdFoto(int idFoto){
		this.idFoto = idFoto;
	}

	public int getIdFoto(){
		return idFoto;
	}

	public void setIdPost(int idPost){
		this.idPost = idPost;
	}

	public int getIdPost(){
		return idPost;
	}

	public void setUrlPhoto(String urlPhoto){
		this.urlPhoto = urlPhoto;
	}

	public String getUrlPhoto(){
		return urlPhoto;
	}

	@Override
 	public String toString(){
		return 
			"FotoItem{" + 
			"id_foto = '" + idFoto + '\'' + 
			",id_post = '" + idPost + '\'' + 
			",url_photo = '" + urlPhoto + '\'' + 
			"}";
		}
}