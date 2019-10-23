package com.example.salur.Models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class HomePostData{

	@SerializedName("deskripsi_post")
	private String deskripsiPost;

	@SerializedName("foto")
	private List<FotoItem> foto;

	@SerializedName("id_post")
	private int idPost;

	@SerializedName("judul_post")
	private String judulPost;

	@SerializedName("tanggal_post")
	private Object tanggalPost;

	public void setDeskripsiPost(String deskripsiPost){
		this.deskripsiPost = deskripsiPost;
	}

	public String getDeskripsiPost(){
		return deskripsiPost;
	}

	public void setFoto(List<FotoItem> foto){
		this.foto = foto;
	}

	public List<FotoItem> getFoto(){
		return foto;
	}

	public void setIdPost(int idPost){
		this.idPost = idPost;
	}

	public int getIdPost(){
		return idPost;
	}

	public void setJudulPost(String judulPost){
		this.judulPost = judulPost;
	}

	public String getJudulPost(){
		return judulPost;
	}

	public void setTanggalPost(Object tanggalPost){
		this.tanggalPost = tanggalPost;
	}

	public Object getTanggalPost(){
		return tanggalPost;
	}

	@Override
 	public String toString(){
		return 
			"HomePostData{" + 
			"deskripsi_post = '" + deskripsiPost + '\'' + 
			",foto = '" + foto + '\'' + 
			",id_post = '" + idPost + '\'' + 
			",judul_post = '" + judulPost + '\'' + 
			",tanggal_post = '" + tanggalPost + '\'' + 
			"}";
		}
}